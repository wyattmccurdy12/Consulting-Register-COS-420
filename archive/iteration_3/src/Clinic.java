
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.File;

public class Clinic {
    private String clinicId;
    private String facility;
    private String chpsZone;
    private String subDistrict;
    private String district;
    private List<Patient> patients;
    private List<Visit> visits;
    private Map<String, Patient> patientMap;

    // Constructor
    public Clinic(String facility, String chpsZone, String subDistrict, String district) {
        this.clinicId = IDGenerator.getInstance().generateClinicId();
        this.facility = facility;
        this.chpsZone = chpsZone;
        this.subDistrict = subDistrict;
        this.district = district;
        this.patients = new ArrayList<>();
        this.visits = new ArrayList<>();
        this.patientMap = new HashMap<>();
    }

    // Add a new patient to the clinic
    public void addPatient(Patient patient) {
        patient.setPatientId(IDGenerator.getInstance().generatePatientId());
        patients.add(patient);
        patientMap.put(patient.getPatientId(), patient);
    }

    // Record a new visit
    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    /**
     * Generates an outpatient morbidity report for the current month and writes it to a CSV file.
     */
    public void generateMorbidityReport() {
        String[] diseases = loadDiseasesFromFile("data/diseases.txt");
        if (diseases == null) {
            return; // Exit if diseases file could not be loaded
        }

        int[][] maleData = new int[diseases.length][11];
        int[][] femaleData = new int[diseases.length][11];

        Calendar now = Calendar.getInstance();
        int reportMonth = now.get(Calendar.MONTH);
        int reportYear = now.get(Calendar.YEAR);

        aggregateVisitData(diseases, maleData, femaleData, reportMonth, reportYear);

        // Prepare output filename
        String fileName = "Morbidity_Report_" + (reportMonth + 1) + "-" + reportYear + ".csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Header information
            writer.println("Month," + (reportMonth + 1));
            writer.println("Clinic ID," + clinicId);
            writer.println("CHPS Zone," + chpsZone);
            writer.println("Facility Name," + facility);
            writer.println("District," + district);
            writer.println("Region," + subDistrict);
            writer.println();

            // Column headers
            StringBuilder header = new StringBuilder("Disease");
            for (int j = 0; j < 11; j++) {
                header.append(",Male ").append(getAgeRange(j));
            }
            header.append(",Male Total");
            for (int j = 0; j < 11; j++) {
                header.append(",Female ").append(getAgeRange(j));
            }
            header.append(",Female Total");
            writer.println(header.toString());

            // Data rows
            for (int k = 0; k < diseases.length; k++) {
                StringBuilder row = new StringBuilder(diseases[k]);
                int maleTotal = 0;
                for (int l = 0; l < 11; l++) {
                    int count = maleData[k][l];
                    row.append(",").append(count);
                    maleTotal += count;
                }
                row.append(",").append(maleTotal);

                int femaleTotal = 0;
                for (int l = 0; l < 11; l++) {
                    int count = femaleData[k][l];
                    row.append(",").append(count);
                    femaleTotal += count;
                }
                row.append(",").append(femaleTotal);
                writer.println(row.toString());
            }
        } catch (IOException e) {
            System.err.println("Error writing morbidity report: " + e.getMessage());
        }
    }

    /**
     * Aggregates visit data for the specified month and year.
     * @param diseases Array of diseases.
     * @param maleData Data array for male patients.
     * @param femaleData Data array for female patients.
     * @param reportMonth The month for the report.
     * @param reportYear The year for the report.
     */
    private void aggregateVisitData(String[] diseases, int[][] maleData, int[][] femaleData, int reportMonth, int reportYear) {
        Calendar visitCal = Calendar.getInstance();
        for (Visit visit : visits) {
            Date date = visit.getDate();
            visitCal.setTime(date);
            int vMonth = visitCal.get(Calendar.MONTH);
            int vYear = visitCal.get(Calendar.YEAR);
            if (vMonth == reportMonth && vYear == reportYear) {
                String diag = visit.getPrincipalDiagnosis();
                int i = Arrays.asList(diseases).indexOf(diag);
                if (i < 0) {
                    continue; // skip unknown diagnoses
                }
                Patient p = patientMap.get(visit.getPatientId());
                if (p == null) {
                    continue; // skip visits without patient info
                }
                int ageIndex = getAgeIndex(p.getAge());
                if ("Male".equalsIgnoreCase(p.getSex())) {
                    maleData[i][ageIndex]++;
                } else {
                    femaleData[i][ageIndex]++;
                }
            }
        }
    }

    /**
     * Loads the list of diseases from a file.
     * @param filePath The path to the diseases file.
     * @return An array of diseases or null if an error occurs.
     */
    private String[] loadDiseasesFromFile(String filePath) {
        String[] diseases = {};
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    diseases = Arrays.copyOf(diseases, diseases.length + 1);
                    diseases[diseases.length - 1] = line;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading diseases file: " + e.getMessage());
            return null;
        }
        return diseases;
    }

    // Map patient age to index (0=<1, 1=1-4, 2=5-9, ..., 10=70+)
    private int getAgeIndex(int age) {
        if (age < 1) return 0;
        if (age < 5) return 1;
        if (age < 10) return 2;
        if (age < 15) return 3;
        if (age < 18) return 4;
        if (age < 20) return 5;
        if (age < 35) return 6;
        if (age < 50) return 7;
        if (age < 60) return 8;
        if (age < 70) return 9;
        return 10;
    }

    // Return a string label for each age index
    private String getAgeRange(int index) {
        switch (index) {
            case 0: return "<1";
            case 1: return "1-4";
            case 2: return "5-9";
            case 3: return "10-14";
            case 4: return "15-17";
            case 5: return "18-19";
            case 6: return "20-34";
            case 7: return "35-49";
            case 8: return "50-59";
            case 9: return "60-69";
            case 10: return "70+";
            default: return "";
        }
    }
}
