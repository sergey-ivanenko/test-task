package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.StorageDto;
import by.itechart.testtask.model.Storage;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface StorageMapper {
    @Mappings({
            @Mapping(source = "cafe.id", target = "cafeId"),
            @Mapping(source = "product.id", target = "productId"),
    })
    StorageDto toDto(Storage storage);

    @InheritInverseConfiguration
    Storage toEntity(StorageDto storageDto);
}
