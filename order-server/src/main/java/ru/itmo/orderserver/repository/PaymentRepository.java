package ru.itmo.orderserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.orderserver.model.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
