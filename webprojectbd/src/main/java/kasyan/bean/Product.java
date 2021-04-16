package kasyan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @NotBlank
    private int id;

    @Column(name = "category")
    @NotBlank
    private String category;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "price")
    @NotBlank
    private double price;

    @Column(name = "discount")
    @NotBlank
    private double discount;

    @Column(name = "actualPrice")
    @NotBlank
    private double actualPrice;

}


