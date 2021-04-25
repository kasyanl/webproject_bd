package kasyan.bean;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int id;
    private String category;
    private String name;
    private double price;
    private double discount;
    private double actualPrice;
    private String data;

    public Product(int id, String category, String name, double price, double discount, double actualPrice) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.actualPrice = actualPrice;
    }
}