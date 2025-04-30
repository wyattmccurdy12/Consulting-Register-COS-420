/**
 * IDGenerator is a singleton class responsible for generating unique IDs
 * for patients, clinics, and records in the system.
 */
public class IDGenerator {
    private static IDGenerator instance;
    private int patientCounter = 0;
    private int clinicCounter = 0;
    private int recordCounter = 0;

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private IDGenerator() {
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
