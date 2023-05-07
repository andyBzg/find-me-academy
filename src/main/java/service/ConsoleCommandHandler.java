package service;

import enums.Command;

public class ConsoleCommandHandler {

    public void listenForStopCommand(String input) {
        if (input.matches(Command.STOP.getCmd())) {
            ApplicationStopper.stop();
        }
    }

}
