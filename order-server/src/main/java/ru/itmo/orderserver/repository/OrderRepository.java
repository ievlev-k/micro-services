package ru.itmo.orderserver.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.orderserver.model.Order;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import org.springframework.data.domain.Pageable;
import ru.itmo.orderserver.model.Payment;
import reactor.core.publisher.Flux;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

@Repository
public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
    Flux<Order> findAllBy(Pageable pageable);
}
