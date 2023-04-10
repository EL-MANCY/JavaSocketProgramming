import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class test {
    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket =new DatagramSocket();

        byte [] buffer = "djd".getBytes();
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 123444;

        DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length,inetAddress,port);
        datagramSocket.send(datagramPacket);

        datagramPacket = new DatagramPacket(buffer,buffer.length);
        datagramSocket.receive(datagramPacket);

    }
}
