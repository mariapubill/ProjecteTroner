package Client.ClientController;

import Client.ClientView.BackgroundImageJFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Controller extends Thread implements ActionListener, KeyListener {
    private Timer t;
    private int x;
    private BackgroundImageJFrame bImage;
    private boolean isBack;

    public Controller(BackgroundImageJFrame bImage){
        this.bImage = bImage;
        this.start();
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==10){
            System.out.println("pressed");
            bImage.stopMusic();
            bImage.runMusic(new File("data/Laser.wav"));
            try {
                TimeUnit.MILLISECONDS.sleep(1600);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            bImage.stopMusic();
            bImage.closeFrame();



        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run(){
        x=50;
        isBack=false;
        t=new Timer(10,new ActionListener(){

            public void actionPerformed(ActionEvent ae)
            {
                if (x == 255) {
                    isBack=true;
                }
                if(isBack){
                    bImage.setFade(157,207,222, x--);
                    if(x==50){
                        isBack=false;
                        t.start();
                        x=50;
                    }

                }else{
                    bImage.setFade(157,207,222, x++);

                }

            }
        });
        t.start();
    }

}
