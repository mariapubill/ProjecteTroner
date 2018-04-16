package Client.ClientController;

import Client.ClientView.LabelClass;
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
    private LabelClass label;

    public Controller(MainView view){
        this.view = view;
        this.start();
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==10){
            System.out.println("pressed");
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
        isBack=false;
        t=new Timer(10,new ActionListener(){

            public void actionPerformed(ActionEvent ae)
            {
                if (x == 255) {
                    isBack=true;
                }
                if(isBack){
                    view.setFadeaux(157,207,222, x--);
                    if(x==50){
                        isBack=false;
                        t.start();
                        x=50;
                    }

                }else{
                    view.setFadeaux(157,207,222, x++);

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
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {

    }

}
