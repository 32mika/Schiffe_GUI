package mika32.Schiffe.GUI;

import mika32.Schiffe.Main;

import javax.swing.*;
import java.awt.*;

public class SchiffeInfos {
    static Color col = new Color(8, 22, 142);
    static Font bigFont = Main.getGUI().bigFont;
    static JPanel infoPanel;
    
    public static void infoPanel(){
        infoPanel = new JPanel();

        infoPanel.setOpaque(false);
        infoPanel.setLayout(null);
        infoPanel.setSize(Main.getGUI().frame.getWidth() - GridLayer.buttonLayer.getWidth(), Main.getGUI().frame.getHeight());

        infoPanel.add(labelBuild("Fieldsize: ", Integer.toString(Main.getGUI().fieldSize), "", 55, 5, 200));
        infoPanel.add(labelBuild("Fired Shots: ", Integer.toString(Main.getGUI().shotsFired), "", 55, 60, 250));

        infoPanel.add(labelBuild("W = Water", "", "", 55, infoPanel.getHeight() /2 -100, 180));
        infoPanel.add(labelBuild("Hit = Ship", "", "", 55, infoPanel.getHeight() /2 - 45, 180));

        /*
        infoPanel.add(infoShootHit());
        infoPanel.add(shipTypeLabel());
         */

        Main.getGUI().panelOrder.add(infoPanel);
        infoPanel.setBounds(GridLayer.buttonLayer.getWidth() + 75, 0 , Main.getGUI().frame.getWidth() - GridLayer.buttonLayer.getWidth(), Main.getGUI().frame.getHeight());
        Main.getGUI().panelOrder.moveToFront(infoPanel);

    }

    private static JPanel shipTypeLabel(){
        JPanel typePanel = new JPanel();

        infoPanel.setOpaque(false);
        infoPanel.setLayout(null);
        infoPanel.setSize(Main.getGUI().frame.getWidth() - GridLayer.buttonLayer.getWidth(), Main.getGUI().frame.getHeight());

        return typePanel;
    }

    private static JLabel infoShootHit(){
        JLabel hitInfo = new JLabel();

        hitInfo.setOpaque(true);
        hitInfo.setFont(bigFont);
        hitInfo.setLayout(null);
        hitInfo.setText("Hit = Ship");
        hitInfo.setForeground(Color.white);
        hitInfo.setBorder(BorderFactory.createSoftBevelBorder(1));
        hitInfo.setBackground(col);
        hitInfo.setBounds(55, infoPanel.getHeight() /2 - 45, 180,50);

        return hitInfo;
    }

    private static JLabel labelBuild(String text1, String text2, String text3, int x, int y, int width){
        JLabel feldLabel = new JLabel();

        feldLabel.setOpaque(true);
        feldLabel.setFont(bigFont);
        feldLabel.setText(text1 + text2 + text3);
        feldLabel.setForeground(Color.white);
        feldLabel.setBorder(BorderFactory.createSoftBevelBorder(1));
        feldLabel.setBackground(col);
        feldLabel.setBounds(x, y, width,50);

        return feldLabel;
    }

}
