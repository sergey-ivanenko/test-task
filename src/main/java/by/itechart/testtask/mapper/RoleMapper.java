package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.RoleDto;
import by.itechart.testtask.model.Role;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {
    RoleDto toDto(Role role);

    Role toEntity(RoleDto roleDto);
}
