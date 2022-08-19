package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/metehandb";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, user, password);

        connection.setAutoCommit(false); /* varsayılan olarak true. Her yapılan otomatik işlenir,
                                            bunu değiştirmek için false yaptım
                                         */

        /*
        Not: commit yapmayıp 1 kez çalıştırdığında auto increment artıyor databaseye yazmıyor,
             commit'i yazıp çalıştırdığında 1 tane artmış şekilde databaseye yazıyor.
             Hata verince de auto increment artıyor ama uygulama hata veriyor, tekrar çalıştırdığında
             artmış şekilde yazıyor.
        */

        String sql1 = "insert into Product(productName, salesPrice) values (?,?)";
        PreparedStatement statement1 = connection.prepareStatement(sql1);
        statement1.setString(1, "Araba");
        statement1.setDouble(2, 20000);
        int affected = statement1.executeUpdate();

        System.out.println("Etkilenen satır sayısı " + affected);

        connection.rollback();// buraya kadar olan işlemleri databaseye yazmıyor ama auto increment artmaya devam ediyor

        String sql2 = "insert into Product(productName, salesPrice) values (?,?)";
        PreparedStatement statement2 = connection.prepareStatement(sql2);
        statement2.setString(1, "Saat");
        statement2.setDouble(2, 500);
        int affected2 = statement2.executeUpdate();

        System.out.println("Etkilenen satır sayısı " + affected2);

        connection.commit(); //databaseye işlemesi için bu komutu yazman gerekiyor

        connection.close();

    }
    /*
    İLERİ KONULAR
        Güncellenebilir Sonuç Kümesi (updatable result set)
        Kaydırılabilir Sonuç Kümesi (scrollable result set)
        Yığın (batch) İşlemler
        Satır Kümesi (row set)
    */

}
