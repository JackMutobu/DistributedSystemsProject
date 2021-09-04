package client;
import java.net.Socket;

import static client.ProUI.setSessionSocket;

import client.sockets.ClientProtocol;
import models.Message;

public class SocketClient{
    private static ClientProtocol clientProtocol;
    private static ProUI proUI;

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 5649)) {

            socket.setKeepAlive(true);
            setSessionSocket(socket);

            System.out.println("Connected!");

            proUI = new ProUI();

            clientProtocol = new ClientProtocol();
            ClientProtocol.socket = socket;

            proUI.prepUI();

            while (true) {
                Message msg = clientProtocol.retrieveMessage();
                System.out.println(msg.getMessage());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}