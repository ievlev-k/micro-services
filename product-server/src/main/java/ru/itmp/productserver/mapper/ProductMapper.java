package ru.itmp.productserver.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.itmp.productserver.dto.request.ProductRequest;
import ru.itmp.productserver.dto.responce.ProductResponse;
import ru.itmp.productserver.dto.update.ProductUpdate;
import ru.itmp.productserver.model.Product;


import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final ModelMapper modelMapper;

    @PostConstruct
    public void setupMapper() {
        modelMapper.createTypeMap(Product.class, ProductResponse.class)
                .addMappings(m -> m.skip(ProductResponse::setUser))
                .addMappings(m -> m.skip(ProductResponse::setCategory))
                .setPostConverter(toProductResponseConverter());
    }

    public Converter<Product, ProductResponse> toProductResponseConverter() {
        return context -> {
            Product source = context.getSource();
            ProductResponse destination = context.getDestination();
            destination.setUser(source.getUser().getId());
            destination.setCategory(source.getCategory().getId());
            return context.getDestination();
        };
    }

    public Product productRequestToProduct(ProductRequest request) {
        return modelMapper.map(request, Product.class);
    }

    public ProductResponse productToProductResponse(Product product) {
        return modelMapper.map(product, ProductResponse.class);
    }

    public Page<ProductResponse> productToProductResponsePage(Page<Product> productPage) {
        return productPage.map(this::productToProductResponse);
    }

    public List<ProductResponse> productToProductResponseList(List<Product> productList) {
        return productList
                .stream()
                .map(this::productToProductResponse)
                .collect(Collectors.toList());
    }

    public Product productUpdateToProduct(ProductUpdate productUpdate) {
        return modelMapper.map(productUpdate, Product.class);
    }
}
