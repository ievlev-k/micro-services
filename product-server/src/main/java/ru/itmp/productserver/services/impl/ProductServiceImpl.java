package ru.itmp.productserver.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmp.productserver.dto.request.ProductRequest;
import ru.itmp.productserver.dto.responce.ProductResponse;
import ru.itmp.productserver.dto.update.ProductUpdate;
import ru.itmp.productserver.exeptions.ObjectNotFoundException;
import ru.itmp.productserver.mapper.ProductMapper;
import ru.itmp.productserver.model.Product;
import ru.itmp.productserver.model.Attachment;
import ru.itmp.productserver.repository.AttachmentRepository;
import ru.itmp.productserver.repository.CategoryRepository;
import ru.itmp.productserver.repository.ProductRepository;
import ru.itmp.productserver.services.ProductService;


import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final AttachmentRepository attachmentRepository;
    private final CategoryRepository categoryRepository;


    private final ProductMapper productMapper;

    @Override
    public ProductResponse save(ProductRequest productRequest) {
        categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new ObjectNotFoundException("Category does not exist"));

        Product product = productMapper.productRequestToProduct(productRequest);
        return productMapper.productToProductResponse(productRepository.save(product));
    }

    @Override
    public Page<ProductResponse> getPageProduct(Pageable pageable) {
        return productMapper.productToProductResponsePage(productRepository.findAll(pageable));
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productMapper.productToProductResponseList(productRepository.findAll());
    }

    @Override
    public ProductResponse update(ProductUpdate productUpdate) {
        Product product = productMapper.productUpdateToProduct(productUpdate);
        return productMapper.productToProductResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse findById(Long id) {
        return productMapper.productToProductResponse(productRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Product with id " + id + " not found"))
        );
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllById(List<Long> ids){
        return productRepository.findAllById(ids);
    }


    @Override
    @Transactional
    public void addAttachmentsByIdForProduct(Long productId, List<Long> attachmentsId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ObjectNotFoundException("Product with id " + productId + " not found"));
        List<Long> attachmentsIdByProduct = product.getAttachments().stream().map(Attachment::getId).collect(Collectors.toList());
        attachmentsId.removeAll(attachmentsIdByProduct);
        List<Attachment> attachments = attachmentRepository.findAllById(attachmentsId);
        product.getAttachments().addAll(attachments);
        productRepository.save(product);
    }
}
