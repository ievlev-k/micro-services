package ru.itmo.orderserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itmo.orderserver.dto.request.PaymentRequest;
import ru.itmo.orderserver.dto.response.PaymentResponse;
import ru.itmo.orderserver.dto.update.PaymentUpdate;
import ru.itmo.orderserver.services.PaymentService;


import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value="/api/v1/payment")
public class PaymentController {
    private final PaymentService paymentService;

//    @PostMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
//    public PaymentResponse addPayment(@Valid @RequestBody PaymentRequest paymentRequest) {
//        return paymentService.save(paymentRequest);
//    }
//
//    @GetMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
//    public Page<PaymentResponse> getListPayment(@PageableDefault(size = 5) Pageable pageable)  {
//        return paymentService.getAllPage(pageable);
//    }

    @GetMapping("/all")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public Flux<PaymentResponse> getAllPayment()  {
        return paymentService.getAllPayment();
    }
//
//    @PutMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
//    public PaymentResponse updatePayment(@Valid @RequestBody PaymentUpdate paymentUpdate){
//        return paymentService.update(paymentUpdate);
//    }
//
//    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
//    public PaymentResponse getPaymentDetail(@PathVariable Long id) {
//        return paymentService.getPaymentById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
//    public void deletePayment(@PathVariable Long id) {
//        paymentService.deleteById(id);
//    }

}
