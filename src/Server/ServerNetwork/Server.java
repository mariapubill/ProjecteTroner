package Server.ServerNetwork;

import Server.ServerController.GameController;
import Server.ServerModel.Petition;
import Server.ServerModel.ServerGrid;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server extends Thread {
    private ServerSocket sSocket;
    private LinkedList <DedicatedServer> dServers;

    private static final int PORT = 55555;
    // Relacio amb el fil dexecucio que escolta les peticions de connexio
    private DedicatedServer dServer;
    // Relacio amb el controlador per notificar les recepcions de missatges
    private GameController controller;
    private ServerGrid model;
    private boolean isOn;

    /**
     * Constructor amb paramentres.
     * @param controller
     * @param model
     */



    public Server(GameController controller, ServerGrid model) {
        try {
            this.controller = controller;
            this.isOn = false;
            this.model = model;
            // obrim un socket de tipus servidor
            this.sSocket = new ServerSocket(PORT);
            this.dServers = new LinkedList<DedicatedServer>();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Inicia el servei per la recepcio de missatges
     */
    public void startService() {
        isOn = true;
        this.start();
    }

    public void run()  {
        while (isOn) {
            try {
                // acceptem peticions de connexio dels clients
                // BLOQUEJA EXECUCIO DEL THREAD
                Socket sClient = sSocket.accept();
                // creem un nou servidor dedicat per atendre les
                // peticions del client
                DedicatedServer pwClient = new DedicatedServer(model, sClient, dServers, this, controller);
                dServers.add(pwClient);
                // engegem el servidor dedicat
                pwClient.startDedicatedServer();
                System.out.println("client connectat");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * envia la comanda rebuda al controlador pq la gestioni
     * @param newPetition
     */
    public void commandReceived(Petition newPetition) {
    }

    /**
     * finció que actualitza la informacio en els diferents clients
     */
    public void actualitzarClients(){
        dServers.get(0).updateAllClients();
    }

}