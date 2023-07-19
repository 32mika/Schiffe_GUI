package mika32.Schiffe.GUI;

import mika32.Schiffe.Main;
import mika32.Schiffe.Utils.TxtSize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayer {
    static Font bigFont = Main.getGUI().bigFont;
    static String[] alphabet = Main.getGUI().alphabet;
    static int fieldSize = Main.getGUI().fieldSize;
    static JPanel buttonLayer;
    static Font buttonFont;


    protected static void addButton(){
        buttonLayer = new JPanel(new GridLayout(fieldSize, fieldSize, 3 ,3));

        int count = 0;


        buttonLayer.setSize(800, 700);
        buttonLayer.setOpaque(false);

        for(int i = 0; i < fieldSize; i++){
            for(int d = 0; d < fieldSize; d++){
                JButton button = new JButton();
                button.setSize(buttonLayer.getWidth() / fieldSize, buttonLayer.getHeight() / fieldSize);

                button.setFont(bigFont);
                button.setText(alphabet[i] + (d + 1));

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(Main.getShipHash().contains(button.getText())){
                            Main.getFiredHash().add(button.getText());

                            button.setForeground(Color.RED);
                            button.setText("Hit");

                            Main.getGUI().shotsFired++;
                            SchiffeInfos.infoPanel();

                            if(Main.getShipHash().equals(Main.getFiredHash())){
                                try {
                                    Thread.sleep(250);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }

                                Main.won();
                            }

                        }else if(button.getText().equals("Hit") | button.getText().equals("W")){
                        }else{
                            button.setForeground(Color.BLUE);
                            button.setText("W");

                            Main.getGUI().shotsFired++;
                            SchiffeInfos.infoPanel();
                        }
                    }
                });

                Font fnt = TxtSize.getAdjustedFont(button, bigFont);

                buttonFont = fnt;
                button.setFont(fnt);
                buttonLayer.add(button);
            }
        }

        Main.getGUI().panelOrder.add(buttonLayer);
        Main.getGUI().panelOrder.moveToFront(buttonLayer);
        buttonLayer.setBounds(55, 55, 800, 700);
    }

    protected static void addVertLabel(){
        JPanel gridLabels = new JPanel(new GridLayout(fieldSize, 1, 0 , 5));


        gridLabels.setSize(30, buttonLayer.getHeight());
        gridLabels.setOpaque(false);

        for(int i = 0; i < fieldSize; i++){
            JLabel label = new JLabel();

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setOpaque(true);
            label.setFont(buttonFont);
            label.setBackground(Color.blue);
            label.setForeground(Color.white);
            label.setText(alphabet[i]);


            gridLabels.add(label);
        }

        Main.getGUI().panelOrder.add(gridLabels);
        Main.getGUI().panelOrder.moveToFront(gridLabels);
        gridLabels.setBounds(13, 48, gridLabels.getWidth(), gridLabels.getHeight());
    }

    protected static void addHorLabel(){
        JPanel gridLabels = new JPanel(new GridLayout(1, fieldSize, 10, 0));


        gridLabels.setSize(buttonLayer.getWidth(), 50);
        gridLabels.setOpaque(false);

        for(int i = 0; i < fieldSize; i++){
            JLabel label = new JLabel();

            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setOpaque(true);
            label.setFont(buttonFont);
            label.setBackground(Color.blue);
            label.setForeground(Color.white);
            label.setText(Integer.toString(i +1));


            gridLabels.add(label);
        }

        Main.getGUI().panelOrder.add(gridLabels);
        Main.getGUI().panelOrder.moveToFront(gridLabels);
        gridLabels.setBounds(55, 5, gridLabels.getWidth(), gridLabels.getHeight());


    }

}
