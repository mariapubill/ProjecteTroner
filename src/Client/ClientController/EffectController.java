package Client.ClientController;

import Client.ClientView.MainView;

import javax.swing.*;
import java.awt.event.*;

public class EffectController extends Thread implements ActionListener, KeyListener, MouseListener {
    private Timer t;
    private int x;
    private int acum;
    private MainView view;
    private boolean isBack;
    private boolean isTimeS;
    private boolean isTimeL;
    private boolean isTimeB;
    private boolean isTimeM;
    private boolean isTimeLogIn;
    private boolean isTimeSignIn;

    private boolean runnable;
    private boolean activateN;
    private boolean activateP;

    private boolean activate1=false;
    private boolean activate2=false;
    private boolean activate3=false;
    private boolean activate4=false;




    private float size;
    private float size2;
    private float sizeLogin;
    private int size4;
    private int size5;




    public EffectController(MainView view){
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
           // view.stopMusic();
           // view.runMusic(new File("data/Laser.wav"));
            runnable=false;
            //try {
                //TimeUnit.MILLISECONDS.sleep(100);
           // } catch (InterruptedException e1) {
             //   e1.printStackTrace();
           // }
          //  try {
                isBack=true;
                t.start();
                //TimeUnit.MILLISECONDS.sleep(1600);
                view.changePanel("2");
             //   view.stopMusic();
               // TimeUnit.MILLISECONDS.sleep(500);
             //   view.runMusic(new File("data/LogInTheme.wav"));

           // } catch (InterruptedException e1) {
             //   e1.printStackTrace();
           // }

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
        sizeLogin = 30f;
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
                    System.out.println("he entrat 2");

                    view.augmentButtons("Mute", 0,size5++);
                }
                if(!isTimeM && size5 > 80 ){
                    view.augmentButtons("Mute", 0,size5--);
                }
                if (isTimeLogIn && sizeLogin < 40f) {
                    view.augmentButtons("Log", sizeLogin++,0);
                }
                if (!isTimeLogIn && sizeLogin > 30f) {

                    view.disaugmentButtons("Log", sizeLogin--);
                }
            }

        });
        t.start();
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (activateN == false && e.getComponent().getY() == 0) {
            System.out.println("entra");
            view.changeTextFields("Username");
            activateN = true;
        }

        if (activateP == false&& e.getComponent().getY() == 124) {
            view.changeTextFields("Password");
            activateP=true;
        }

        if (e.getComponent().getY() == 47 && activate1==false) {
            view.changeTextFields("Nickname");
            activate1 = true;
        }
        if (e.getComponent().getY() == 141 && activate2==false) {
            view.changeTextFields("Email");
            activate2 = true;
        }
        if (e.getComponent().getY() == 235 && activate3==false) {
            view.changeTextFields("Password1");
            activate3 = true;
        }
        if (e.getComponent().getY() == 329 && activate4==false) {
            view.changeTextFields("RPassword");
            activate4 = true;
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {

        if((e.getComponent().getX() == 904|| e.getComponent().getX() == 903)&&e.getComponent().getY() == 0){
            isTimeM = true;
        }
        if(e.getComponent().getX() == 0&&e.getComponent().getY() == 0){
            //isTimeB = true;
        }
        if((e.getComponent().getX() == 159 ||e.getComponent().getX() == 156)&&e.getComponent().getY() == 5 ){
           isTimeL = true;
        }
        if((e.getComponent().getX() == 315 ||e.getComponent().getX() == 156)&&e.getComponent().getY() == 186 ){
            isTimeLogIn = true;
        }
        if((e.getComponent().getX() == 168 || e.getComponent().getX() == 165 )&&e.getComponent().getY() == 5 ){
            isTimeS = true;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getComponent().getY()==0 && view.getUsernameLog().equals("")){
            view.changeTextFieldsEmpty("Username");
            activateN=false;
        }
        if(e.getComponent().getY()==124 && view.getPasswordLog().equals("")){
            view.changeTextFieldsEmpty("Password");
            activateP=false;
        }
        if(e.getComponent().getY()==47 && view.getNicknameSign().equals("")){
            view.changeTextFieldsEmpty("Nickname");
            activate1=false;
        }
        if(e.getComponent().getY()==141 && view.getEmail().equals("")){
            view.changeTextFieldsEmpty("Email");
            activate2=false;
        }
        if(e.getComponent().getY()==235 && view.getPasswordSign().equals("")){
            view.changeTextFieldsEmpty("Password1");
            activate3=false;
        }
        if(e.getComponent().getY()==329 && view.getRepeatPasswordSign().equals("")){
            view.changeTextFieldsEmpty("RPassword");
            activate4=false;
        }

        if(e.getComponent().getX() == 895&&e.getComponent().getY() == 0){
            isTimeM = false;
        }

        if(e.getComponent().getX() == 0&&e.getComponent().getY() == 0){
            isTimeB = false;
        }
        if((e.getComponent().getX() == 131 ||e.getComponent().getX() == 156 )&&e.getComponent().getY() == 5 ){
            isTimeL = false;
        }
        if(e.getComponent().getX() == 143 &&e.getComponent().getY() == 5 ){
            isTimeS = false;
        }
        if(e.getComponent().getX() == 315 &&e.getComponent().getY() == 186 ){
            isTimeLogIn = false;
        }

    }






}
