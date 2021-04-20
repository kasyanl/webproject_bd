package kasyan.repository;

import kasyan.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Repository
@Transactional(readOnly = true)
public interface ProductRepository extends CrudRepository<Product, Integer> {


    @Query(nativeQuery = true, value = "SELECT * FROM product.product")
    List<Product> getAllProduct();

    @Query(nativeQuery = true, value = "SELECT * FROM product.product ORDER BY id")
    Product getProductById(int id);
}