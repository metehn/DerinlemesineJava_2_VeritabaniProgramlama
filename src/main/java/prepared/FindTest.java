package prepared;

import java.sql.*;

public class FindTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/metehandb";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url,user, password);

        /*
        sql injection'u önlemek için bu yöntemi kullan
        */

        String sql = "select * from Product where productId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, 3);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) { // if kullandık çünkü 1 değer dönecek
            long productId = resultSet.getLong(("productId"));
            String productName = resultSet.getString("productName");
            float salesPrice = resultSet.getFloat("salesPrice");

            System.out.println(productId + " " + productName + " " + salesPrice + " " );
        }

        connection.close();

    }

}
