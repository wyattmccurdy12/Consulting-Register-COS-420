import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * CSController acts as the controller in the MVC architecture for the Consulting Register application.
 * It handles business logic for retrieving patients, adding new patients, and recording visits.
 */
public class CSController {
    private PatientRetriever patientRetriever;
    private String patientsCsv = "archive/iteration_3/data/ConsultingRegisterPatients.csv";
    private String visitsCsv   = "archive/iteration_3/data/ConsultingRegisterVisits.csv";
    private SimpleDateFormat df  = new SimpleDateFormat("M/d/yyyy");
    private SimpleDateFormat dtf = new SimpleDateFormat("M/d/yyyy HH:mm:ss");

    /**
     * Constructs a CSController instance and ensures both CSV files exist with headers.
     */
    public CSController() {
        this.patientRetriever = new PatientRetriever();
        ensureCsvExists(patientsCsv,
            "patientId,dateOfBirth,name,outPatientNumber,healthInsuranceNumber,nationalIdentificationNumber,address,sex,age,motherId");
        ensureCsvExists(visitsCsv,
            "patientId,clinicId,date,bloodPressure,pulse,temperature,weight,respiration,conditionHistory,principalDiagnosis,additionalDiagnosis,treatmentGiven,referred,outcomeOfReferral,costOfTreatment,remarks");
    }

    /**
     * Ensures that a CSV file exists at the specified path. If the file does not exist, it creates
     * the file along with any necessary parent directories and writes the provided header as the
     * first line of the file.
     *
     * @param path   The path to the CSV file.
     * @param header The header line to write to the file if it is created.
     */
    private void ensureCsvExists(String path, String header) {
        File f = new File(path);
        if (!f.exists()) {
            try {
                f.getParentFile().mkdirs();
                try (PrintWriter pw = new PrintWriter(new FileWriter(f))) {
                    pw.println(header);
                }
            } catch (IOException e) {
                System.err.println("Error creating CSV at " + path + ": " + e.getMessage());
            }
        }
    }

    /**
     * Retrieves a patient by ID (if non-blank) or by name & DOB.
     * @param id   the patient’s ID (may be blank)
     * @param name the patient’s full name (used if ID blank)
     * @param dob  the patient’s date of birth (used if ID blank)
     * @return matching Patient or null
     */
    public Patient retrievePatient(String id, String name, Date dob) {
        if (id != null && !id.isBlank()) {
            return patientRetriever.retrievePatientById(id);
        } else if (name != null && dob != null) {
            return patientRetriever.retrieveByNameDob(name, dob);
        }
        return null;
    }

    /**
     * Reads all visits for a given patient from the visits CSV.
     * @param patientId the ID of the patient
     * @return list of Visit objects (empty list if none)
     */
    public List<Visit> getVisitsForPatient(String patientId) {
        List<Visit> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(visitsCsv))) {
            br.readLine();  // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] f = line.split(",", -1);
                if (!f[0].equals(patientId)) continue;
                Date date;
                try {
                    date = dtf.parse(f[2]);
                } catch (ParseException pe) {
                    date = df.parse(f[2]);
                }
                Visit v = new Visit(
                    f[0], f[1], date,
                    f[3], f[4],
                    Float.parseFloat(f[5]), Float.parseFloat(f[6]),
                    f[7], f[8], f[9], f[10], f[11],
                    Boolean.parseBoolean(f[12]), f[13],
                    Float.parseFloat(f[14]), f[15]
                );
                list.add(v);
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error reading visits: " + e.getMessage());
        }
        return list;
    }

    /**
     * Records a new visit by appending it to the visits CSV, storing full date+time.
     * @param v the Visit object to record
     * @return true on success, false on I/O error
     */
    public boolean recordVisit(Visit v) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(visitsCsv, true))) {
            pw.printf(
              "%s,%s,%s,%s,%s,%.1f,%.1f,%s,%s,%s,%s,%s,%b,%s,%.2f,%s%n",
              v.getPatientId(),
              v.getClinicId(),
              dtf.format(v.getDate()),
              v.getBloodPressure(),
              v.getPulse(),
              v.getTemperature(),
              v.getWeight(),
              v.getRespiration(),
              v.getConditionHistory(),
              v.getPrincipalDiagnosis(),
              v.getAdditionalDiagnosis(),
              v.getTreatmentGiven(),
              v.isReferred(),
              v.getOutcomeOfReferral(),
              v.getCostOfTreatment(),
              v.getRemarks()
            );
            return true;
        } catch (IOException e) {
            System.err.println("Error writing visit: " + e.getMessage());
            return false;
        }
    }

    /**
     * Adds a new patient by appending to the patients CSV.
     * @param p the Patient to add
     * @return true on success, false on I/O error
     */
    public boolean addPatient(Patient p) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(patientsCsv, true))) {
            pw.printf(
              "%s,%s,%s,%s,%s,%s,%s,%s,%d,%s%n",
              p.getPatientId(),
              df.format(p.getDateOfBirth()),
              p.getName(),
              p.getOutPatientNumber(),
              p.getHealthInsuranceNumber(),
              p.getNationalIdentificationNumber(),
              p.getAddress(),
              p.getSex(),
              p.getAge(),
              p.getMotherId()
            );
            return true;
        } catch (IOException e) {
            System.err.println("Error writing patient: " + e.getMessage());
            return false;
        }
    }
}
