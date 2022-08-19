package jdbc;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class ReadTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/metehandb";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "select * from Product";
        Statement statement = connection.createStatement();

        ResultSet resultset = statement.executeQuery(sql);

        while (resultset.next()) {
            long productId = resultset.getLong(("productId"));
            String productName = resultset.getString("productName");
            float salesPrice = resultset.getFloat("salesPrice");

            System.out.println(productId + " " + productName + " " + salesPrice + " " );
        }

        connection.close();

    }


}
