package ru.itmo.orderserver.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itmo.orderserver.dto.request.PaymentRequest;
import ru.itmo.orderserver.dto.response.PaymentResponse;
import ru.itmo.orderserver.dto.update.PaymentUpdate;

import java.util.List;

public interface PaymentService {
    Mono<PaymentResponse> save (PaymentRequest paymentRequest);
//    Page<PaymentResponse> getAllPage(Pageable pageable);
    Flux<PaymentResponse> getAllPayment();

    Mono<PaymentResponse> update(PaymentUpdate paymentUpdate);
//
    Mono<PaymentResponse> getPaymentById(Long id);
//
    Mono<Void> deleteById(Long id);


    Flux<PaymentResponse> getAllPage(Pageable pageable);

}
