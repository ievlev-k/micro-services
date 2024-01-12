package ru.itmp.productserver.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itmp.productserver.dto.request.CategoryRequest;
import ru.itmp.productserver.dto.responce.CategoryResponse;
import ru.itmp.productserver.dto.update.CategoryUpdate;

import java.util.List;

public interface CategoryService {
    Mono<CategoryResponse> save(CategoryRequest categoryRequest);

    Mono<Page<CategoryResponse>> getAllPage(Pageable pageable);

    Flux<CategoryResponse> getAllList();

//    void deleteById(Long id);

    Mono<CategoryResponse> update(CategoryUpdate categoryUpdate);

    Mono<CategoryResponse> getCategoryById(Long id);
}
