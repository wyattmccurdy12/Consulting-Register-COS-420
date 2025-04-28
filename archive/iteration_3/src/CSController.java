package src;
/**
 * CSController acts as the controller in the pseudo-MVC architecture for the Consulting Register application.
 * It handles the business logic and interacts with the PatientRetriever to fetch patient data.
 */
public class CSController {
    private PatientRetriever patientRetriever;

    /**
     * Constructs a CSController instance and initializes the PatientRetriever.
     */
    public CSController() {
        this.patientRetriever = new PatientRetriever();
    }

    /**
     * Retrieves a brief summary of a patient's information based on their ID.
     *
     * @param patientId The ID of the patient to search for.
     * @return A string message indicating whether the patient was found or not.
     *         If found, includes the patient's name.
     */
    public String getPatientInfo(String patientId) {
        Patient patient = patientRetriever.retrievePatientById(patientId);
        if (patient != null) {
            return "Patient found: " + patient.getName();
        } else {
            return "Patient not found.";
        }
    }

    /**
     * Retrieves detailed information for a specific patient.
     *
     * @param patientId The ID of the patient to retrieve.
     * @return A Patient object containing detailed information if found, otherwise null.
     */
    public Patient getPatientDetails(String patientId) {
        return patientRetriever.retrievePatientById(patientId);
    }
}
