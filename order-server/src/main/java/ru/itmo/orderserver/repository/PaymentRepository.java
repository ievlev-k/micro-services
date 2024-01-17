package ru.itmo.orderserver.repository;


import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import org.springframework.data.domain.Pageable;
import ru.itmo.orderserver.model.Payment;
import reactor.core.publisher.Flux;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
@Repository
public interface PaymentRepository extends ReactiveCrudRepository<Payment, Long> {
    Flux<Payment> findAllBy(Pageable pageable);
}
