package client.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import models.Message;
import models.ModelMessage;


public class ClientProtocol{

    public static Socket socket;

    public Message retrieveMessage() throws IOException, ClassNotFoundException {
        InputStream inputStream = socket.getInputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        return (Message) objectInputStream.readObject();
    }

    public <T extends ModelMessage> void send(T item) throws IOException {
        OutputStream outputStream = socket.getOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(item);
    }

}
