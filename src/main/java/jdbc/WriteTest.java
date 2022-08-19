package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WriteTest  {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/metehandb";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url,user, password);

        String sql = "insert into Product(productName, salesPrice) values ('Bilgisayar',1239)";
        Statement statement = connection.createStatement();
        int affected = statement.executeUpdate(sql);

        System.out.println("Etkilenen satır sayısı " + affected);


        connection.close();

    }
}
