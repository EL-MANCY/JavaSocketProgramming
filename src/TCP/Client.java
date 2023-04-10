package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Scanner scanner =new Scanner(System.in);

        Socket socket = new Socket("localhost", 1234);

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        System.out.println("Enter Your Message");
        String output=scanner.nextLine();

        out.writeUTF(output);

        String respone=in.readUTF();

        System.out.println(respone);

        in.close();
        out.close();
        socket.close();
    }
}
