package mika32.Schiffe.GUI;

import mika32.Schiffe.Main;
import mika32.Schiffe.Schiffeversenken.TestPlacing;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.rmi.server.RemoteStub;

public class startingTheme {
    GUI gui = Main.getGUI();
    Font bigFont = gui.bigFont;
    JPanel choice = gui.choice;
    int fieldSize = gui.fieldSize;
    JLayeredPane panelOrder = Main.getGUI().panelOrder;
    JFrame frame = Main.getGUI().frame;


    public void sizeChoice(){
        choice = new JPanel();
        JLabel xFeldSize = new JLabel();
        JLabel yFeldsize = new JLabel();
        JButton upButton = new JButton();
        JButton downButton = new JButton();
        JButton startGameButton = new JButton();
        Color col = new Color(8, 22, 142);
        Color col1 = new Color(0, 102, 255);

        choice.setSize(400, 300);
        choice.setBackground(new Color(15, 172, 212, 203));
        choice.setLayout(null);

        xFeldSize = sizeDisplayBuild(20, 30, "X");
        yFeldsize = sizeDisplayBuild(xFeldSize.getX() + xFeldSize.getWidth() + 10, xFeldSize.getY(), "Y");

        choice.add(xFeldSize);
        choice.add(yFeldsize);

        upButton = ButtonBuild(xFeldSize.getX(), xFeldSize.getHeight() + xFeldSize.getY() + 20, "UP", col, col1);
        downButton = ButtonBuild(yFeldsize.getX(), xFeldSize.getHeight() + xFeldSize.getY() + 20, "DOWN", col, col1);

        upButton.addActionListener(e -> {
            if(!(fieldSize +1 > 25)){
                fieldSize++;
                Main.getGUI().fieldSize = fieldSize;
                sizeChoice();
            }
        });

        downButton.addActionListener(e -> {
            if(!(fieldSize -1 < 8)){
                fieldSize--;
                Main.getGUI().fieldSize = fieldSize;
                sizeChoice();
            }
        });

        choice.add(upButton);
        choice.add(downButton);

        startGameButton = ButtonBuild(xFeldSize.getX() + xFeldSize.getWidth()/2 +10, 200, "START", Color.red, new Color(169, 23, 23));

        startGameButton.addActionListener(e -> {
            System.out.println("Starting Button pressed");

            TestPlacing.setShips();
            System.out.println(Main.getShipHash());

            Main.getGUI().fieldSize = fieldSize;
            Main.getGUI().panelOrder.remove(choice);
            Main.getGUI().loadingScene(choice);
        });

        choice.add(startGameButton);


        panelOrder.add(choice);
        choice.setBounds(frame.getWidth() /2 - choice.getWidth() /2, frame.getHeight() /2 - choice.getHeight() /2 , 400, 300);
        panelOrder.moveToFront(choice);
    }

    private JButton ButtonBuild(int xPos, int yPos, String txt, Color col, Color col1){
        JButton button = new JButton();

        button.setUI(new BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, col, 0, c.getHeight(), col1);
                g2d.setPaint(gradient);
                g2d.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 10, 10);
                super.paint(g, c);
            }
        });

        button.setText(txt);
        button.setBorder(BorderFactory.createLineBorder(Color.blue));
        button.setForeground(Color.white);
        button.setFont(bigFont);
        button.setBounds(xPos, yPos, 175, 65);

        return button;
    }

    private JLabel sizeDisplayBuild(int xPos, int yPos, String type){
        JLabel label = new JLabel();
        Color col = new Color(8, 22, 142);
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

