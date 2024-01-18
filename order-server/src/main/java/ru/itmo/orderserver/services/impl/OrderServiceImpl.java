package ru.itmo.orderserver.services.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import ru.itmo.orderserver.dto.request.OrderRequest;
import ru.itmo.orderserver.dto.response.OrderResponse;
import ru.itmo.orderserver.dto.update.OrderUpdate;
import ru.itmo.orderserver.exeptions.ObjectNotFoundException;
//import ru.itmo.orderserver.feign.ProductFeignClient;
import ru.itmo.orderserver.mapper.OrderMapper;
import ru.itmo.orderserver.model.Order;
import ru.itmo.orderserver.model.Product;
import ru.itmo.orderserver.repository.OrderRepository;
import ru.itmo.orderserver.repository.PaymentRepository;
import ru.itmo.orderserver.services.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
//    private final PaymentRepository paymentRepository;
    private final OrderMapper orderMapper;
//    private final ProductFeignClient productFeignClient;



    @Override
    public Mono<OrderResponse> addOrder(OrderRequest orderRequest) {
        return orderRepository.save(orderMapper.orderRequestToOrder(orderRequest)).map(orderMapper::orderToOrderResponse);
    }

    @Override
    public Flux<OrderResponse> getAllPage(Pageable pageable) {
        return orderRepository.findAllBy(pageable).map(orderMapper::orderToOrderResponse);
    }

    @Override
    public Flux<OrderResponse> getAllOrder() {

        return orderRepository.findAll().map(orderMapper::orderToOrderResponse);
    }
//
    @Override
    public Mono<OrderResponse> update(OrderUpdate orderUpdate) {
        return orderRepository.save(orderMapper.orderUpdateToOrder(orderUpdate)).map(orderMapper::orderToOrderResponse);
    }

    @Override
    public Mono<OrderResponse> getOrderDetail(Long id) {
        return orderRepository.findById(id).map(orderMapper::orderToOrderResponse);
    }
//
    @Override
    public Mono<Void> deleteById(Long id) {
        return orderRepository.findById(id).subscribeOn(Schedulers.boundedElastic())
                        .switchIfEmpty(Mono.error(new ObjectNotFoundException("not order")))
                                .then(orderRepository.deleteById(id)).then();
//        orderRepository.deleteById(id);
    }
//
//    @Override
//    @Transactional
//    public Mono<Void> addProductsByIdForOrder(Long orderId, List<Long> productIds) {
//
//        Order order = orderRepository.findById(orderId)
//                .orElseThrow(() -> new ObjectNotFoundException("Order with id " + orderId + " not found"));
//        List<Long> productIdsByOrder = order.getProducts().stream().map(Product::getId).collect(Collectors.toList());
//        productIds.removeAll(productIdsByOrder);
////        List<Product> products = productFeignClient.getAllProductsByIds(productIds);
//        List<Product> products = productFeignClient.getAllProductsByIds(productIds);
//        System.out.println(products.size());
//        order.getProducts().addAll(products);
//        orderRepository.save(order);
//    }


}
