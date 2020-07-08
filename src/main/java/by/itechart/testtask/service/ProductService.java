package by.itechart.testtask.service;

import by.itechart.testtask.dto.CafeDto;
import by.itechart.testtask.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto add(ProductDto productDto);

    ProductDto findById(Long id);

    List<ProductDto> findAll();

    ProductDto update(ProductDto productDto);

    ProductDto deleteById(Long id);
}
