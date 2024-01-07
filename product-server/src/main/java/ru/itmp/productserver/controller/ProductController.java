package ru.itmp.productserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itmp.productserver.dto.request.ProductRequest;
import ru.itmp.productserver.dto.responce.ProductResponse;
import ru.itmp.productserver.dto.update.ProductUpdate;
import ru.itmp.productserver.model.ProductAttachmentsDto;
import ru.itmp.productserver.services.ProductService;
import ru.itmp.productserver.model.Product;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/product")
public class ProductController {

    private final ProductService productService;


    @PostMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ProductResponse addProduct(@Valid @RequestBody ProductRequest productRequest) {
        return productService.save(productRequest);
    }

    @GetMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public Page<ProductResponse> getPageProduct(@PageableDefault(size = 5) Pageable pageable) {
        return productService.getPageProduct(pageable);
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/all")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public List<ProductResponse> getAllProduct() {
        return productService.getAllProducts();
    }

    @PutMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ProductResponse updateProduct(@Valid @RequestBody ProductUpdate productUpdate) {
        return productService.update(productUpdate);
    }

    @PostMapping("/find-all")
//    @ResponseBody
    public String getAllProductsByIds(@RequestBody List<Long> ids){
        return String.valueOf(ids.size());
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PostMapping("/add-attachment")
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void addAttachmentsForProduct(@Valid @RequestBody ProductAttachmentsDto request) {
        productService.addAttachmentsByIdForProduct(request.getProductId(), request.getAttachmentIds());
    }
}
