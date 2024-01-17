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
//    PaymentResponse save (PaymentRequest paymentRequest);
//    Page<PaymentResponse> getAllPage(Pageable pageable);
    Flux<PaymentResponse> getAllPayment();

//    PaymentResponse update(PaymentUpdate paymentUpdate);
//
//    PaymentResponse getPaymentById(Long id);
//
//    void deleteById(Long id);
}
