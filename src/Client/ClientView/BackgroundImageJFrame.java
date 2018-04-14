package Client.ClientView;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class BackgroundImageJFrame extends JFrame {
    private JLabel l1;
    private Timer t;

    AudioFormat audioFormat;
    AudioInputStream audioInputStream;
    SourceDataLine sourceDataLine;
    boolean stopPlayback = false;

    public BackgroundImageJFrame() {
        setTitle("Background Color for JFrame");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        this.pack();
        this.setBackgroundImage();
        runMusic(new File("data/musicFile.wav"));

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


    public void runMusic(File file){

        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream( file );
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }catch(UnsupportedAudioFileException e1){
            e1.printStackTrace();
        }catch(IOException e2){
            e2.printStackTrace();
        }

    }



}




