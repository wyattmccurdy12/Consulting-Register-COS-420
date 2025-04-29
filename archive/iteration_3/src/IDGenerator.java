public class IDGenerator {
    private static IDGenerator instance;
    private int patientCounter = 0;
    private int clinicCounter = 0;
    private int recordCounter = 0;

    private IDGenerator() {
    }

    public static synchronized IDGenerator getInstance() {
        if (instance == null) {
            instance = new IDGenerator();
        }
        return instance;
    }

    public synchronized String generatePatientId() {
        patientCounter++;
        return "PAT-" + patientCounter;
    }

    public synchronized String generateClinicId() {
        clinicCounter++;
        return "CLIN-" + clinicCounter;
    }

    public synchronized String generateRecordId() {
        recordCounter++;
        return "REC-" + recordCounter;
    }
}
