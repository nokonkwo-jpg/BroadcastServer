package main.java.sockets;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;

    public void init() throws Exception{
        socket = new Socket("10.252.180.173", 8080);
        System.out.println("Connected to server");
    }
    public void send(String msg) throws Exception{
        System.out.println("Sending to server ");
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(msg);
    }
    public void stop() {
        if (socket != null) {
            try{socket.close(); } catch(Exception e){e.printStackTrace();}
        }
    }
    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        try{
            client.init();
            System.out.println("Enter a message: ");
            String msg = scanner.nextLine();
            client.send(msg);
            scanner.close();
        }catch(Exception e){client.stop();}
    }
}