package kasyan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;


@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product{

    @Id
    @GeneratedValue
    @GenericGenerator(name = "", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "category")
    private String category;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "discount")
    private double discount;

    @Column(name = "actualPrice")
    private double actualPrice;

}


