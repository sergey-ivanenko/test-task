package by.itechart.testtask.service;

import by.itechart.testtask.dto.ProductPriceDto;

import java.util.List;

public interface ProductPriceService {
    ProductPriceDto add(ProductPriceDto productPriceDto);

    ProductPriceDto findById(Long id);

    List<ProductPriceDto> findAll();

    ProductPriceDto update(ProductPriceDto productPriceDto);

    ProductPriceDto deleteById(Long id);
}
