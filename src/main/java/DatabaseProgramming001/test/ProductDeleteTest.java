package DatabaseProgramming001.test;

import DatabaseProgramming001.manager.ProductManager;

import java.sql.SQLException;

public class ProductDeleteTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ProductManager manager = new ProductManager();

        long productId = 2;

        boolean b = manager.delete(productId);
        System.out.println("Silindi " + b);
    }

}
