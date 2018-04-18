package Client.ClientController;

import Client.ClientView.MainView;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Controller extends Thread implements ActionListener, KeyListener, MouseListener {
    private Timer t;
    private int x;
    private MainView view;
    private boolean isBack;
    private boolean isTimeS;
    private boolean isTimeL;
    private boolean itWasTime;
    private float size;
    private float size2;


    public Controller(MainView view){
        this.view = view;
        this.start();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("S")){
            System.out.println("ha clickat el sign in en action performed");
        }
        if (e.getActionCommand().equals("L")){
            System.out.println("ESTIC AL LOGIN");
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==10){
            view.stopMusic();
            view.runMusic(new File("data/Laser.wav"));
            try {
                TimeUnit.MILLISECONDS.sleep(1600);
                view.changePanel("2");

            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            view.stopMusic();
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
        size = 30f;
       size2 = 30f;

       isBack=false;
        itWasTime = false;
        t=new Timer(10,new ActionListener(){

            public void actionPerformed(ActionEvent ae) {
                if (x == 255) {
                    isBack = true;
                }
                if (isBack) {
                    view.setFadeaux(157, 207, 222, x--);
                    if (x == 50) {
                        isBack = false;
                        t.start();
                        x = 50;
                    }
                } else {
                    view.setFadeaux(157, 207, 222, x++);
                }

                if (isTimeS && !isTimeL && size2 < 40f) {
                    view.augmentButtons("S", size2++);
                }
                if (isTimeL && !isTimeS && size < 40f) {
                    view.augmentButtons("L", size++);
                }
                if (!isTimeS && size2 > 30f) {
                    view.disaugmentButtons("S", size2--);
                }

                if (!isTimeL && size > 30f) {
                    view.disaugmentButtons("L", size--);
                }


            }

        });
        t.start();
    }


    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e)
    {


    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getLocationOnScreen().getX()>850 && e.getLocationOnScreen().getX()< 1050 && e.getLocationOnScreen().getY()>410 &&e.getLocationOnScreen().getY()<470){
           isTimeL = true;
        }
        if(e.getLocationOnScreen().getX()>380 && e.getLocationOnScreen().getX()< 560 && e.getLocationOnScreen().getY()>410 &&e.getLocationOnScreen().getY()<470){
            isTimeS = true;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getLocationOnScreen().getX()>850 && e.getLocationOnScreen().getX()< 1050 && e.getLocationOnScreen().getY()>400 &&e.getLocationOnScreen().getY()<470){
            isTimeL = false;
        }
        if(e.getLocationOnScreen().getX()>380 && e.getLocationOnScreen().getX()< 560 && e.getLocationOnScreen().getY()>400 &&e.getLocationOnScreen().getY()<470){
            isTimeS = false;
        }

    }

}
