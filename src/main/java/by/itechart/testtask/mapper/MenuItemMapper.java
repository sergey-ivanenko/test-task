package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.MenuItemDto;
import by.itechart.testtask.model.MenuItem;
import org.mapstruct.Mapper;

@Mapper
public interface MenuItemMapper {
    MenuItemDto toDto(MenuItem menuItem);

    MenuItem toEntity(MenuItemDto menuItemDto);
}
