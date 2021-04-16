package kasyan.repository;

import kasyan.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface JpaProductRepository extends JpaRepository<Product, Integer> {
}