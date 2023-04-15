package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientTCP {
    public static void main(String[] args) throws IOException {

        boolean x = true;
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("localhost", 1234);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());


        while (x) {
            System.out.println("______________________________________________________________");
            System.out.println("Enter Your Message");
            String output = scanner.nextLine();

            out.writeUTF(output);

            String resposne = in.readUTF();
            System.out.println("SERVER RESPONDED BY: "+resposne);

            if (resposne.equals("Connection Closed")) {
                in.close();
                out.close();
                socket.close();
                x = false;
            }
        }


    }
}
