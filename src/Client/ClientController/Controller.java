package Client.ClientController;

import Client.ClientView.MainView;

import java.awt.event.*;

public class Controller implements ActionListener, KeyListener, MouseListener {
    private MainView view;
    public Controller(MainView view){
        this.view = view;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Signin")){
            if(isAnyEmptyField()){
                System.out.println("error amic");
            }else {
                checkEmail();
            }
        }



    }

    public void checkEmail(){
        String email = new String(view.getEmail());
        System.out.println(email);
    }
    public boolean isAnyEmptyField(){
        boolean isAnyEmptyField = false;
        if(view.getEmail().equals("example@gmail.com")||view.getRepeatPasswordSign().equals("Minimum 8 carachters")||view.getPasswordSign().equals("Minimum 8 carachters")||view.getNicknameSign().equals("Please input User Name")){
            isAnyEmptyField=true;
        }
        return isAnyEmptyField;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
