package ru.itmo.orderserver.mapper;

//import lombok.RequiredArgsConstructor;
//import org.modelmapper.Converter;
//import org.modelmapper.ModelMapper;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Component;
//import ru.itmo.orderserver.dto.request.OrderRequest;
//import ru.itmo.orderserver.dto.response.OrderResponse;
//import ru.itmo.orderserver.dto.update.OrderUpdate;
//import ru.itmo.orderserver.model.Order;
//
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//@RequiredArgsConstructor
//public class OrderMapper {
//    private final ModelMapper modelMapper;
//
//    @PostConstruct
//    public void setupMapper() {
//        System.out.println("setup mapper");
//        modelMapper.createTypeMap(Order.class, OrderResponse.class)
//                .addMappings(m -> m.skip(OrderResponse::setUser))
//                .addMappings(m -> m.skip(OrderResponse::setPayment))
//                .setPostConverter(toOrderResponseConverter());
//    }
//
//    public Converter<Order, OrderResponse> toOrderResponseConverter() {
//        return context -> {
//            Order source = context.getSource();
//            OrderResponse destination = context.getDestination();
//            destination.setPayment(source.getPayment().getId());
//            destination.setUser(source.getUser().getId());
//            return context.getDestination();
//        };
//    }
//
//    public Order orderRequestToOrder(OrderRequest request) {
//        return modelMapper.map(request, Order.class);
//    }
//
//    public OrderResponse orderToOrderResponse(Order order) {
//        return modelMapper.map(order, OrderResponse.class);
//    }
//
//    public Page<OrderResponse> orderToOrderResponsePage(Page<Order> orderPage){
//        return orderPage.map(this::orderToOrderResponse);
//    }
//
//    public List<OrderResponse> orderToOrderResponseList(List<Order>  orderList) {
//        return orderList
//                .stream()
//                .map(this::orderToOrderResponse)
//                .collect(Collectors.toList());
//    }
//
//    public Order orderUpdateToOrder (OrderUpdate orderUpdate) {
//        return modelMapper.map(orderUpdate, Order.class);
//    }
//}
