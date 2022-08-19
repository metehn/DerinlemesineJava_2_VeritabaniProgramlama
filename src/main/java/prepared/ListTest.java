package prepared;

import java.sql.*;

public class ListTest {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/metehandb";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "select * from Product";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            long productId = resultSet.getLong(("productId"));
            String productName = resultSet.getString("productName");
            float salesPrice = resultSet.getFloat("salesPrice");

            System.out.println(productId + " " + productName + " " + salesPrice + " " );
        }

        connection.close();

    }


}
