package mika32.Schiffe.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.file.attribute.AclEntry;

public class GUI {
    JFrame frame;
    JPanel choice;
    JLayeredPane panelOrder = new JLayeredPane();
    Font bigFont = new Font("Arial", Font.BOLD, 33);
    int fieldSize = 10;

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
        Image image = Toolkit.getDefaultToolkit().getImage("C:/Users/Mika/IdeaProjects/Schiffe_GUI/Schiffe_GUI/Schiffe_GUI/src/main/resources/JFrame_Hintergrund1.png");

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
        JButton upButton = new JButton();
        JButton downButton = new JButton();
        Color col = new Color(8, 22, 142);

        choice.setSize(400, 300);
        choice.setBackground(new Color(15, 172, 212, 203));
        choice.setLayout(null);
        
        xFeldSize = sizeDisplayBuild(20, 30, "X");
        yFeldsize = sizeDisplayBuild(xFeldSize.getX() + xFeldSize.getWidth() + 10, xFeldSize.getY(), "Y");

        choice.add(xFeldSize);
        choice.add(yFeldsize);

        upButton = ButtonBuild(xFeldSize.getX(), xFeldSize.getHeight() + xFeldSize.getY() + 20);
        downButton = ButtonBuild(yFeldsize.getX(), xFeldSize.getHeight() + xFeldSize.getY() + 20);

        panelOrder.add(choice);
        choice.setBounds(frame.getWidth() /2 - choice.getWidth() /2, frame.getHeight() /2 - choice.getHeight() /2 , 400, 300);
        panelOrder.moveToFront(choice);
    }

    private JButton ButtonBuild(int xPos, int yPos){
        JButton button = new JButton();



        return button;
    }
    
    private JLabel sizeDisplayBuild(int xPos, int yPos, String type){
        JLabel label = new JLabel();
        Color col = new Color(8, 22, 142);
        Color col1 = new Color(0, 235, 255);
        int labelX = 175;
        int labelY = 65;

        label.setOpaque(true);
        label.setLayout(new FlowLayout());
        label.setBounds(xPos, yPos, labelX, labelY);
        label.setFont(bigFont);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setText("Size " + type + " : " + fieldSize);
        label.setForeground(Color.white);
        label.setBorder(BorderFactory.createSoftBevelBorder(1));
        label.setBackground(col);

        return label;
    }
}
