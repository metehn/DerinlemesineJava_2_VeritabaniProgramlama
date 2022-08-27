package DatabaseProgramming008.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ProductSerializer {

    public static void main(String[] args) throws IOException {

        String file = "src/main/java/documents/product.ser";

        Product product = new Product().builder().productId(1111).productName("Akıllı Telefon").salesPrice(15000).build();
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(product);
        oos.close();


    }

}
