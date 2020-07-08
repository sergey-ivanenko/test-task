package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.BalanceDto;
import by.itechart.testtask.model.Balance;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface BalanceMapper {
    @Mappings({
            @Mapping(source = "cafe.id", target = "cafeId"),
            @Mapping(source = "dateStart", target = "dateStart", dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    BalanceDto toDto(Balance balance);

    @InheritInverseConfiguration
    Balance toEntity(BalanceDto balanceDto);
}
