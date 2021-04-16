package kasyan.service;

import kasyan.bean.Product;
import kasyan.repository.JpaProductRepository;
import kasyan.repository.ProductDataBase;
import kasyan.repository.ProductDataBaseFromBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceBD {


    private ProductDataBaseFromBD productDataBaseFromBD;

//
//    private final JpaProductRepository jpaProductRepository;
//
//    public ProductServiceBD(JpaProductRepository jpaProductRepository) {
//        this.jpaProductRepository = jpaProductRepository;
//    }

    public List<Product> getAll() {
        return productDataBaseFromBD.findAll();
    }
//
//    @Autowired
//    public void setJpaProductRepository(JpaProductRepository jpaProductRepository) {
//        this.jpaProductRepository = jpaProductRepository;
//    }
}

