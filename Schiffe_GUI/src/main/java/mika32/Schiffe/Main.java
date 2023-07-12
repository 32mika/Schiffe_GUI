package mika32.Schiffe;

import mika32.Schiffe.GUI.GUI;

public class Main {
    public static void main(String[] args) {
        run();

    }

    private static void run(){
        GUI gui = new GUI();
        gui.init();

        gui.genGui();
    }
}