package controller;

public class AvatarMaker {

    private Avatar SuperPowerTools;
    private Avatar PowerTool;
    protected String name;

    public AvatarMaker(){
        SuperPowerTools = new SuperPowerTools();
        PowerTool = new PowerTool();
    }

    public String addSuperPower(){
        SuperPowerTools.getName();
        return "-super.png";
   }

    public String addPower(){
        PowerTool.getName();
        return "-power.png";
    }

    public void removePower(){

    }
}
