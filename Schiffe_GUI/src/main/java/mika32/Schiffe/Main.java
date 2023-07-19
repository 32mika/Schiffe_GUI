package mika32.Schiffe;

import mika32.Schiffe.GUI.GUI;

import java.util.HashSet;

public class Main {
    static GUI gui;
    private static HashSet<String> shipFields = new HashSet<String>();
    private static HashSet<String> firedShots = new HashSet<>();

    public static void main(String[] args) {
        run();
    }

    public static void won(){
        System.out.println("Spieler hat gewonnen!");
        gui.won();
    }

    private static void run(){
        gui = new GUI();
        gui.init();

    }

    public static HashSet<String> getShipHash(){
        return shipFields;
    }

    public static void setShipHash(HashSet<String> ship){
        shipFields = ship;
    }

    public static HashSet<String> getFiredHash(){
        return firedShots;
    }

    public static void setFiredHash(HashSet<String> ship){
        firedShots = ship;
    }
    
    public static GUI getGUI(){
        return gui;
    }
}