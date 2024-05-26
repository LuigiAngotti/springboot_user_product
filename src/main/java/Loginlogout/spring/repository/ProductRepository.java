package Loginlogout.spring.repository;

import Loginlogout.spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByUserId(Long userId);
}
