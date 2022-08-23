package DatabaseProgramming001.test;

import DatabaseProgramming001.entity.Product;
import DatabaseProgramming001.manager.ProductManager;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductListTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ProductManager manager = new ProductManager();
        ArrayList<Product> list = manager.list();
        for (Product product : list){
            System.out.println(product.toString());

        }
    }

}
