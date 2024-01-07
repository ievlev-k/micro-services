package ru.itmo.orderserver.services.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.orderserver.dto.request.OrderRequest;
import ru.itmo.orderserver.dto.response.OrderResponse;
import ru.itmo.orderserver.dto.update.OrderUpdate;
import ru.itmo.orderserver.exeptions.ObjectNotFoundException;
import ru.itmo.orderserver.feight.ProductFeignClient;
import ru.itmo.orderserver.mapper.OrderMapper;
import ru.itmo.orderserver.model.Order;
import ru.itmo.orderserver.model.Product;
import ru.itmo.orderserver.repository.OrderRepository;
import ru.itmo.orderserver.repository.PaymentRepository;
import ru.itmo.orderserver.repository.ProductRepository;
import ru.itmo.orderserver.services.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final OrderMapper orderMapper;
    private final ProductRepository productRepository;
    private final ProductFeignClient productFeignClient;



    @Override
    public OrderResponse addOrder(OrderRequest orderRequest) {
        Order order = orderMapper.orderRequestToOrder(orderRequest);
        paymentRepository.findById(orderRequest.getPaymentId())
                .orElseThrow(() -> new ObjectNotFoundException("PaymentId: " + orderRequest.getPaymentId() + " not exist"));
        return orderMapper.orderToOrderResponse(orderRepository.save(order));
    }

    @Override
    public Page<OrderResponse> getAllPage(Pageable pageable) {
        return orderMapper.orderToOrderResponsePage(orderRepository.findAll(pageable));
    }

    @Override
    public List<OrderResponse> getAllOrder() {
        return orderMapper.orderToOrderResponseList(orderRepository.findAll());
    }

    @Override
    public OrderResponse update(OrderUpdate orderUpdate) {
        Order order = orderMapper.orderUpdateToOrder(orderUpdate);
        return orderMapper.orderToOrderResponse(orderRepository.save(order));
    }

    @Override
    public OrderResponse getOrderDetail(Long id) {
        return orderMapper.orderToOrderResponse(orderRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Order with id " + id + " not found"))
        );
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addProductsByIdForOrder(Long orderId, List<Long> productIds) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ObjectNotFoundException("Order with id " + orderId + " not found"));
        List<Long> productIdsByOrder = order.getProducts().stream().map(Product::getId).collect(Collectors.toList());
        productIds.removeAll(productIdsByOrder);
//        List<Product> products = productFeignClient.getAllProductsByIds(productIds);
        String products = productFeignClient.getAllProductsByIds(productIds);
        System.out.println(products);
//        order.getProducts().addAll(products);
//        orderRepository.save(order);
    }


}
