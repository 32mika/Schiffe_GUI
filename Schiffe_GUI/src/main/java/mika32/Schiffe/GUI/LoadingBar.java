package mika32.Schiffe.GUI;

import mika32.Schiffe.Main;

import javax.swing.*;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class LoadingBar {
    JProgressBar bar;


    public JPanel create(JPanel retPanel){
        retPanel.removeAll();

        bar = new JProgressBar(0,100);
        bar.setStringPainted(true);
        bar.setFont(Main.getGUI().bigFont);
        bar.setFocusable(false);
        bar.setOpaque(false);
        bar.setBounds(0, 0, 400, 300);
        bar.setForeground(Color.BLUE);

        ProgressBarUI customUI = new BasicProgressBarUI() {
            @Override
            protected Color getSelectionForeground() {
                return Color.white;
            }

            @Override
            protected Color getSelectionBackground() {
                return Color.white;
            }
        };

        bar.setUI(customUI);
        retPanel.add(bar);

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    TimeUnit.MILLISECONDS.sleep(25); // make 50 after
                    bar.setValue(i);
                }
                return null;
            }

            @Override
            protected void done() {
                System.out.println("Done");
                Main.getGUI().startGameScreen();

            }
        };

        worker.execute();

        return retPanel;
    }
}
