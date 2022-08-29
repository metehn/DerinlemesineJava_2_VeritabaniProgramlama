package DatabaseProgramming009.greeting;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetingServer {

    public static void main(String[] args) throws IOException {

        int port = 5555;
        ServerSocket serverSocket = new ServerSocket(port);

        while(true){

            Socket socket = serverSocket.accept();
            System.out.println("Bir istemci bağlandı");

            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader reader = new BufferedReader(isr);

            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out);
            BufferedWriter writer = new BufferedWriter(osw);

            String request = reader.readLine();
            System.out.println("istemci iletisi: " + request);

            String response = "Merhaba istemci \r\n";
            writer.write(response);
            writer.flush();

            System.out.println("İletişim sağlandı");

        }


    }

}
