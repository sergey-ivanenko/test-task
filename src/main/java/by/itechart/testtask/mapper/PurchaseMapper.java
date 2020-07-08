package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.PurchaseDto;
import by.itechart.testtask.model.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PurchaseMapper {
    @Mapping(source = "product.id", target = "productId")
    PurchaseDto toDto(Purchase purchase);

    @InheritInverseConfiguration
    Purchase toEntity(PurchaseDto purchaseDto);
}
