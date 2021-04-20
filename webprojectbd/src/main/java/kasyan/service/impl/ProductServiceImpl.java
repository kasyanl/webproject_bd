package kasyan.service.impl;

import kasyan.bean.Product;
import kasyan.repository.ProductDataBase;
import kasyan.repository.ProductRepository;
import kasyan.service.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl{

    private ProductDataBase productDataBase;

    public List<Product> getAllProduct() {
        List<Product> newList = new ArrayList<>();
        List<Product> products = productDataBase.getAllProduct();
        for (Product product : products){
            newList.add(product);
        }
        return newList;
    }

    public Product getProductById(int id) {
             return productDataBase.getProductById(id);
    }

    @Autowired
    public void setProductDataBase(ProductDataBase productDataBase) {
        this.productDataBase = productDataBase;
    }
}
