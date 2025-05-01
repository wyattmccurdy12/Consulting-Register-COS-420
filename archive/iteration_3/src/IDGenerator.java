import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * IDGenerator is a singleton class responsible for generating unique IDs
 * for patients, clinics, and records in the system.
 */
public class IDGenerator {
    private static IDGenerator instance;
    private int patientCounter = 0;
    private int clinicCounter = 0;
    private int recordCounter = 0;

    private static final String PATIENTS_CSV = "archive/iteration_3/data/ConsultingRegisterPatients.csv";
    private static final String CLINICS_CSV = "archive/iteration_3/data/ConsultingRegisterClinics.csv";
    /**
     * Private constructor to prevent instantiation from outside the class.
     * Initializes counters based on existing IDs in the CSV files.
     */
    private IDGenerator() {
        initializeCounters();
    }

    /**
     * Returns the singleton instance of the IDGenerator.
     *
     * @return The singleton instance of IDGenerator.
     */
    public static synchronized IDGenerator getInstance() {
        if (instance == null) {
            instance = new IDGenerator();
        }
        return instance;
    }

    /**
     * Initializes counters by scanning existing IDs in the CSV files.
     */
    private void initializeCounters() {
        patientCounter = getMaxIdFromCsv(PATIENTS_CSV, "PAT-");
        clinicCounter = getMaxIdFromCsv(CLINICS_CSV, "CLIN-");
    }

    /**
     * Scans a CSV file for the highest numeric ID with the given prefix.
     *
     * @param filePath The path to the CSV file.
     * @param prefix   The prefix of the IDs to scan.
     * @return The highest numeric ID found, or 0 if none are found.
     */
    private int getMaxIdFromCsv(String filePath, String prefix) {
        int maxId = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",", -1);
                if (fields.length > 0 && fields[0].startsWith(prefix)) {
                    String numericPart = fields[0].substring(prefix.length());
                    maxId = Math.max(maxId, Integer.parseInt(numericPart));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading IDs from " + filePath + ": " + e.getMessage());
        }
        return maxId;
    }

    /**
     * Generates a unique ID for a patient.
     *
     * @return A unique patient ID in the format "PAT-{number}".
     */
    public synchronized String generatePatientId() {
        patientCounter++;
        return "PAT-" + patientCounter;
    }

    /**
     * Generates a unique ID for a clinic.
     *
     * @return A unique clinic ID in the format "CLIN-{number}".
     */
    public synchronized String generateClinicId() {
        clinicCounter++;
        return "CLIN-" + clinicCounter;
    }

    /**
     * Generates a unique ID for a record.
     *
     * @return A unique record ID in the format "REC-{number}".
     */
    public synchronized String generateRecordId() {
        recordCounter++;
        return "REC-" + recordCounter;
    }
}
