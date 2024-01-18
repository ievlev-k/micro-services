package ru.itmo.orderserver.controller;
//
import liquibase.pro.packaged.F;
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
import ru.itmo.orderserver.dto.request.OrderRequest;
import ru.itmo.orderserver.dto.response.OrderResponse;
import ru.itmo.orderserver.dto.update.OrderUpdate;
import ru.itmo.orderserver.model.OrderProductDto;
import ru.itmo.orderserver.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import ru.itmo.orderserver.feign.AuthFeignClient;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value="/api/v1/order")
public class OrderController {
    private final OrderService orderService;
    private final AuthFeignClient authFeign;
	private final CircuitBreaker circuitBreaker;

    @PostMapping
    public ResponseEntity<Mono<OrderResponse>> addOrder(@RequestBody OrderRequest orderRequest, @RequestHeader("Authorization") String token) {
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
        return new ResponseEntity<>(orderService.addOrder(orderRequest), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<Flux<OrderResponse>> getOrderPage(@PageableDefault(size = 5) Pageable pageable)  {
        return ResponseEntity.ok(orderService.getAllPage(pageable));
    }

    @GetMapping("/all")
    public ResponseEntity<Flux<OrderResponse>> getAllOrder()  {
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @PutMapping
    public ResponseEntity<Mono<OrderResponse>> updateOrder(@RequestBody OrderUpdate orderUpdate, @RequestHeader("Authorization") String token){
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
        return ResponseEntity.ok(orderService.update(orderUpdate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<OrderResponse>> getOrderDetail(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderDetail(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<String>> deleteOrder(@PathVariable Long id, @RequestHeader("Authorization") String token) {
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
        orderService.deleteById(id);
        return ResponseEntity.ok(Mono.just("Order deleted"));
    }
//
//    @PostMapping("/add-product")
////    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
//    public Mono<Void> addProductsForOrder(@Valid @RequestBody OrderProductDto request) {
//        return orderService.addProductsByIdForOrder(request.getOrderId(), request.getProductIds());
//    }
}
