package Client.ClientView;


import Client.ClientController.Controller;
import Client.ClientController.EffectController;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainView extends JFrame{
    private LabelClass label = new LabelClass();
    private LogSignPanel card2;
    private LogInPanel card3;
    private SignInPanel card4;
    private CardLayout layout;
    private Clip clip;


    public MainView(){
        layout = new CardLayout();
        JPanel bgPanel = new BackgroundImageJFrame();
        JPanel card1 = label;
        card2 = new LogSignPanel();
        card3 = new LogInPanel();
        card4 = new SignInPanel();

        bgPanel.setLayout(layout);
        bgPanel.add("1",card1);
        bgPanel.add("2",card2);
        bgPanel.add("3",card3);
        bgPanel.add("4",card4);

        layout.show(bgPanel, "1");
     //   runMusic(new File("data/musicFile.wav"));

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


    public void registerController(EffectController c){
        card2.registerControllerMouse(c);
        card2.registerControllerButtons(c);
        card3.registerControllerMouse(c);
        card3.registerControllerButton(c);
        card4.registerControllerButton(c);
        card4.registerControllerMouse(c);
        this.addKeyListener(c);
    }

    public void actionRegisterController(Controller c){
        card2.registerControllerMouse(c);
        card2.registerControllerButtons(c);
        card3.registerControllerMouse(c);
        card3.registerControllerButton(c);
        card4.registerControllerButton(c);
        card4.registerControllerMouse(c);
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

    public void turnOffVolume(){
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-50.0f); //
    }
    public void turnOnVolume(){
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(6.0f); //
    }

     public void stopMusic() { clip.stop(); }

     public void setFadeaux(int r, int g, int b, int x) {label.setFade(r,g,b,x); }

     public void augmentButtons(String button, float x, int x1){
        if(button.equals("Back")|| button.equals("Mute")){
            card4.augmentButtons(button,x1);
            card3.augmentButtons(button,x1);
        }else {
            card3.augmentButtons(button,x);
            card2.augmentButtons(button, x);
        }
      }
      public void disaugmentButtons(String button, float x){

         card2.disaugmentButton(button, x);
         card3.disaugmentButton(button, x);
    }


    public void changeTextFields(String name){
          card3.changeTextField(name);
          card4.changeTextField(name);
    }
    public String getUsernameLog(){
        return card3.getUsername();
    }

    public String getPasswordLog(){
        return card3.getPassword();
    }
    public void changeTextFieldsEmpty(String name){
        card3.changeTextFieldEmpty(name);
        card4.changeTextFieldEmpty(name);
    }
    public String getNicknameSign(){
        return card4.getNickname();
    }
    public String getEmail(){
        return card4.getEmail();
    }

    public String getPasswordSign(){
        return card4.getPassword();
    }
    public String getRepeatPasswordSign(){
        return card4.getRepeatPassword();
    }




}


