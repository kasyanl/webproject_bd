package kasyan.service;

import kasyan.bean.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductServiceInterface {

    List<Product> getAllProduct();
}
