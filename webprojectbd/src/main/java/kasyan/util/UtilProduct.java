package kasyan.util;

import kasyan.bean.Product;
import kasyan.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UtilProduct {

    private ProductRepository productRepository;

    public List<Product> allProduct() {

        List<Product> listProduct = new ArrayList<>();

        for(Product product : productRepository.getAllProduct()){
            listProduct.add(product);
        }
        return listProduct;

    }
}
