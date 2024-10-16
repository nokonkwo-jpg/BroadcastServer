package main.java.sockets;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;

    public void start() throws Exception {
         server = new ServerSocket(8080);
         System.out.println("Server started");
         while (true) {
             Socket clientSocket = server.accept();
             System.out.println("Client connected");
             readMessageFromSocket(clientSocket);
         }
    }
    private void readMessageFromSocket(Socket clientSocket) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String line = bufferedReader.readLine();
        while (!line.isEmpty()) {
            System.out.println(line);
            line = bufferedReader.readLine();
        }
    }

    public void stop() {
        if (server != null) {
            try{server.close(); } catch(Exception e){e.printStackTrace();}
        }
    }
    public static void main(String[] args) {
        Server server = new Server();

        try {
            server.start();
        }catch(Exception e){server.stop();}
    }
}