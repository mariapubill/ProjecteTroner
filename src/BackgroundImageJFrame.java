import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class BackgroundImageJFrame extends JFrame {
    private JButton b1;
    private JLabel l1;

    public BackgroundImageJFrame() {
        setTitle("Background Color for JFrame");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        this.setBackgroundImage();


    }

    public void setBackgroundImage() {
        setContentPane(new JLabel(new ImageIcon("/Users/mariapubillfont/Desktop/back.png")));
        setLayout(new FlowLayout());
        JButton b1 = new JButton("I am a button");
        //add(b1);
        // Just for refresh :) Not optional!
        setSize(900, 600);

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("/Users/mariapubillfont/Desktop/java.ttf"));
            ;
            //font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/java.ttf"));
            l1 = new JLabel("PRESS ENTER TO START");

            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            font = font.deriveFont(48f);
            l1.setFont(font);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 3;
            gbc.gridy = 3;
            this.add(l1, gbc);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e1) {
            e1.printStackTrace();

        }
    }
}




