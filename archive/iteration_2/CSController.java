import java.util.List;

public class CSController {
    private PatientRetriever patientRetriever;

    public CSController() {
        this.patientRetriever = new PatientRetriever();
    }

    public String getPatientInfo(String patientId) {
        Patient patient = patientRetriever.retrievePatientById(patientId);
        if (patient != null) {
            return "Patient found: " + patient.getName();
        } else {
            return "Patient not found.";
        }
    }

    /**
     * Retrieves all patient records from the CSV file.
     *
     * @return A list of Patient objects.
     */
    public List<Patient> getAllPatients() {
        return new PatientRetriever().retrieveAllPatients();
    }

    /**
     * Retrieves detailed information for a specific patient.
     *
     * @param patientId The ID of the patient to retrieve.
     * @return A Patient object if found, otherwise null.
     */
    public Patient getPatientDetails(String patientId) {
        return patientRetriever.retrievePatientById(patientId);
    }
}
