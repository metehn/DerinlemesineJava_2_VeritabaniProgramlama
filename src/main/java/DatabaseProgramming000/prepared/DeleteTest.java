package DatabaseProgramming000.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/metehandb";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url,user, password);

        /*
        sql injection'u önlemek için bu yöntemi kullan
        */

        String sql = "delete from Product where productId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, 2);
        int affected = statement.executeUpdate();

        System.out.println("Etkilenen satır sayısı " + affected);

        connection.close();

    }

}
