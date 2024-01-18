package ru.itmo.orderserver.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itmo.orderserver.dto.request.OrderRequest;
import ru.itmo.orderserver.dto.response.OrderResponse;
import ru.itmo.orderserver.dto.update.OrderUpdate;


import java.util.List;

public interface OrderService {
    Mono<OrderResponse> addOrder(OrderRequest orderRequest);
//
    Flux<OrderResponse> getAllPage(Pageable pageable);
    Flux<OrderResponse> getAllOrder();
//
    Mono<OrderResponse> update(OrderUpdate orderUpdate);
//
    Mono<OrderResponse> getOrderDetail(Long id);
//
    Mono<Void> deleteById(Long id);
//
    Mono<Void> addProductsByIdForOrder(Long orderId, List<Long> productIds);
}
