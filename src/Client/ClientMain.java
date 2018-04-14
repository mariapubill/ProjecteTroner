package Client;

import Client.ClientController.Controller;
import Client.ClientView.BackgroundImageJFrame;

public class ClientMain {
    public static void main(String args[]) {
        BackgroundImageJFrame bImage =  new BackgroundImageJFrame();
        Controller controller = new Controller(bImage);
        bImage.registerController(controller);
        bImage.setVisible(true);
    }
}
