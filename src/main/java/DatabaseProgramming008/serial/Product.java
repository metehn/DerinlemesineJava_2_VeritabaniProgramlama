package DatabaseProgramming008.serial;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product implements Serializable {

    static final long serialVersionUID = 134L;
    // Bu değer sayesinde Product sınıfına yeni bir değer eklediğimizde eski dosyayı sorunsuz şekilde okuyabileceğiz
    // Bu değeri yazmadan yeni bir özellik eklediğimizde hata verecektir. Mesela, private String productType değişkenini eklersek
    // yazdığımız nesnede böyle bir alan olmadığı için java, serialVersionUID'ye bakacak. Bu değeri bulamazsa böyle bir nesne bulumadım
    // diyip hata verecek ama bu değeri görürse Product olduğunu bilip yazabildiği değerleri yazacak


    private long productId;
    private String productName;
    private double salesPrice;
    private String productType;

}
