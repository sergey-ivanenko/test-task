package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.AppealDto;
import by.itechart.testtask.model.Appeal;
import org.mapstruct.*;

@Mapper(uses = AppealCommentMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AppealMapper {

    @Mappings({
            @Mapping(source = "cafe.id", target = "cafeId"),
            @Mapping(source = "ordering.id", target = "orderingNumber")
    })
    AppealDto toDto(Appeal appeal);

    @InheritInverseConfiguration
    Appeal toEntity(AppealDto appealDto);
}
