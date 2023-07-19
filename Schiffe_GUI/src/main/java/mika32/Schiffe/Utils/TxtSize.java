package mika32.Schiffe.Utils;

import javax.swing.*;
import java.awt.*;

public class TxtSize {
    public static Font getAdjustedFont(JButton button, Font originalFont) {
        String buttonText = button.getText();
        int maxWidth = button.getWidth() -18;
        int maxHeight = button.getHeight() -18;

        FontMetrics fontMetrics = button.getFontMetrics(originalFont);

        int fontSize = originalFont.getSize();

        while (fontMetrics.stringWidth(buttonText) > maxWidth || fontMetrics.getHeight() > maxHeight) {
            fontSize--;
            Font resizedFont = originalFont.deriveFont((float) fontSize);
            fontMetrics = button.getFontMetrics(resizedFont);
        }

        String s = Integer.toString(fontSize +1);
        s = s.replace("-", "");
        fontSize = Integer.parseInt(s);

        return originalFont.deriveFont((float) fontSize);
    }
}
