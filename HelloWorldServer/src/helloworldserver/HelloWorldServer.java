/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldserver;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Aaron Jacobson
 */
public class HelloWorldServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
        server.waitForConnections();
    }
    
}
