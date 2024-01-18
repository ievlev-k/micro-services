package ru.itmp.productserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import ru.itmp.productserver.dto.request.CategoryRequest;
import ru.itmp.productserver.dto.responce.CategoryResponse;
import ru.itmp.productserver.dto.update.CategoryUpdate;
import ru.itmp.productserver.services.CategoryService;
import ru.itmp.productserver.feign.AuthFeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final AuthFeignClient authFeign;
	private final CircuitBreaker circuitBreaker;

    @PostMapping
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody CategoryRequest categoryRequest, @RequestHeader("Authorization") String token) {
        boolean isAdmin = false;
        try {
            isAdmin = circuitBreaker.decorateSupplier(() -> authFeign.checkAdminPermission(token)).get();
        } catch(Exception e) {
            System.out.println("Error:" + e);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        if (!isAdmin) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return new ResponseEntity<>(categoryService.save(categoryRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<CategoryResponse>> getListCategory(@PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(categoryService.getAllPage(pageable));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponse>> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllList());
    }

    @PutMapping
    public ResponseEntity<CategoryResponse> updateCategory(@RequestBody CategoryUpdate categoryUpdate, @RequestHeader("Authorization") String token) {
        boolean isAdmin = false;
        try {
            isAdmin = circuitBreaker.decorateSupplier(() -> authFeign.checkAdminPermission(token)).get();
        } catch(Exception e) {
            System.out.println("Error:" + e);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        if (!isAdmin) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return new ResponseEntity<>(categoryService.update(categoryUpdate), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryDetail(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        boolean isAdmin = false;
        try {
            isAdmin = circuitBreaker.decorateSupplier(() -> authFeign.checkAdminPermission(token)).get();
        } catch(Exception e) {
            System.out.println("Error:" + e);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        if (!isAdmin) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        categoryService.deleteById(id);
        return ResponseEntity.ok("Category deleted successfully");

    }

}