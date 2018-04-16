package Server;

import Server.ServerModel.ConectorDB;
import Server.ServerModel.GestorDB;
import Server.ServerModel.Parser;
import Server.ServerModel.User;

import java.io.IOException;
import java.time.LocalDate;

public class ServerMain {
    public static void main(String args[]) {
       /* System.out.println("estic al server");
        LocalDate localDate = LocalDate.now();
        Parser parser = new Parser();
        try {
           // parser.readJsonFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ConectorDB conn = new ConectorDB(parser.getUser(), parser.getPassword(), parser.getDatabase(), parser.getPort(), parser.getDirectionIP());
        boolean connected = conn.connect();
        GestorDB gestorDB = new GestorDB(conn);
        if (connected) {
            //JUEGO DE PRUEBAS DE REGISTRO DE USUARIOS
            User usuari = new User("davidsega98@gmail.com", "1234", "davidsega98@gmail.com", localDate.toString(), localDate.toString());
            if (gestorDB.registraUsuari(usuari)) {
                System.out.println("registra");
            } else {
                System.out.println("no registra");
            }
            conn.disconnect();
        }*/
    }
}
