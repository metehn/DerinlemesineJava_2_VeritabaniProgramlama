package DatabaseProgramming008.serial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ProductDeSerializer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String file = "src/main/java/documents/product.ser";

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Product product = (Product)ois.readObject();
        ois.close();

        System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice() + " " + product.getProductType() );

    }

}
