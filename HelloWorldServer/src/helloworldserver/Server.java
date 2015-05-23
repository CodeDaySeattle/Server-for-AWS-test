/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldserver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aaron Jacobson
 */
public class Server {
    public static int portNumber = 41801;
    
    private ServerSocket serverSocket;
    private boolean shouldWait;
    
    public Server(){
        shouldWait = true;
    }
    
    public void startServer(){
        System.out.println("Starting the server.");
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("The server has successfully started.");
        } catch (IOException ex) {
            System.out.println("Unable to initiate server on the port number.");
        }
    }
    
    public void waitForConnections(){
        System.out.println("Waiting for connections.");
        while(shouldWait){
            try {
                Socket socket = serverSocket.accept();
                DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
                dataOut.writeUTF("Hello World!");
                socket.close();
            } catch (IOException ex) {
                System.out.println("Can't wait for the socket connection.");
            }
        }
    }
}
