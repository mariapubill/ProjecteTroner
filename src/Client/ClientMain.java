package Client;

import Client.ClientController.Controller;
import Client.ClientController.WindowController;
import Client.ClientView.MainView;



public class ClientMain {
    public static void main(String args[]) {

        MainView view = new MainView();

       // BackgroundImageJFrame bImage =  new BackgroundImageJFrame();
        Controller controller = new Controller(view);
        WindowController windowController = new WindowController(view,controller);
        view.registerController(controller);
        view.registerWindowController(windowController);
        view.setVisible(true);
    }
}
