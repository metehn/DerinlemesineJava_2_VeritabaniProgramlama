package DatabaseProgramming001.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Product { //Entity

    private long productId;
    private String productName;
    private double salesPrice;

    @Override
    public String toString() {
        return productId + " " + productName + " " + salesPrice;
    }
}
