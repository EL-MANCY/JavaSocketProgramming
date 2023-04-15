package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(12345);

        boolean server = true;
        byte[] inBuffer = new byte[1000];
        byte[] outBuffer = new byte[1000];

        while (server) {
            DatagramPacket replyDatagramPacket = new DatagramPacket(inBuffer, inBuffer.length);
            datagramSocket.receive(replyDatagramPacket);
            String inputLine = new String(replyDatagramPacket.getData(), 0, replyDatagramPacket.getLength());

            if (inputLine.equals("Ping")) {
                System.out.println("CLIENT SENT: "+inputLine);
                outBuffer = "Pong".getBytes();
                DatagramPacket requestDatagramPacket =
                        new DatagramPacket(outBuffer, outBuffer.length, replyDatagramPacket.getAddress(), replyDatagramPacket.getPort());
                datagramSocket.send(requestDatagramPacket);
            } else if (inputLine.equals("Exit")) {
                System.out.println("CLIENT SENT: "+inputLine);
                outBuffer = "Exiting Now".getBytes();
                DatagramPacket ExitDatagramPacket =
                        new DatagramPacket(outBuffer, outBuffer.length, replyDatagramPacket.getAddress(), replyDatagramPacket.getPort());
                datagramSocket.send(ExitDatagramPacket);
                server = false;
            } else {
                System.out.println("CLIENT SENT: "+inputLine);
                outBuffer = "Not the right message".getBytes();
                DatagramPacket requestDatagramPacket =
                        new DatagramPacket(outBuffer, outBuffer.length, replyDatagramPacket.getAddress(), replyDatagramPacket.getPort());
                datagramSocket.send(requestDatagramPacket);

            }
        }
    }
}
