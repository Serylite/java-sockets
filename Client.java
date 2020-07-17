import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class Client {
    
    static Socket client;
    static InetAddress address;
    static int port = 1234;

    public static void main(String[] args) throws IOException {
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e1) {}
        client = new Socket();

        // Connecting to server
        try {
            SocketAddress socketAddress = new InetSocketAddress(address, port);
            client.connect(socketAddress);
            System.out.println("connected");
        }catch (Exception e) {
            System.err.println("there was an error while connecting to " + address);
        }

        byte[] bytes = new byte[256];
        int a = client.getReceiveBufferSize();
    }
}