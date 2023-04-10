package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class SERVER {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(12345);

        byte[] inBuffer = new byte[1000];
        byte[] outBuffer = new byte[1000];

        while (true){
            DatagramPacket replyDatagramPacket = new DatagramPacket(inBuffer,inBuffer.length);
            datagramSocket.receive(replyDatagramPacket);

            String inputLine = new String(replyDatagramPacket.getData(), 0, replyDatagramPacket.getLength());

            if(inputLine.equals("ping")){
                System.out.println(inputLine);
                outBuffer = "pong".getBytes();
                DatagramPacket requestDatagramPacket =
                        new DatagramPacket(outBuffer,outBuffer.length,replyDatagramPacket.getAddress(),replyDatagramPacket.getPort());
                datagramSocket.send(requestDatagramPacket);
            }else{
                outBuffer = "Wrong Answer".getBytes();

                DatagramPacket requestDatagramPacket =
                        new DatagramPacket(outBuffer,outBuffer.length,replyDatagramPacket.getAddress(),replyDatagramPacket.getPort());
                datagramSocket.send(requestDatagramPacket);

            }
        }
    }
}
