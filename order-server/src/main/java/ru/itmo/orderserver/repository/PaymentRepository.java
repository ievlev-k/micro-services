package ru.itmo.orderserver.repository;


import org.springframework.stereotype.Repository;
import ru.itmo.orderserver.model.Payment;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
@Repository
public interface PaymentRepository extends ReactiveCrudRepository<Payment, Long> {
}
