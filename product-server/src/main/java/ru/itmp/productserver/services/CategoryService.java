package ru.itmp.productserver.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.itmp.productserver.dto.request.CategoryRequest;
import ru.itmp.productserver.dto.responce.CategoryResponse;
import ru.itmp.productserver.dto.update.CategoryUpdate;

import java.util.List;

public interface CategoryService {
    CategoryResponse save(CategoryRequest categoryRequest);

    Page<CategoryResponse> getAllPage(Pageable pageable);

    List<CategoryResponse> getAllList();

    void deleteById(Long id);

    CategoryResponse update(CategoryUpdate categoryUpdate);

    CategoryResponse getCategoryById(Long id);
}
