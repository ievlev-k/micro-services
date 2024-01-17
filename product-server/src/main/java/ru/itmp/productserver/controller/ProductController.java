package ru.itmp.productserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private final AuthFeignClient authFeign;


    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest, @RequestHeader("Authorization") String token) {
        if (!authFeign.checkAdminPermission(token)) {
            System.out.println("checkAdminPermission: false");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return new ResponseEntity<>(productService.save(productRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getPageProduct(@PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(productService.getPageProduct(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PutMapping
    public ProductResponse updateProduct(@RequestBody ProductUpdate productUpdate, @RequestHeader("Authorization") String token) {
        if (!authFeign.checkAdminPermission(token)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return new ResponseEntity<>(productService.update(productUpdate), HttpStatus.OK);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Product>> getAllProductsByIds(@RequestBody List<Long> ids){
        return ResponseEntity.ok(productService.findAllById(ids));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        if (!authFeign.checkAdminPermission(token)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        productService.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @PostMapping("/attachment")
    public ResponseEntity<String> addAttachmentsForProduct(@Valid @RequestBody ProductAttachmentsDto request, @RequestHeader("Authorization") String token) {
        if (!authFeign.checkAdminPermission(token)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        productService.addAttachmentsByIdForProduct(request.getProductId(), request.getAttachmentIds());
        return ResponseEntity.ok("Attachments added successfully");
    }
}
