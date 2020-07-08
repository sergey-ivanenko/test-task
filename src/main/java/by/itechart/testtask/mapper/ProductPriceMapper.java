package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.ProductPriceDto;
import by.itechart.testtask.model.ProductPrice;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ProductPriceMapper {
    @Mappings({
            @Mapping(source = "product.id", target = "productId"),
            @Mapping(target = "dateStart", dateFormat = "dd-MM-yyyy")/* HH:mm:ss"*/
    })
    ProductPriceDto toDto(ProductPrice productPrice);

    @InheritInverseConfiguration
    ProductPrice toEntity(ProductPriceDto productPriceDto);
}
