package mika32.Schiffe.GUI;

import javax.swing.*;
import java.awt.*;

public class GUI {
    JFrame frame;
    JPanel choice;
    JLayeredPane panelOrder = new JLayeredPane();
    Font bigFont = new Font("Arial", Font.BOLD, 33);
    int fieldSize = 10;
    int shotsFired;
    public String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I","J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "O", "V", "W", "X", "Y", "Z"};


    public GUI() {
        frame = new JFrame();
        JPanel background = createBackground();

        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Schiffeversenken v1.0");
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);


        panelOrder.add(background);
        panelOrder.setLayout(null);
        panelOrder.moveToBack(background);
        background.setBounds(0, 0, frame.getWidth(), frame.getHeight());

    }

    protected JPanel createBackground() {
        Image image = Toolkit.getDefaultToolkit().getImage("/Users/mikadobrowolski/Schiffe_GUI/src/main/resources/JFrame_Hintergrund.png");

        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
    }

    protected void startGameScreen(){
        JPanel backG;

        frame.setSize(1200, 850);
        frame.setLocationRelativeTo(null);

        panelOrder.removeAll();
        panelOrder.setBounds(0,0, frame.getWidth(), frame.getHeight());

        backG = createBackground();

        panelOrder.add(backG);
        panelOrder.moveToBack(backG);
        backG.setBounds(0,0, panelOrder.getWidth(), panelOrder.getHeight());

        GridLayer.addButton();
        GridLayer.addVertLabel();
        GridLayer.addHorLabel();
        SchiffeInfos.infoPanel();

    }

    public void init() {
        frame.add(panelOrder);
        panelOrder.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        startingTheme startTheme = new startingTheme();
        startTheme.sizeChoice();
    }

    protected void loadingScene(JPanel giveCh){
        LoadingBar fakeLoad = new LoadingBar();
        JPanel loadingPanel = new JPanel();

        loadingPanel.setSize(400, 300);
        loadingPanel.setBackground(new Color(15, 172, 212, 203));
        loadingPanel.setLayout(null);

        loadingPanel = fakeLoad.create(giveCh);
        panelOrder.add(loadingPanel);
        loadingPanel.setBounds(frame.getWidth() /2 - loadingPanel.getWidth() /2, frame.getHeight() /2 - loadingPanel.getHeight() /2 , 400, 300);
        panelOrder.moveToFront(loadingPanel);
    }

    public void won(){
        JOptionPane.showMessageDialog(null, "You won! And used " + shotsFired + " shots on the " + fieldSize + "x" + fieldSize, "You won!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(404);

    }

    public int getFieldSize(){
        return fieldSize;
    }
}