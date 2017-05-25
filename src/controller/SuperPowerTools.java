package controller;

import controller.Avatar;

public class SuperPowerTools implements Avatar {

    @Override
    public String add(){
        String superPower = "-super.png";
        return superPower;
    }

    @Override
    public void remove(){
        System.out.println("hello2");
    }
}
