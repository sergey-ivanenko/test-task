package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.BalanceChangeDto;
import by.itechart.testtask.model.BalanceChange;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface BalanceChangeMapper {
    @Mappings({
            @Mapping(source = "cafe.id", target = "cafeId"),
            @Mapping(source = "date", target = "date", dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    BalanceChangeDto toDto(BalanceChange balanceChange);

    @InheritInverseConfiguration
    BalanceChange toEntity(BalanceChangeDto balanceChangeDto);
}
