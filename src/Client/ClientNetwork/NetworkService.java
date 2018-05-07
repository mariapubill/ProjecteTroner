package Client.ClientNetwork;

import Client.ClientModel.Petition;
import Client.ClientModel.ServerGrid;
import Client.ClientView.GameMainView;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Permet: (1) rebre les actualitzacions de lestat del model que
 emmagatzema el servidor i (2) enviar de les dades (fnom,producte)
 quan lusuari selecciona la opcio send
 */
public class NetworkService extends Thread {
    private ObjectOutputStream doStreamO;
    // Relacio amb el controlador per notificar si hi ha problemes
    // durant lenviament dels missatges
    // Direccio IP i port del servidor
    private static final String IP = "127.0.0.1";
    private ServerGrid sg;
    private static final int PORT = 55555;
    private Socket socketToServer;
    private GameMainView finestra;
    private ObjectInputStream objectIn;
    private boolean isOn;
    private boolean byebye = false;


    public  boolean isByebye() {
        return byebye;
    }

    /**
     * constructor amb paramentres
     * @param finestra ens permetra actualitzar la finestra al rebre una dada
     */
    public NetworkService(GameMainView finestra) {
        try {
            this.isOn = false;
            this.finestra = finestra;
            // connectem amb el servidor i obrim els canals de comunicacio
            this.socketToServer = new Socket(IP, PORT);
            this.doStreamO = new ObjectOutputStream(socketToServer.getOutputStream());
            this.objectIn = new ObjectInputStream(socketToServer.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "No esta conectat al servidor, tanqui la finestra", "Error", JOptionPane.ERROR_MESSAGE);
            byebye = true;
            finestra.setVisible(false);
        }
    }


    /**
     * comença la comunicació amb el servidor
     */
    public void startServerComunication() {
        // iniciem la comunicacio amb el servidor
        isOn = true;
        this.start();
    }

    /**
     * Finalitza la comunicacio amb el servidor
     */
    public void stopServerComunication() {
        //aturem la comunicacio amb el servidor
        this.isOn = false;
        this.interrupt();
    }

    public void run() {

        while (isOn){

            try {
                //escolta les actualizacions de lestat del model
                //que envia el servidor quan algun client fa clic
                //a al botor de send7
                ServerGrid aux =(ServerGrid)objectIn.readObject();
                actualitzarVista(aux);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error ha saltat el catch de q n ha pogut llegir be", JOptionPane.ERROR_MESSAGE);

                stopServerComunication();
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                stopServerComunication();
                e.printStackTrace();
            }
        }
        stopServerComunication();
    }

    /**
     * actualitza la vista amb les dades rebudel del servidor
     * @param list dades del servidor
     */
    private void actualitzarVista(ServerGrid list) {
        finestra.canviaGrid(list);
    }

    /**
     * enviem la comanda feta per l'usuari al servidor
     * @param peticio comanda feta
     */
    public void sendCommand(Petition peticio) {
        try {
            doStreamO.reset();
            doStreamO.writeObject(peticio);
            //Tanquem el socket
            //socket.close();
        } catch (IOException e) {
            // Si hi ha algut algun problema informem al controlador, ell
            stopServerComunication();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}