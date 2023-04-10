package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(1234);

       while(true) {

           Socket clientSocket = serverSocket.accept();

           DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
           DataInputStream in = new DataInputStream(clientSocket.getInputStream());

           String InputLine;
           while ((InputLine = in.readUTF()) != null) {
               if (InputLine.equals("ping")) {
                   System.out.println(InputLine);
                   out.writeUTF("pong");
                   break;
               } else {
                   out.writeUTF("Wrong Answer...EXITING NOW!!");
                   break;
               }

           }
       }



    }


}
