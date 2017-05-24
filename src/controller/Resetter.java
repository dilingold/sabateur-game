package controller;

//invoker

public class Resetter {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    public void invokeReset() {
        command.execute();
    }
}
