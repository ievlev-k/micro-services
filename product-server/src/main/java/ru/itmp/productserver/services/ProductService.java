package ru.itmp.productserver.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.itmp.productserver.dto.request.ProductRequest;
import ru.itmp.productserver.dto.responce.ProductResponse;
import ru.itmp.productserver.dto.update.ProductUpdate;
import ru.itmp.productserver.model.Product;


import java.util.List;

public interface ProductService {

    ProductResponse save(ProductRequest productRequest);

    Page<ProductResponse> getPageProduct(Pageable pageable);

    List<ProductResponse> getAllProducts();

    ProductResponse update(ProductUpdate productUpdate);

    List<Product> findAllById(List<Long> ids);

    ProductResponse findById(Long id);

    void deleteById(Long id);

    void addAttachmentsByIdForProduct(Long productId, List<Long> attachmentsId);
}
