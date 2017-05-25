package controller;

public class AvatarMaker {

    private Avatar SuperPowerTools;
    private Avatar PowerTool;

    public AvatarMaker(){
        SuperPowerTools = new SuperPowerTools();
        PowerTool = new PowerTool();
    }

    public String addSuperPower(){
        SuperPowerTools.add();
        return "-super.png";
   }

    public void removeSuperPower(){
        SuperPowerTools.remove();
    }

    public String addPower(){
        PowerTool.add();
        return "-power.png";
    }

    public void removePower(){

    }
}
