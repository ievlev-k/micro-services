package ru.itmo.orderserver.controller;
//
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ru.itmo.orderserver.dto.request.OrderRequest;
import ru.itmo.orderserver.dto.response.OrderResponse;
import ru.itmo.orderserver.dto.update.OrderUpdate;
import ru.itmo.orderserver.model.OrderProductDto;
import ru.itmo.orderserver.services.OrderService;


import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value="/api/v1/order")
public class OrderController {
    private final OrderService orderService;

//    @PostMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
//    public OrderResponse addOrder(@Valid @RequestBody OrderRequest orderRequest) {
//        return orderService.addOrder(orderRequest);
//    }
//
//
//    @GetMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
//    public Page<OrderResponse> getOrderPage(@PageableDefault(size = 5) Pageable pageable)  {
//        return orderService.getAllPage(pageable);
//    }

    @GetMapping("/all")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public Flux<OrderResponse> getAllOrder()  {
        return orderService.getAllOrder();
    }
//
//    @PutMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
//    public OrderResponse updateOrder(@Valid @RequestBody OrderUpdate orderUpdate){
//        return orderService.update(orderUpdate);
//    }
//
//    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
//    public OrderResponse getOrderDetail(@PathVariable Long id) {
//        return orderService.getOrderDetail(id);
//    }
//
//    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
//    public void deleteOrder(@PathVariable Long id) {
//        orderService.deleteById(id);
//    }
//
//    @PostMapping("/add-product")
////    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
//    public void addProductsForOrder(@Valid @RequestBody OrderProductDto request) {
//        orderService.addProductsByIdForOrder(request.getOrderId(), request.getProductIds());
//    }
}
