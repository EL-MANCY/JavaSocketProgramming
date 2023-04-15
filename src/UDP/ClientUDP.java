package UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) throws IOException {

        boolean x=true;
        DatagramSocket datagramSocket = new DatagramSocket();

        while (x) {
            System.out.println("______________________________________________________________");
            System.out.println("Enter Your Message");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            byte[] outBuffer = input.getBytes();
            InetAddress host = InetAddress.getByName("localhost");
            int port = 12345;

            DatagramPacket requestDatagramPacket = new DatagramPacket(outBuffer, outBuffer.length, host, port);
            datagramSocket.send(requestDatagramPacket);

            byte[] inBuffer = new byte[1000];
            DatagramPacket replyDatagramPacket = new DatagramPacket(inBuffer, inBuffer.length);
            datagramSocket.receive(replyDatagramPacket);

            String inputLine = new String(replyDatagramPacket.getData(), 0, replyDatagramPacket.getLength());


            System.out.println("Reply: " + inputLine);

            if(inputLine.equals("Exiting Now")){
                datagramSocket.close();
                x=false;
            }

        }



    }
    }

