package com.parhamkeshavarzi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            // Will accept multiple client connections
            while (true) {
//                Socket socket = serverSocket.accept();
//                Echoer echoer = new Echoer(socket);
//                echoer.start();

                // Same as the 3 lines above
                new Echoer(serverSocket.accept()).start();

//                // returns socket instance to 'socket'
//                // blocks until client
//                Socket socket = serverSocket.accept();
//                System.out.println("Client Connected");
//                // Wrapping input stream in buffer reader
//                BufferedReader input = new BufferedReader(
//                        new InputStreamReader(socket.getInputStream()));
//
//                // Wrapping output stream in PrintWriter
//                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
//                String echoString = input.readLine();
//                try {
//                    Thread.sleep(15000);
//                } catch (InterruptedException interruptedException) {
//                    System.out.println("Thread interrupted");
//                }
//                if (echoString.equals("exit")) {
//                    break;

            }

//                output.println("Echo from server: " + echoString);

        } catch (IOException exception) {
            System.out.println("Server exception " + exception.getMessage());
        }
    }
}
