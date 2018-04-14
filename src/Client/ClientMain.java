package Client;

import Client.ClientController.Controller;
import Client.ClientView.MainView;

public class ClientMain {
    public static void main(String args[]) {

        MainView view = new MainView();

       // BackgroundImageJFrame bImage =  new BackgroundImageJFrame();
        Controller controller = new Controller(view);
        view.registerController(controller);
        view.setVisible(true);
    }
}
