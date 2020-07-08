package by.itechart.testtask.service;

import by.itechart.testtask.dto.MenuItemDto;

import java.util.List;

public interface MenuItemService {
    MenuItemDto add(MenuItemDto menuItemDto);

    MenuItemDto findById(Long id);

    List<MenuItemDto> findAll();

    MenuItemDto update(MenuItemDto menuItemDto);

    MenuItemDto deleteById(Long id);
}
