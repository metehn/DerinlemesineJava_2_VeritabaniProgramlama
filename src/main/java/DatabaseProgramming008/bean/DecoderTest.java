package DatabaseProgramming008.bean;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class DecoderTest {


public static void main(String[]args) throws FileNotFoundException {

        String path = "src/main/java/documents/department.xml";
        FileInputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);
        XMLDecoder decoder = new XMLDecoder(bis);

        Department departmentA = (Department) decoder.readObject();
        decoder.close();

        System.out.println(departmentA.toString());

        }



}
