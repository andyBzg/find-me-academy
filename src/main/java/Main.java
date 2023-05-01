import classes.*;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {

        String file = "src/main/resources/Universities.txt";
        App app = new App(file);
        app.start();
    }
}
