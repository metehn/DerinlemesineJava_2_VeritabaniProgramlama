package DatabaseProgramming009.greeting;

import java.io.*;
import java.net.Socket;

public class GreetingClient {

    public static void main(String[] args) throws IOException {

        String host = "localhost";
        int port = 5555;

        Socket socket = new Socket(host, port);

        InputStream in = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(isr);

        OutputStream out = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(out);
        BufferedWriter writer = new BufferedWriter(osw);

        String request = "Merhaba sunucu\r\n";
        writer.write(request);
        writer.flush();

        String response = reader.readLine();
        System.out.println("sunucunun yanıtı: " + response);

    }

}
