package Client.ClientView;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LabelClass extends JPanel {
    private JLabel l1;

    public LabelClass(){
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());


        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("data/font2.ttf"));
            l1 = new JLabel("PRESS ENTER TO START");
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            font = font.deriveFont(48f);
            l1.setFont(font);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 2;
            gbc.gridy = 2;
            this.add(l1, gbc);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e1) {
            e1.printStackTrace();

        }



    }


    public void setFade(int r, int g, int b, int x) {
        l1.setForeground(new Color(r, g, b, x));

    }


}
