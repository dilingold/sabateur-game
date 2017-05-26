package controller;

public class AvatarMaker {

    private Avatar SuperPowerTools;
    private Avatar PowerTool;
    protected String name;

    public AvatarMaker(){
        SuperPowerTools = new SuperPowerTools();
        PowerTool = new PowerTool();
    }

    public void addSuperPower(){

        SuperPowerTools.getName();

   }

    public void addPower(){
        PowerTool.getName();
    }

    public void removePower(){

    }
}
