package enums;

public enum Command {

    STOP("/stop");

    private final String cmd;


    Command(String cmd) {
        this.cmd = cmd;
    }

    public String getCmd() {
        return cmd;
    }
}
