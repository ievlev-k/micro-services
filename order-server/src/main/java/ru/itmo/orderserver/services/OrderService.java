package ru.itmo.orderserver.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.itmo.orderserver.dto.request.OrderRequest;
import ru.itmo.orderserver.dto.response.OrderResponse;
import ru.itmo.orderserver.dto.update.OrderUpdate;


import java.util.List;

public interface OrderService {
    OrderResponse addOrder(OrderRequest orderRequest);

    Page<OrderResponse> getAllPage(Pageable pageable);
    List<OrderResponse> getAllOrder();

    OrderResponse update(OrderUpdate orderUpdate);

    OrderResponse getOrderDetail(Long id);

    void deleteById(Long id);

    void addProductsByIdForOrder(Long orderId, List<Long> productIds);
}
