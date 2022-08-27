package DatabaseProgramming007.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionTest {

    public static void main(String[] args) throws IOException {

        String address = "http://www.google.com.tr";
        URL url = new URL(address);
        URLConnection connection =  url.openConnection();

        //OutputStream out = connection.getOutputStream(); // post etmek için
        InputStream in = connection.getInputStream();
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader( isr);

        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = reader.readLine()) !=null ){
            builder.append(line).append("\r\n");
        }
        String content = builder.toString();

        System.out.println(content);

    }

}
