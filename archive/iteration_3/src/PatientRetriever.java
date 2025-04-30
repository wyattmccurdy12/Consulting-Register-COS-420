import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The PatientRetriever class is responsible for retrieving patient data which 
 * is stored as a CSV file. It supports lookup by patient ID or by name and DOB.
 */
public class PatientRetriever {

    private String patientCsvPath = "archive/iteration_3/data/ConsultingRegisterPatients.csv";
    private SimpleDateFormat df = new SimpleDateFormat("M/d/yyyy");

    /**
     * Retrieves a patient by their unique ID.
     *
     * @param patientId the ID of the patient to retrieve
     * @return a Patient object if found, otherwise null
     */
    public Patient retrievePatientById(String patientId) {
        try (BufferedReader br = new BufferedReader(new FileReader(patientCsvPath))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",", -1);
                if (fields[0].equalsIgnoreCase(patientId)) {
                    return parsePatient(fields);
                }
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error reading patient records: " + e.getMessage());
        }
        System.out.println("Patient with ID " + patientId + " not found.");
        return null;
    }

    /**
     * Retrieves a patient by matching name and date of birth.
     *
     * @param name the full name of the patient
     * @param dob the date of birth of the patient
     * @return a Patient object if exactly one match is found, otherwise null
     */
    public Patient retrieveByNameDob(String name, Date dob) {
        try (BufferedReader br = new BufferedReader(new FileReader(patientCsvPath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",", -1);
                String recordName = fields[2];
                Date recordDob = df.parse(fields[1]);
                if (recordName.equalsIgnoreCase(name) && recordDob.equals(dob)) {
                    return parsePatient(fields);
                }
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error reading patient records by name/DOB: " + e.getMessage());
        }
        System.out.println("Patient named " + name + " with DOB " + df.format(dob) + " not found.");
        return null;
    }

    /**
     * Parses a CSV fields array into a Patient object.
     *
     * @param fields the CSV columns: [0]=ID, [1]=DOB, [2]=Name, etc.
     * @return a new GeneralPatient instance
     * @throws ParseException if date parsing fails
     */
    private Patient parsePatient(String[] fields) throws ParseException {
        String patientId = fields[0];
        Date dateOfBirth = df.parse(fields[1]);
        String name = fields[2];
        String outPatientNumber = fields[3];
        String healthInsuranceNumber = fields[4];
        String nationalIdentificationNumber = fields[5];
        String address = fields[6];
        String sex = fields[7];
        int age = Integer.parseInt(fields[8]);
        String motherId = fields[9];
        List<Record> records = new ArrayList<>(); // Assuming records are not stored in the CSV

        return new GeneralPatient(dateOfBirth, name,
                outPatientNumber, healthInsuranceNumber,
                nationalIdentificationNumber, address, sex,
                age, motherId, records);
    }
}
