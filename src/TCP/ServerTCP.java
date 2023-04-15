package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) throws IOException {

        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());

                String InputLine;
                while ((InputLine = in.readUTF()) != null) {
                    if (InputLine.equals("Ping")) {
                        System.out.println("CLIENT ENTERED: " + InputLine);
                        out.writeUTF("Pong");
                    } else if (InputLine.equals("Exit")) {
                        System.out.println("CLIENT ENTERED: " + InputLine);
                        out.writeUTF("Connection Closed");
                        clientSocket.close();
                        break;
                    } else {
                        out.writeUTF("Not the right message");
                    }
                }
            }
        } catch (EOFException e) {
            // handle EOFException
            System.err.println("Client closed the connection unexpectedly.");
        }
    }
}
