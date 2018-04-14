package Client.ClientView;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;


public class BackgroundImageJFrame extends JPanel {
    private JLabel l1;
    private Timer t;
    private Clip clip;



   // public BackgroundImageJFrame() {
        Image bg = new ImageIcon("data/back.png").getImage();
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
        }





}




