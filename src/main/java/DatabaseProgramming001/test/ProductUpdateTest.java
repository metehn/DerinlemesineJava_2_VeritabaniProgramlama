package DatabaseProgramming001.test;

import DatabaseProgramming001.entity.Product;
import DatabaseProgramming001.manager.ProductManager;

import java.sql.SQLException;

public class ProductUpdateTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ProductManager manager = new ProductManager();
        Product product = new Product(1, "Akıllı Telefon", 6987);
        boolean b =manager.update(product);
        System.out.println("Güncelleme "+ b);
    }


}
