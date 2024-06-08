package com.shakov.goodbuyproject.service;

import com.shakov.goodbuyproject.database.repository.ProductRepository;
import com.shakov.goodbuyproject.dto.*;
import com.shakov.goodbuyproject.mapper.ProductFromCreateDtoMapper;
import com.shakov.goodbuyproject.mapper.ProductFromEditDtoMapper;
import com.shakov.goodbuyproject.mapper.ProductReadDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductReadDtoMapper productReadDtoMapper;
    private final ProductFromEditDtoMapper productFromEditDtoMapper;
    private final ProductFromCreateDtoMapper productFromCreateDtoMapper;

    public List<ProductReadDto> findAllProductsByUsername(String username) {
        return productRepository.findAllProductsByUsername(username).stream()
                .map(productReadDtoMapper::map).toList();
    }


    public Optional<ProductReadDto> findById(Long id) {
        return productRepository.findById(id)
                .map(productReadDtoMapper::map);
    }

    public List<ProductReadDto> findAll() {
        return productRepository.findAll().stream()
                .map(productReadDtoMapper::map).toList();
    }

    @Transactional
    public Optional<ProductReadDto> update(Long id, ProductEditDto productEditDto) {
        return productRepository.findById(id)
                .map(product -> productFromEditDtoMapper.map(productEditDto, product))
                .map(productRepository::saveAndFlush)
                .map(productReadDtoMapper::map);
    }

    @Transactional
    public boolean delete(Long id) {

        return productRepository.findById(id)
                .map(entity -> {
                    productRepository.delete(entity);
                    productRepository.flush();
                    return true;
                })
                .orElse(false);
    }

    @Transactional
    public ProductReadDto create(ProductCreateDto productCreateDto) {
        return Optional.of(productCreateDto)
                .map(productFromCreateDtoMapper::map)
                .map(productRepository::save)
                .map(productReadDtoMapper::map)
                .orElseThrow();
    }

}