package Client.ClientController;

import Client.ClientView.MainView;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class Controller extends Thread implements ActionListener, KeyListener, MouseListener {
    private Timer t;
    private int x;
    private int acum;
    private MainView view;
    private boolean isBack;
    private boolean isTimeS;
    private boolean isTimeL;
    private boolean isTimeB;
    private boolean isTimeM;


    private float size;
    private float size2;
    private int size4;
    private int size5;




    public Controller(MainView view){
        this.view = view;
        this.start();
        acum = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("S")){
            view.changePanel("4");
        }
        if (e.getActionCommand().equals("L")){
            view.changePanel("3");
        }
        if(e.getActionCommand().equals("Back")){
            view.changePanel("2");
        }
        if(e.getActionCommand().equals("Mute")){
            acum++;
            if(acum%2==0){
                view.turnOnVolume();
            }else{
                view.turnOffVolume();
            }


        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==10){
            view.stopMusic();
            view.runMusic(new File("data/Laser.wav"));
            try {
                isBack=true;
                t.start();
                TimeUnit.MILLISECONDS.sleep(1600);
                view.changePanel("2");
                view.stopMusic();
                TimeUnit.MILLISECONDS.sleep(500);
                view.runMusic(new File("data/LogInTheme.wav"));

            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

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
       size4= 80;
       size5= 80;
       isBack=false;

        t=new Timer(5,new ActionListener(){

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
                    view.augmentButtons("S", size2++,0);
                }
                if (isTimeL && !isTimeS && size < 40f) {
                    view.augmentButtons("L", size++,0);
                }
                if (!isTimeS && size2 > 30f) {
                    view.disaugmentButtons("S", size2--);
                }
                if (!isTimeL && size > 30f) {
                    view.disaugmentButtons("L", size--);
                }
                if(isTimeB && size4 < 90){
                    view.augmentButtons("Back", 0,size4++);
                }
                if(!isTimeB && size4 >80 ){
                    view.augmentButtons("Back", 0,size4--);
                }
                if(isTimeM && size5 < 90){
                    view.augmentButtons("Mute", 0,size5++);
                }
                if(!isTimeM && size5 > 80 ){
                    view.augmentButtons("Mute", 0,size5--);
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
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getLocationOnScreen().getX()>1080 && e.getLocationOnScreen().getX()< 1190 && e.getLocationOnScreen().getY()>160 &&e.getLocationOnScreen().getY()<260){
            isTimeM = true;
        }

        if(e.getLocationOnScreen().getX()>250 && e.getLocationOnScreen().getX()< 360 && e.getLocationOnScreen().getY()>160 &&e.getLocationOnScreen().getY()<260){
            isTimeB = true;
        }
        if(e.getLocationOnScreen().getX()>850 && e.getLocationOnScreen().getX()< 1050 && e.getLocationOnScreen().getY()>410 &&e.getLocationOnScreen().getY()<470){
           isTimeL = true;
        }
        if(e.getLocationOnScreen().getX()>360 && e.getLocationOnScreen().getX()< 560 && e.getLocationOnScreen().getY()>410 &&e.getLocationOnScreen().getY()<470){
            isTimeS = true;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        if(e.getLocationOnScreen().getX()>1000 && e.getLocationOnScreen().getX()< 1200 && e.getLocationOnScreen().getY()>160 &&e.getLocationOnScreen().getY()<275){
            isTimeM = false;
        }

        if(e.getLocationOnScreen().getX()>240 && e.getLocationOnScreen().getX()< 370 && e.getLocationOnScreen().getY()>160 &&e.getLocationOnScreen().getY()<275){
            isTimeB = false;
        }
        if(e.getLocationOnScreen().getX()>830 && e.getLocationOnScreen().getX()< 1150 && e.getLocationOnScreen().getY()>400 &&e.getLocationOnScreen().getY()<470){
            isTimeL = false;
        }
        if(e.getLocationOnScreen().getX()>320 && e.getLocationOnScreen().getX()< 580 && e.getLocationOnScreen().getY()>400 &&e.getLocationOnScreen().getY()<470){
            isTimeS = false;
        }

    }






}
