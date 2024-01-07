package ru.itmp.productserver.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ru.itmp.productserver.dto.request.CategoryRequest;
import ru.itmp.productserver.dto.responce.CategoryResponse;
import ru.itmp.productserver.dto.update.CategoryUpdate;
import ru.itmp.productserver.exeptions.ObjectNotFoundException;
import ru.itmp.productserver.mapper.CategoryMapper;
import ru.itmp.productserver.model.Category;
import ru.itmp.productserver.repository.CategoryRepository;
import ru.itmp.productserver.services.CategoryService;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse save(CategoryRequest categoryRequest) {
        Category category = categoryMapper.categoryRequestToCategory(categoryRequest);
        return categoryMapper.categoryToCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public Page<CategoryResponse> getAllPage(Pageable pageable) {
        return categoryMapper.categoryToCategoryResponsePage(categoryRepository.findAll(pageable));
    }

    @Override
    public List<CategoryResponse> getAllList() {
        return categoryMapper.categoryToCategoryResponseList(categoryRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryResponse update(CategoryUpdate categoryUpdate) {
        Category category = categoryMapper.categoryUpdateToCategory(categoryUpdate);
        return categoryMapper.categoryToCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        return categoryMapper.categoryToCategoryResponse(categoryRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Category with id " + id + " not found"))
        );
    }
}
