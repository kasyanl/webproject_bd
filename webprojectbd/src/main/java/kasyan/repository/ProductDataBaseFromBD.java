package kasyan.repository;

import kasyan.bean.Product;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDataBaseFromBD{

    private JpaProductRepository jpaProductRepository;

    public ProductDataBaseFromBD (JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Autowired
    public void setJpaProductRepository(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    public List<Product> findAll() {
        return jpaProductRepository.findAll();
    }

}
