package ru.itmp.productserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itmp.productserver.dto.request.CategoryRequest;
import ru.itmp.productserver.dto.responce.CategoryResponse;
import ru.itmp.productserver.dto.update.CategoryUpdate;
import ru.itmp.productserver.services.CategoryService;


import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Mono<CategoryResponse> addCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        return categoryService.save(categoryRequest);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public Mono<Page<CategoryResponse>> getListCategory(@PageableDefault(size = 5) Pageable pageable) {
        return categoryService.getAllPage(pageable);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public Flux<CategoryResponse> getAllCategory() {
        return categoryService.getAllList();
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Mono<CategoryResponse> updateCategory(@Valid @RequestBody CategoryUpdate categoryUpdate) {
        return categoryService.update(categoryUpdate);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public Mono<CategoryResponse> getCategoryDetail(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

//    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
//    public void deleteCategory(@PathVariable Long id) {
//        categoryService.deleteById(id);
//    }

}