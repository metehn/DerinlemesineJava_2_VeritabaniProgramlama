package DatabaseProgramming001.test;

import DatabaseProgramming001.DatabaseUtilities;
import DatabaseProgramming001.entity.Product;
import DatabaseProgramming001.manager.ProductManager;

import java.sql.SQLException;

public class ProductFindTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ProductManager manager = new ProductManager();
        long productId = 1;

        Product product = manager.find( productId );

        if(product != null){

            System.out.println(product.getProductId() + " "+ product.getProductName() + " " + product.getSalesPrice());
        }else {

            System.out.println("Ürün bulunamadı " + productId);
        }


    }


}
