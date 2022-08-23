package DatabaseProgramming001.test;

import DatabaseProgramming001.entity.Product;
import DatabaseProgramming001.manager.ProductManager;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductListLikeTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ProductManager manager = new ProductManager();
        /*
        "A%"; -> A ile başlayan
        "%A"; -> A ile biten
        "%A%" -> Arada A olan
        not: küçük harf büyük harf farketmiyor. A% yazdığında küçük a olanları da getiriyor!
         */
        String condition = "a%";
        ArrayList<Product> list =  manager.listByProductNameLike(condition);
        for (Product product : list){
            System.out.println(product.toString());

        }
    }
}
