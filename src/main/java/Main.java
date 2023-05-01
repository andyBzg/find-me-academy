import classes.*;

public class Main {
    public static void main(String[] args) {

        String file = "src/main/resources/Universities.txt";
        App app = new App(file);
        app.start();
    }
}
