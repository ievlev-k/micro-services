package ru.itmo.orderserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.orderserver.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}