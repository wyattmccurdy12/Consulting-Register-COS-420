import java.text.SimpleDateFormat;

/**
 * MainApp serves as the entry point for the Consulting Register application.
 * It initializes the controller and view components.
 */
public class MainApp {

    /**
     * The main method that starts the application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("M/d/yyyy");
        SimpleDateFormat dtf = new SimpleDateFormat("M/d/yyyy HH:mm:ss");
        PatientRetriever patientRetriever = new PatientRetriever("archive/iteration_3/data/ConsultingRegisterPatients.csv", df);
        VisitRetriever visitRetriever = new VisitRetriever("archive/iteration_3/data/ConsultingRegisterVisits.csv", dtf);
        CSModel model = new CSModel();
        CSController controller = new CSController(patientRetriever, visitRetriever, model);
        new CSView(controller, model);
    }
}