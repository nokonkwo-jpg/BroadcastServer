package main.java.sockets;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    // Declares a server socket object
    private ServerSocket server;
    private boolean running = true;

    // Starts the server and listens for client connections
    public void start() throws Exception {
        // Binds the server to port 8080
        server = new ServerSocket(8080);
        System.out.println("Server started");

        // Continuously listens for client connections
        while (running) {
            // Accepts an incoming client connection
            Socket clientSocket = server.accept();
            System.out.println("Client connected");
            // Reads and handles messages from the connected client
            readMessageFromSocket(clientSocket);
        }
    }

    // Reads a message from the client socket
    private void readMessageFromSocket(Socket clientSocket) throws Exception {
        // Sets up a BufferedReader to read the input stream from the client
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        // Reads the first line of the message from the client
        String line = bufferedReader.readLine();
        // Loops through and prints each line received from the client until the input is empty
        while (!line.isEmpty()) {
            System.out.println("Received: " + line);

            if(line.equalsIgnoreCase("exit")){
                running = false;
                System.out.println("Exit command recieved. Shutting down server.");
                stop();
                break;
            }
            line = bufferedReader.readLine();
        }
    }

    // Stops the server and closes the connection
    public void stop() {
        if (server != null) {
            try {
                // Closes the server socket
                server.close();
                System.out.println("Server stopped");
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Main method to run the server
    public static void main(String[] args) {
        // Creates a new server instance
        Server server = new Server();

        try {
            // Starts the server
            server.start();
        } catch(Exception e) {
            // Stops the server in case of an error
            server.stop();
        }
    }
}
