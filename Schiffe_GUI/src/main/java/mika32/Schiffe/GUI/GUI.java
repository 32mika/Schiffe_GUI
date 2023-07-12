package mika32.Schiffe.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.file.attribute.AclEntry;

public class GUI {
    JFrame frame;
    JPanel choice;
    JLayeredPane panelOrder = new JLayeredPane();
    public GUI(){
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
        background.setBounds(0,0,frame.getWidth(), frame.getHeight());

    }

    public void genGui() {
        frame.add(panelOrder);
        panelOrder.setBounds(0,0, frame.getWidth(), frame.getHeight());

    }

    private JPanel createBackground() {
        Image image = Toolkit.getDefaultToolkit().getImage("/Users/mikadobrowolski/Schiffe_GUI/src/main/resources/JFrame_Hintergrund1.png");

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        return panel;
    }
    public void init(){
        sizeChoice();
    }

    private void sizeChoice(){
        choice = new JPanel();
        JLabel xFeldSize = new JLabel();
        JLabel yFeldsize = new JLabel();

        choice.setSize(400, 300);
        choice.setBackground(new Color(15, 172, 212, 203));
        choice.setLayout(null);
        
        xFeldSize = sizeDisplayBuild(50, 50);

        choice.add(xFeldSize);

        panelOrder.add(choice);
        choice.setBounds(frame.getWidth() /2 - choice.getWidth() /2, frame.getHeight() /2 - choice.getHeight() /2 , 400, 300);
        panelOrder.moveToFront(choice);

    }
    
    private JLabel sizeDisplayBuild(int xPos, int yPos){
        JLabel label = new JLabel();
        int labelX = 45;
        int labelY = 45;

        label.setOpaque(true);
        label.setBounds(xPos, yPos, labelX, labelY);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setText("10");
        label.setForeground(Color.white);
        label.setBackground(new Color(8, 22, 142));

        return label;
    }
}
