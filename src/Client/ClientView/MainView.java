package Client.ClientView;


import Client.ClientController.Controller;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainView extends JFrame{
    private LabelClass label = new LabelClass();
    private LogSignPanel card2;
    private CardLayout layout;
    private Clip clip;


    public MainView(){
        layout = new CardLayout();
        JPanel bgPanel = new BackgroundImageJFrame();
        JPanel card1 = label;
        card2 = new LogSignPanel();
        bgPanel.setLayout(layout);
        bgPanel.add("1",card1);
        bgPanel.add("2",card2);

        layout.show(bgPanel, "1");
        runMusic(new File("data/musicFile.wav"));



        // MainView t = new MainView();
        this.setContentPane(bgPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    public void changePanel(String which) {
        layout.show(this.getContentPane(), which);
    }


    public void registerController(Controller c){
        card2.registerControllerMouse(c);
        card2.registerControllerButtons(c);
        this.addKeyListener(c);
    }


    public void runMusic(File file) {
       try {
           clip = AudioSystem.getClip();
           AudioInputStream ais = AudioSystem.getAudioInputStream(file);
           clip.open(ais);
           clip.loop(Clip.LOOP_CONTINUOUSLY);

       } catch (LineUnavailableException e) {
           e.printStackTrace();
       } catch (UnsupportedAudioFileException e1) {
           e1.printStackTrace();
       } catch (IOException e2) {
           e2.printStackTrace();
       }

    }

     public void stopMusic() {
        clip.stop();

     }


     public void setFadeaux(int r, int g, int b, int x) {
         label.setFade(r,g,b,x);

      }

      public void augmentButtons(String button, float x){
        card2.augmentButtons(button, x);
      }

    public void disaugmentButtons(String button, float x){
        card2.disaugmentButton(button, x);
    }


}
