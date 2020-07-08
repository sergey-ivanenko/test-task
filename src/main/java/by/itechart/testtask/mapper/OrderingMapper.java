package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.OrderingDto;
import by.itechart.testtask.model.Ordering;
import org.mapstruct.*;

@Mapper/*(uses = MenuItemMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)*/
public interface OrderingMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(target = "date", dateFormat = "dd-MM-yyyy"/* HH:mm:ss"*/)
    OrderingDto toDto(Ordering ordering);

    @InheritInverseConfiguration
    Ordering toEntity(OrderingDto orderingDto);
}
