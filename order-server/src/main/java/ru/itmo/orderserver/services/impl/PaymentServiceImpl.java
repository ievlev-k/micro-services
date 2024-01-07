package ru.itmo.orderserver.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public PaymentResponse save(PaymentRequest paymentRequest) {
        Payment payment = paymentMapper.paymentRequestToPayment(paymentRequest);
        return paymentMapper.paymentToPaymentResponse(paymentRepository.save(payment));
    }

    @Override
    public Page<PaymentResponse> getAllPage(Pageable pageable) {
        return paymentMapper.paymentToPaymentResponsePage(paymentRepository.findAll(pageable));
    }

    @Override
    public List<PaymentResponse> getAllPayment() {
        return paymentMapper.paymentToPaymentResponseList(paymentRepository.findAll());
    }

    @Override
    public PaymentResponse update(PaymentUpdate paymentUpdate) {
        Payment payment = paymentMapper.paymentUpdateToPayment(paymentUpdate);
        return paymentMapper.paymentToPaymentResponse(paymentRepository.save(payment));
    }

    @Override
    public PaymentResponse getPaymentById(Long id) {
        return paymentMapper.paymentToPaymentResponse(paymentRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("payment with id " + id + " not found")));
    }

    @Override
    public void deleteById(Long id) {
        paymentRepository.deleteById(id);
    }
}
