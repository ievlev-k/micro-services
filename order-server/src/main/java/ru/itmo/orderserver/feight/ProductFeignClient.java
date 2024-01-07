package ru.itmo.orderserver.feight;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.itmo.orderserver.model.Product;

import java.util.List;

@FeignClient("PRODUCT-SERVER")
public interface ProductFeignClient {

    @PostMapping("/api/v1/product/find-all")
    public String getAllProductsByIds(@RequestBody List<Long> ids);
}

