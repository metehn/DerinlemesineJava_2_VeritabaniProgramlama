package DatabaseProgramming001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtilities {


    static String url = "jdbc:mysql://localhost:3306/metehandb";
    static String user = "root";
    static String password = "root";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;


    }

}
