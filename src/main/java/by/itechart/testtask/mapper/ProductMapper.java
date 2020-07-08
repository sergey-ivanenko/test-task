package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.ProductDto;
import by.itechart.testtask.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);
}
