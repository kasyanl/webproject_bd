package kasyan.repository;

import kasyan.bean.Product;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDataBase implements ProductRepository, InitializingBean {

    private ProductRepository productRepository;
//
//    public ProductDataBase(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @Override
//    public List<Product> getAllProduct() {
////        List<Product> listProduct = new ArrayList<>();
////        for (Product product : productRepository.getAllProduct()) {
////            listProduct.add(product);
////        }
//        return productRepository.getAllProduct();



    //    @Query("SELECT * FROM product ORDER BY id")
//    @Override
//    public List<Product> getProductById() {
//        return null;
//    }

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
//
//
//    public static List<Product> findAll() {
//        return listProduct;
//    }
//
//    public void save(Product product) {
//        listProduct.add(product);
//    }
//
//    public void deleteById(int id) {
//        listProduct.removeIf(nextProduct -> nextProduct.getId() == id);
//    }
//
//    public Product findById(int id) throws ProductNotFoundException {
//        for (Product student : listProduct) {
//            if (student.getId() == id) return student;
//        }
//        throw new ProductNotFoundException("Student with id=" + id + " not found!");
//    }
//

    @Override
    public List<Product> findAll() {
        return null;
    }

     @Override
    public List<Product> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void deleteAll(Iterable<? extends Product> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Product> S save(S s) {
        return null;
    }

    @Override
    public <S extends Product> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Product> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    @Query(nativeQuery = true, value = "SELECT * FROM product")
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public Product getProductById(int id) {
        for (Product product : productRepository.getAllProduct()){
            return product;
        }
        return new Product();
    }

    @Override
    public void afterPropertiesSet() {
    }
}