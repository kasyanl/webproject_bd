package kasyan.repository;

import kasyan.bean.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT *  FROM product")
    List<Product> getAllProduct();

    @Query(value = "SELECT * FROM product ORDER BY id")
    List<Product> getProductById();
}