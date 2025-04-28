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
}
