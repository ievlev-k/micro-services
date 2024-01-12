package ru.itmp.productserver.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itmp.productserver.dto.request.CategoryRequest;
import ru.itmp.productserver.dto.responce.CategoryResponse;
import ru.itmp.productserver.dto.update.CategoryUpdate;
import ru.itmp.productserver.exeptions.ObjectNotFoundException;
import ru.itmp.productserver.mapper.CategoryMapper;
import ru.itmp.productserver.model.Category;
import ru.itmp.productserver.repository.CategoryRepository;
import ru.itmp.productserver.services.CategoryService;
import org.springframework.data.domain.PageImpl;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Mono<CategoryResponse> save(CategoryRequest categoryRequest) {


        Category category = categoryMapper.categoryRequestToCategory(categoryRequest);
        return categoryRepository.save(category).map(categoryMapper::categoryToCategoryResponse);
    }

    @Override
    public Mono<Page<CategoryResponse>> getAllPage(Pageable pageable) {

        return createPage(categoryRepository.findAll().map(categoryMapper::categoryToCategoryResponse), pageable);
    }

    private Mono<Page<CategoryResponse>> createPage(Flux<CategoryResponse> categoryFlux, Pageable pageable) {
        return categoryFlux
                .collectList()
                .zipWith(categoryRepository.count())
                .map(t -> new PageImpl<>(t.getT1(), pageable, t.getT2()));
    }

    @Override
    public Flux<CategoryResponse> getAllList() {
        return categoryRepository.findAll().map(categoryMapper::categoryToCategoryResponse);
//        return categoryMapper.categoryToCategoryResponseList(categoryRepository.findAll().);
    }

//    @Override
//    public void deleteById(Long id) {
//        categoryRepository.deleteById(id);
//    }

    @Override
    public Mono<CategoryResponse> update(CategoryUpdate categoryUpdate) {
        Category category = categoryMapper.categoryUpdateToCategory(categoryUpdate);
        return categoryRepository.save(category).map(categoryMapper::categoryToCategoryResponse);

    }

    @Override
    public Mono<CategoryResponse> getCategoryById(Long id) {
        return categoryRepository.findById(id).map(categoryMapper::categoryToCategoryResponse );

    }
}
