package by.itechart.testtask.service;

import by.itechart.testtask.dto.MenuItemDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.MenuItemMapper;
import by.itechart.testtask.model.MenuItem;
import by.itechart.testtask.repository.MenuItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MenuItemServiceImpl implements MenuItemService {
    private static Logger logger = LoggerFactory.getLogger(MenuItemServiceImpl.class);

    private final MenuItemRepository menuItemRepository;
    private final MenuItemMapper menuItemMapper;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository, MenuItemMapper menuItemMapper) {
        this.menuItemRepository = menuItemRepository;
        this.menuItemMapper = menuItemMapper;
    }

    @Override
    public MenuItemDto add(MenuItemDto menuItemDto) {
        logger.info(String.format("%s added.", menuItemDto));
        return menuItemMapper.toDto(menuItemRepository.save(menuItemMapper.toEntity(menuItemDto)));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public MenuItemDto findById(Long id) {
        return menuItemMapper.toDto(menuItemRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<MenuItemDto> findAll() {
        List<MenuItem> menuItems = (List<MenuItem>) menuItemRepository.findAll();
        return menuItems.stream().map(menuItemMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public MenuItemDto update(MenuItemDto menuItemDto) {
        logger.info(String.format("MenuItem %s updated.", menuItemDto.getId()));
        return menuItemMapper.toDto(menuItemRepository.save(menuItemMapper.toEntity(menuItemDto)));
    }

    @Override
    public MenuItemDto deleteById(Long id) {
        MenuItemDto deletedMenuItem = menuItemMapper.toDto(menuItemRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        menuItemRepository.deleteById(id);
        logger.info(String.format("MenuItem %s deleted.", deletedMenuItem.getName()));

        return deletedMenuItem;
    }
}
