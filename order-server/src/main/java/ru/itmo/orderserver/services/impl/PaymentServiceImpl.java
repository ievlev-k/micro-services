package ru.itmo.orderserver.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import ru.itmo.orderserver.dto.request.PaymentRequest;
import ru.itmo.orderserver.dto.response.PaymentResponse;
import ru.itmo.orderserver.dto.update.PaymentUpdate;
import ru.itmo.orderserver.exeptions.ObjectNotFoundException;
import ru.itmo.orderserver.mapper.PaymentMapper;

import ru.itmo.orderserver.model.Payment;
import ru.itmo.orderserver.repository.PaymentRepository;
import ru.itmo.orderserver.services.PaymentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
//
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
//
    @Override
    public Mono<PaymentResponse> save(PaymentRequest paymentRequest) {
        return paymentRepository.save(paymentMapper.paymentRequestToPayment(paymentRequest)).map(paymentMapper::paymentToPaymentResponse);


    }

    @Override
    public Flux<PaymentResponse> getAllPage(Pageable pageable) {
        return paymentRepository.findAllBy(pageable).subscribeOn(Schedulers.boundedElastic()).map(paymentMapper::paymentToPaymentResponse);
    }

    @Override
    public Flux<PaymentResponse> getAllPayment() {
        return paymentRepository.findAll().map(paymentMapper::paymentToPaymentResponse);
    }

    @Override
    public Mono<PaymentResponse> update(PaymentUpdate paymentUpdate) {
        return paymentRepository.save(paymentMapper.paymentUpdateToPayment(paymentUpdate)).map(paymentMapper::paymentToPaymentResponse);

    }

    @Override
    public Mono<PaymentResponse> getPaymentById(Long id) {
        return paymentRepository.findById(id).map(paymentMapper::paymentToPaymentResponse);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return paymentRepository.findById(id).subscribeOn(Schedulers.boundedElastic())
                .switchIfEmpty(Mono.error(new ObjectNotFoundException("This payment don't exist!")))
                .then(paymentRepository.deleteById(id)).then();

    }

}
