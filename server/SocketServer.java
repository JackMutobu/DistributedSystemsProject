package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import server.sockets.ServerProtocol;

public class SocketServer {
    private static Socket socket;
    private static ServerSocket serverSocket;
    private static ServerProtocol socketProtocol;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {

            serverSocket = new ServerSocket(5649);
            System.out.println("ServerSocket awaiting connections...");

            while (true) {
                socket = serverSocket.accept();
                socketProtocol = new ServerProtocol();
                socket.setKeepAlive(true);

                System.out.println("Connection from " + socket + "!");

                ServerProtocol.socket = socket;

                while (true) {
                    socketProtocol.sendMessage("Send Student Number");
                    var studentNumber = socketProtocol.retreive(); 
                    socketProtocol.display("Student Number", studentNumber);
                    
                    socketProtocol.sendMessage("Send Student Name");
                    var studentName = socketProtocol.retreive();
                    socketProtocol.display("Student Name", studentName);
                    
                    socketProtocol.sendMessage("Send Course Details");
                    var  courseDetails = socketProtocol.retreive();
                    socketProtocol.display("Course Details", courseDetails);
                    
                    
                    socketProtocol.sendMessage("Send Personal Code");
                    var personalCode = socketProtocol.retreive();
                    socketProtocol.display("Personal code", personalCode);

                    socketProtocol.sendMessage("Please send everything now");
                    var allDetails = socketProtocol.retreive();
                    socketProtocol.display("Everytinng", allDetails);
                    socketProtocol.sendMessage("Terminated");

                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                System.out.println("Closing socket server.");
                serverSocket.close();
                System.out.println("Closing sockets.");
                socket.close();

            } catch (Exception ex1) {
            }
        }
    }
}
