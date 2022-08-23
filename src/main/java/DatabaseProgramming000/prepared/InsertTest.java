package DatabaseProgramming000.prepared;

import java.sql.*;

public class InsertTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/metehandb";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url,user, password);

        /*
        sql injection'u önlemek için bu yöntemi kullan
        */

        String sql = "insert into Product(productName, salesPrice) values (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "Akıllı Telefon");
        statement.setDouble(2, 15000.0);
        int affected = statement.executeUpdate();

        System.out.println("Etkilenen satır sayısı " + affected);

        connection.close();

    }

}
