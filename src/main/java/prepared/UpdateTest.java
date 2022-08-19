package prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/metehandb";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url,user, password);

        /*
        sql injection'u önlemek için bu yöntemi kullan
        */

        String sql = "update Product set productName=?, salesPrice=? where productId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "Iphone 11");
        statement.setDouble(2, 17100.0);
        statement.setLong(3, 4);
        int affected = statement.executeUpdate();

        System.out.println("Etkilenen satır sayısı " + affected);

        connection.close();

    }

}
