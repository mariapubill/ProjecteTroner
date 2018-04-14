package Client.ClientView;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class BackgroundImageJFrame extends JFrame {
    private JLabel l1;
    private Timer t;
    private int x;
    private boolean isBack;
    private Thread thread;

    public BackgroundImageJFrame() {
        setTitle("Background Color for JFrame");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        this.pack();
        this.setBackgroundImage();

    }

    public void setBackgroundImage() {

        setLocation(300,150);
        setContentPane(new JLabel(new ImageIcon("data/back.png")));
        setLayout(new GridBagLayout());
        pack();
        setSize(1000, 600);

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



   public void setFade(int r, int g, int b, int x){
       l1.setForeground(new Color(r, g, b, x));
       
   }



}




