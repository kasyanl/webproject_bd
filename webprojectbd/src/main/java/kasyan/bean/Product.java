package kasyan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

//    @Id
//    @GeneratedValue
    @Column(name = "id")
 //   @NotBlank
    private int id;

    @Column(name = "category")
//    @NotBlank
    private String category;

    @Column(name = "name")
 //   @NotBlank
    private String name;

    @Column(name = "price")
//    @NotBlank
    private double price;

    @Column(name = "discount")
  //  @NotBlank
    private double discount;

    @Column(name = "actualPrice")
  //  @NotBlank
    private double actualPrice;

}


