/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.patch;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guinness
 */
public class CheckInternetConnection {

    public static void main(String[] args) {
        try {
            System.out.println("Available: "+isHostAvailable("google.com"));
        } catch (IOException ex) {
            Logger.getLogger(CheckInternetConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean isInternetAvailable() throws IOException {
        return isHostAvailable("google.com") || isHostAvailable("amazon.com")
                || isHostAvailable("facebook.com") || isHostAvailable("apple.com");
    }
    
    private static boolean isHostAvailable(String hostName) throws IOException {
        try {
            Socket socket = new Socket();
            int port = 80;
            InetSocketAddress socketAddress = new InetSocketAddress(hostName, port);
            socket.connect(socketAddress, 3000);
            return true;
        } catch (UnknownHostException unknownHost) {
            return false;
        }
    }
    
}
