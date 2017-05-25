package controller;

import controller.Avatar;

public class PowerTool implements Avatar {

    @Override
    public String add(){

        String powerTool = "-power.png";
        return powerTool;
    }

    @Override
    public void remove(){
        System.out.println("hello2");
    }

}
