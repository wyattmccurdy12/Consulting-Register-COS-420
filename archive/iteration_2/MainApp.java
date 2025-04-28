public class MainApp {
    public static void main(String[] args) {
        CSController controller = new CSController();
        new CSView(controller);
    }
}