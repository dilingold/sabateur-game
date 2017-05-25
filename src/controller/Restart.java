package controller;

//invoker

public class Restart {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    public void invokeReset() {
        command.execute();
    }
}
