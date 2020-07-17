import java.io.IOException;
import java.net.*;

public class Main {

    static InetAddress address;
    static ServerSocket server;

    public static void main(String[] args) throws IOException {
        int port = 1234;

        // getting ip
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e1) {}
        server = new ServerSocket();

        // creating server
        SocketAddress socketAddress = new InetSocketAddress(address, port);
        server.bind(socketAddress);
        System.out.println("server running!");

        getClients();
    }

    static void getClients() throws IOException {
        while (true) {
            // waiting for clients
            System.out.println("waiting for clients");
            Socket client = server.accept();
            System.out.println("connection from " + client.getLocalAddress());
        }
    }
}