package ru.itmp.productserver.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.itmp.productserver.dto.request.CategoryRequest;
import ru.itmp.productserver.dto.responce.CategoryResponse;
import ru.itmp.productserver.dto.update.CategoryUpdate;
import ru.itmp.productserver.model.Category;


import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryMapper {
    private final ModelMapper modelMapper;

    public Category categoryRequestToCategory(CategoryRequest request) {
        return modelMapper.map(request, Category.class);
    }

    public CategoryResponse categoryToCategoryResponse(Category category) {
        return modelMapper.map(category, CategoryResponse.class);
    }

    public Page<CategoryResponse> categoryToCategoryResponsePage(Page<Category> categoryPage) {
        return categoryPage.map(this::categoryToCategoryResponse);
    }

    public List<CategoryResponse> categoryToCategoryResponseList(List<Category> categoryList) {
        return categoryList
                .stream()
                .map(this::categoryToCategoryResponse)
                .collect(Collectors.toList());
    }

    public Category categoryUpdateToCategory(CategoryUpdate categoryUpdate) {
        return modelMapper.map(categoryUpdate, Category.class);
    }
}
