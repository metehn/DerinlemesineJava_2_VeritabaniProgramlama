package DatabaseProgramming000.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/metehandb";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url,user, password);/*
        getConnection() methodunu çağırdımız anda bağlantı yapılır
        sonradan bağlanmak istersek
        Connection connection; diyip bırakabilirsin, bağlanmak istediğin zaman getConnection() methodunu çağırabilirsin
        */

        System.out.println("Veritabanı " + connection.getMetaData().getDatabaseProductName());







        connection.close(); /* bağlantıyı kapatmayı unutursan  program çalışır ama bir süre sonra veritabanı çalışmaz
                               hale gelebilir çünkü bir sürü askıda olan bağlantılar olur ve
                               yeni isteklere yanıt vermeyebilir! */

    }

}
