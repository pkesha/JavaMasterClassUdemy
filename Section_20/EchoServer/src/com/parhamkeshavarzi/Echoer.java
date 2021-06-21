package com.parhamkeshavarzi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {
    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            while(true) {
                String echoString = input.readLine();
                if(echoString.equals("exit")) {
                    break;
                }
            }

            try {
                Thread.sleep(15000);
            } catch (InterruptedException interruptedException) {
                System.out.println("Thread interrupted");
            }

        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        } finally {
            try {
                this.socket.close();
            } catch (IOException ioException) {
                // oh well!
            }
        }
    }
}
