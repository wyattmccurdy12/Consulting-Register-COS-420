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
        CSController controller = new CSController();
        new CSView(controller);
    }
}