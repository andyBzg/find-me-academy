package enums;

public enum Command {

    STOP( "/stop");

    private final String cmd;

    public String getCmd() {
        return cmd;
    }

    Command(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return "ConsoleCommand{" +
                "cmd='" + cmd + '\'' +
                '}';
    }
}
