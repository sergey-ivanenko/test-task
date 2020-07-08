package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.PurchaseStatusDto;
import by.itechart.testtask.model.PurchaseStatus;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface PurchaseStatusMapper {
    @Mappings({
            @Mapping(source = "purchase.id", target = "purchaseId"),
            @Mapping(source = "user.id", target = "userId")
    })
    PurchaseStatusDto toDto(PurchaseStatus purchaseStatus);

    @InheritInverseConfiguration
    PurchaseStatus toEntity(PurchaseStatusDto purchaseStatusDto);
}
