package ru.itmo.orderserver.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.itmo.orderserver.dto.request.PaymentRequest;
import ru.itmo.orderserver.dto.response.PaymentResponse;
import ru.itmo.orderserver.dto.update.PaymentUpdate;
import ru.itmo.orderserver.model.Payment;

import java.util.List;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class PaymentMapper {
    private final ModelMapper modelMapper;
    public Payment paymentRequestToPayment(PaymentRequest request) {
        return modelMapper.map(request, Payment.class);
    }

    public PaymentResponse paymentToPaymentResponse(Payment payment) {
        return modelMapper.map(payment, PaymentResponse.class);
    }

    public Page<PaymentResponse> paymentToPaymentResponsePage(Page<Payment> paymentPage){
        return paymentPage.map(this::paymentToPaymentResponse);
    }

    public List<PaymentResponse> paymentToPaymentResponseList(List<Payment>  paymentList) {
        return paymentList
                .stream()
                .map(this::paymentToPaymentResponse)
                .collect(Collectors.toList());
    }

    public Payment paymentUpdateToPayment (PaymentUpdate paymentUpdate) {
        return modelMapper.map(paymentUpdate, Payment.class);
    }
}
