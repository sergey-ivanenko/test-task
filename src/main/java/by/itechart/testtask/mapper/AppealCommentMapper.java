package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.AppealCommentDto;
import by.itechart.testtask.model.AppealComment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface AppealCommentMapper {

    @Mappings({
            @Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "appeal.id", target = "appealNumber")
    })
    AppealCommentDto toDto(AppealComment appeal);

    /*@Mappings({
            @Mapping(source = "userId", target = "user.id"),
            @Mapping(source = "appealNumber", target = "appeal.id")
    })*/
    @InheritInverseConfiguration
    AppealComment toEntity(AppealCommentDto appealDto);
}
