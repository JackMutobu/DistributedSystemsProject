package server.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import models.Message;
import models.ModelMessage;

public class ServerProtocol {
    public static Socket socket;

    public Socket returnProtocol(ServerSocket socketServer) throws IOException {
        Socket socket = socketServer.accept();
        System.out.println("Connection from " + socket + "!");

        return socket;
    }

    public <T extends ModelMessage> T retreive()  throws IOException, ClassNotFoundException {
        var inputStream = socket.getInputStream();

        var objectInputStream = new ObjectInputStream(inputStream);

        return (T)objectInputStream.readObject();
    }

    public <T extends ModelMessage> void display(String nameOfItemToDisplay,T item){
        System.out.println("------------------------------------------------");
        System.out.println(nameOfItemToDisplay);
        System.out.println(item);
        System.out.println("------------------------------------------------");
    }

    public void sendMessage(String message) throws IOException {
        var outputStream = socket.getOutputStream();
        var objectOutputStream = new ObjectOutputStream(outputStream);

        var msg = new Message(message);
        objectOutputStream.writeObject(msg);
    }

    public void close(Socket socket) throws IOException {
        System.out.println("Closing sockets.");
        socket.close();
    }

}
