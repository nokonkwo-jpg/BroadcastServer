package main.java.sockets;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    // Declares a socket object
    private Socket socket;
    private PrintWriter out;

    // Initializes the connection to the server
    public void init() throws Exception {
        // Connects to the server at IP address "10.252.180.173" on port 8080
        socket = new Socket("10.252.180.173", 8080);
        System.out.println("Connected to server");
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    // Sends a message to the server
    public void send(String msg) throws Exception {
        System.out.println("Sending to server ");
        // Sends the message to the server
        out.println(msg);
        out.flush();
    }

    // Closes the connection (stops the client)
    public void stop() {
        if (out != null) {
            out.close();
        }
        if (socket != null) {
            try {
                // Closes the socket connection
                socket.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Main method to run the client
    public static void main(String[] args) {
        // Creates a new client instance
        Client client = new Client();
        // Scanner to read user input
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        try {
            // Initializes the client (connects to the server)
            client.init();
            // Prompts the user to enter a message
            System.out.println("Enter a message: ");
            String msg = scanner.nextLine();
            // Sends the message to the server
            client.send(msg);

            while(running) {
                String newMsg = scanner.nextLine();
                client.send(newMsg);
                if(newMsg.equals("exit") || msg.equals("exit")) {
                    running = false;
                    break;
                }
            }
            // Closes the scanner after input

        } catch(Exception e) {
            // Stops the client in case of an error
            client.stop();
        } finally {
            scanner.close();
        }
    }
}
