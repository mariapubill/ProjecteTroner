package Client.ClientController;

import Client.ClientNetwork.NetworkService;
import Client.ClientView.GameMainView;
import Client.ClientView.MainView;

import javax.swing.*;
import java.awt.event.*;
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
    private boolean stopMusic = true;
    private Integer actualLayout = 1;
    private float size;
    private float size2;
    private int size4;
    private int size5;
    private Music music;
    private boolean soundNow;
    private boolean closeSound;
    private boolean activate1=false;
    private boolean activate2=false;
    private boolean activate3=false;
    private boolean activate4=false;

    private boolean activateN;
    private boolean activateP;

    public Controller(MainView view) {
        closeSound = false;
        soundNow = false;
        this.view = view;
        music = new Music(this);
        new Thread(music).start();
        this.run();
        acum = 0;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")){
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            actualLayout = 5;
            view.changePanel(actualLayout.toString());

        }
        if (e.getActionCommand().equals("2game")){
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            startGame();
        }
        if (e.getActionCommand().equals("4game")){
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
        }
        if (e.getActionCommand().equals("Tournament")){
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();

        }
        if (e.getActionCommand().equals("Exit")){
            if (view.showDialog("¿Desea salir del juego?", actualLayout)) {
                System.exit(0);
            }
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();

        }
        //if (e.getActionCommand().equals("Mute")){
         //   ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
          //  System.out.println("XT");

        //}
        if (e.getActionCommand().equals("Return")){
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            switchAndChange();
        }
        if (e.getActionCommand().equals("S")) {
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            actualLayout = 4;
            view.changePanel(actualLayout.toString());
        }
        if (e.getActionCommand().equals("goButton")) {
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            //Si la verificacion es correcta
            actualLayout = 5;
            view.changePanel(actualLayout.toString());
        }
        if (e.getActionCommand().equals("RegisterButton")) {
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            //Si es correcto
            actualLayout = 5;
            view.changePanel(actualLayout.toString());
        }

        if (e.getActionCommand().equals("L")) {
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            actualLayout = 3;
            view.changePanel(actualLayout.toString());
        }
        if (e.getActionCommand().equals("Back")) {
            if (actualLayout == 5) {

                if (view.showDialog("¿Desea volver a la ventana de inicio?", actualLayout)) {

                    view.changePanel(actualLayout.toString());
                }

            }
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
        }
        if (e.getActionCommand().equals("Mute")) {
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            acum++;
            if (acum % 2 == 0) {
                music.turnOnVolume();
            } else {
                music.turnOffVolume();
            }
        }
        if (e.getActionCommand().equals("Signin")){
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            actualLayout = 5;
            view.changePanel(actualLayout.toString());
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 27) {
          switchAndChange();
        }
        if (e.getKeyCode() == 10 && actualLayout == 1) {
            //actualLayout = 2;
            //music.stopMusic();
            //music.runMusic(new File("data/Laser.wav"));
            try {
                stopMusic();
                // isBack = true;
                t.start();
                soundNow = true;

                 TimeUnit.MILLISECONDS.sleep(1600);
                //music.stopMusic();
                 TimeUnit.MILLISECONDS.sleep(500);
                actualLayout++;
                view.changePanel(actualLayout.toString());
                soundNow = false;
                //closeSound = false;
                //startMusic();
                //music.runMusic(new File("data/LogInTheme.wav"));

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
    public void run() {
        x = 50;
        size = 30f;
        size2 = 30f;
        size4 = 80;
        size5 = 80;
        isBack = false;

        t = new Timer(5, new ActionListener() {

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

                if (isTimeS && !isTimeL && size2 < 40f && actualLayout == 3) {
                    view.augmentButtons("S", size2++, 0);
                }
                if (isTimeL && !isTimeS && size < 40f) {
                    view.augmentButtons("L", size++, 0);
                }
                if (!isTimeS && size2 > 30f) {
                    view.disaugmentButtons("S", size2--);
                }
                if (!isTimeL && size > 30f) {
                    view.disaugmentButtons("L", size--);
                }
                if (isTimeB && size4 < 90) {
                    view.augmentButtons("Back", 0, size4++);
                }
                if (!isTimeB && size4 > 80) {
                    view.augmentButtons("Back", 0, size4--);
                }
                if (isTimeM && size5 < 90) {
                    view.augmentButtons("Mute", 0, size5++);
                }
                if (!isTimeM && size5 > 80) {
                    view.augmentButtons("Mute", 0, size5--);
                }
            }

        });
        t.start();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (activateN == false && e.getComponent().getY() == 0) {
            //Hablar esto, me entra abajo
            view.changeTextFields("Username");
            ((JButton)e.getSource()).getTopLevelAncestor().requestFocus();
            actualLayout++;
            activateN = true;
        }

        if (activateP == false&& e.getComponent().getY() == 124) {
            view.changeTextFields("Password");
            ((JTextField)e.getSource()).getTopLevelAncestor().requestFocus();
            activateP=true;
        }

        if (e.getComponent().getY() == 47 && activate1==false) {
            ((JTextField)e.getSource()).getTopLevelAncestor().requestFocus();
            view.changeTextFields("Nickname");
            activate1 = true;
        }
        if (e.getComponent().getY() == 141 && activate2==false) {
            ((JTextField)e.getSource()).getTopLevelAncestor().requestFocus();
            view.changeTextFields("Email");
            activate2 = true;
        }
        if (e.getComponent().getY() == 235 && activate3==false) {
            ((JPasswordField)e.getSource()).getTopLevelAncestor().requestFocus();
            view.changeTextFields("Password1");
            activate3 = true;
        }
        if (e.getComponent().getY() == 329 && activate4==false) {
            ((JPasswordField)e.getSource()).getTopLevelAncestor().requestFocus();
            view.changeTextFields("RPassword");
            activate4 = true;
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (e.getLocationOnScreen().getX() > 1080 && e.getLocationOnScreen().getX() < 1190 && e.getLocationOnScreen().getY() > 160 && e.getLocationOnScreen().getY() < 260 && actualLayout == 2) {
            isTimeM = true;
        }

        if (e.getLocationOnScreen().getX() > 250 && e.getLocationOnScreen().getX() < 360 && e.getLocationOnScreen().getY() > 160 && e.getLocationOnScreen().getY() < 260 && actualLayout == 2) {
            isTimeB = true;
        }
        if (e.getLocationOnScreen().getX() > 850 && e.getLocationOnScreen().getX() < 1050 && e.getLocationOnScreen().getY() > 410 && e.getLocationOnScreen().getY() < 470 && actualLayout == 2) {
            isTimeL = true;
        }
        if (e.getLocationOnScreen().getX() > 360 && e.getLocationOnScreen().getX() < 560 && e.getLocationOnScreen().getY() > 410 && e.getLocationOnScreen().getY() < 470 && actualLayout == 2) {
            isTimeS = true;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getLocationOnScreen().getX() > 1000 && e.getLocationOnScreen().getX() < 1200 && e.getLocationOnScreen().getY() > 160 && e.getLocationOnScreen().getY() < 275) {
            isTimeM = false;
        }

        if (e.getLocationOnScreen().getX() > 240 && e.getLocationOnScreen().getX() < 370 && e.getLocationOnScreen().getY() > 160 && e.getLocationOnScreen().getY() < 275) {
            isTimeB = false;
        }
        if (e.getLocationOnScreen().getX() > 830 && e.getLocationOnScreen().getX() < 1150 && e.getLocationOnScreen().getY() > 400 && e.getLocationOnScreen().getY() < 470) {
            isTimeL = false;
        }
        if (e.getLocationOnScreen().getX() > 320 && e.getLocationOnScreen().getX() < 580 && e.getLocationOnScreen().getY() > 400 && e.getLocationOnScreen().getY() < 470) {
            isTimeS = false;
        }

    }

    public Integer getActualLayout() {
        return actualLayout;
    }

    public void setActualLayout(Integer actualLayout) {
        this.actualLayout = actualLayout;
    }

    private void stopMusic() {
        this.stopMusic = false;
    }

    public void startMusic() {
        this.stopMusic = true;
    }
    public boolean getMusicOn(){
        return stopMusic;
    }

    public boolean getCloseSound() {
        return closeSound;
    }

    public boolean getSoundNow() {
        return soundNow;
    }

    public void setSoundNow(boolean soundNow) {
        this.soundNow = soundNow;
    }

    public void setMusicOn(boolean musicOn) {
        this.stopMusic = musicOn;
    }

    public void setCloseSound(boolean closeSound) {
        this.closeSound = closeSound;
    }
    private void switchAndChange(){
        switch (actualLayout) {
            case 1:
                if (view.showDialog("¿Desea salir del juego?", actualLayout)) {
                    System.exit(0);
                }
                break;
            case 3:
                actualLayout = 2;
                view.changePanel(actualLayout.toString());
                break;
            case 4:
                actualLayout = 2;
                view.changePanel(actualLayout.toString());
                break;
            case 5:
                if (view.showDialog("¿Desea volver a la pantalla de inicio?", actualLayout)) {

                    actualLayout = 1;
                    view.changePanel(actualLayout.toString());
                }
                break;
            case 7:
                if (view.showDialog("Si abandona la partida sera penalizado.\n¿esta usted seguro de abandonar?", actualLayout)) {
                    actualLayout = 5;
                    view.changePanel(actualLayout.toString());
                }
            default:
                actualLayout--;
                view.changePanel(actualLayout.toString());
                break;
        }
    }

    public void startGame(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //creem la vista
                GameMainView gameView = new GameMainView();
                //creem network
                NetworkService nService = new NetworkService(gameView);
                //Creem els controladors.
                GameController controller = new GameController(gameView,nService);
                //Establim les "relacions" V->C
                gameView.actionPerformed(controller);
                //fem visible les dues finestres.

                //finestra.setVisible(true);
                if(nService.isByebye()){
                    gameView.setVisible(false);
                }else{
                    gameView.setVisible(true);
                }
            }
        });
    }
}

