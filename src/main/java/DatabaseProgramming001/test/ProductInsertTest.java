package DatabaseProgramming001.test;

import DatabaseProgramming001.entity.Product;
import DatabaseProgramming001.manager.ProductManager;

import java.sql.SQLException;

public class ProductInsertTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Product product = new Product(0, "Iphone 11", 15300);
        ProductManager manager = new ProductManager();
        manager.insert(product);

    }
}
