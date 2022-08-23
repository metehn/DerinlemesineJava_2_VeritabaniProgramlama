package DatabaseProgramming001.test;

import DatabaseProgramming001.entity.Product;
import DatabaseProgramming001.manager.ProductManager;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductListLikeAndTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ProductManager manager = new ProductManager();

        String condition = "a%";
        double salesPrice = 500;
        ArrayList<Product> list =  manager.listByProductNameLikeAnd(condition, salesPrice);
        for (Product product : list){
            System.out.println(product.toString());

        }
    }
}
