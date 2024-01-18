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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;
import ru.itmo.orderserver.feign.AuthFeignClient;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value="/api/v1/payment")
public class PaymentController {
    private final PaymentService paymentService;
    private final AuthFeignClient authFeign;
	private final CircuitBreaker circuitBreaker;


    @PostMapping
    public ResponseEntity<Mono<PaymentResponse>> addPayment(@RequestBody PaymentRequest paymentRequest, @RequestHeader("Authorization") String token) {
        boolean isAdmin = false;
        try {
            isAdmin = circuitBreaker.decorateSupplier(() -> authFeign.checkAdminPermission(token)).get();
        } catch(Exception e) {
            System.out.println("Error:" + e);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        if (!isAdmin) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return new ResponseEntity<>(paymentService.save(paymentRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Flux<PaymentResponse>> getListPayment(@PageableDefault(size = 5) Pageable pageable)  {
        return ResponseEntity.ok(paymentService.getAllPage(pageable));
    }

    @GetMapping("/all")
    public ResponseEntity<Flux<PaymentResponse>> getAllPayment()  {
        return ResponseEntity.ok(paymentService.getAllPayment());
    }

    @PutMapping
    public ResponseEntity<Mono<PaymentResponse>> updatePayment(@RequestBody PaymentUpdate paymentUpdate, @RequestHeader("Authorization") String token){
        boolean isAdmin = false;
        try {
            isAdmin = circuitBreaker.decorateSupplier(() -> authFeign.checkAdminPermission(token)).get();
        } catch(Exception e) {
            System.out.println("Error:" + e);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        if (!isAdmin) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.ok(paymentService.update(paymentUpdate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<PaymentResponse>> getPaymentDetail(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<String>> deletePayment(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        boolean isAdmin = false;
        try {
            isAdmin = circuitBreaker.decorateSupplier(() -> authFeign.checkAdminPermission(token)).get();
        } catch(Exception e) {
            System.out.println("Error:" + e);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        if (!isAdmin) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        paymentService.deleteById(id);
        return ResponseEntity.ok(Mono.just("Delete payment success"));
    }

}
