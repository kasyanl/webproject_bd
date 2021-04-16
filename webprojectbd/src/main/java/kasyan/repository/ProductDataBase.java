package kasyan.repository;

import kasyan.bean.Product;
import kasyan.exceptions.ProductNotFoundException;
import kasyan.service.ProductService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDataBase implements ProductRepository, InitializingBean {

//    static {
//        listProduct.add(ProductService.creatProduct("FRUITS", "Apple", 10.0, 50.0));
//        listProduct.add(ProductService.creatProduct("FRUITS", "Orange", 12.10, 10.0));
//        listProduct.add(ProductService.creatProduct("FRUITS", "Banana", 9.50, 20.0));
//        listProduct.add(ProductService.creatProduct("BERRIES", "Cherry", 25.00, 5.0));
//        listProduct.add(ProductService.creatProduct("BERRIES", "Strawberry", 15.25, 60.0));
//        listProduct.add(ProductService.creatProduct("BERRIES", "Watermelon", 50.20, 15.0));
//        listProduct.add(ProductService.creatProduct("VEGETABLES", "Tomato", 5.50, 30.0));
//        listProduct.add(ProductService.creatProduct("VEGETABLES", "Cucumbers", 3.20, 20.0));
//        listProduct.add(ProductService.creatProduct("VEGETABLES", "Onion", 10.10, 40.0));
//        listProduct.add(ProductService.creatProduct("MILK_PRODUCT", "Cottage cheese", 15.10, 10.0));
//        listProduct.add(ProductService.creatProduct("MILK_PRODUCT", "Sour cream", 25.00, 00.0));
//        listProduct.add(ProductService.creatProduct("MILK_PRODUCT", "Yogurt", 20.50, 10.0));
//        listProduct.add(ProductService.creatProduct("MEAT", "Pork", 50.20, 30.0));
//        listProduct.add(ProductService.creatProduct("MEAT", "Beef", 66.15, 00.0));
//        listProduct.add(ProductService.creatProduct("MEAT", "Chicken meat", 15.10, 00.0));
//        listProduct.add(ProductService.creatProduct("ALCOHOLIC_BEVERAGES", "Beer", 10.5, 00.0));
//        listProduct.add(ProductService.creatProduct("ALCOHOLIC_BEVERAGES", "Whiskey", 100.00, 00.0));
//        listProduct.add(ProductService.creatProduct("ALCOHOLIC_BEVERAGES", "Wine", 40.10, 00.0));
//    }


    public static List<Product> findAll() {
        return listProduct;
    }

    public void save(Product product) {
        listProduct.add(product);
    }

    public void deleteById(int id) {
        listProduct.removeIf(nextProduct -> nextProduct.getId() == id);
    }

    public Product findById(int id) throws ProductNotFoundException {
        for (Product student : listProduct) {
            if (student.getId() == id) return student;
        }
        throw new ProductNotFoundException("Student with id=" + id + " not found!");
    }

    @Override
    public void afterPropertiesSet() {
    }
}