package ru.itmp.productserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmp.productserver.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
