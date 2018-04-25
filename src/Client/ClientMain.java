package Client;

import Client.ClientController.Controller;
import Client.ClientController.EffectController;
import Client.ClientView.MainView;

public class ClientMain {
    public static void main(String args[]) {

        MainView view = new MainView();

       // BackgroundImageJFrame bImage =  new BackgroundImageJFrame();
        EffectController controllerE = new EffectController(view);
        Controller controller = new Controller(view);
        view.registerController(controllerE);
        view.actionRegisterController(controller);
        view.setVisible(true);
    }
}
