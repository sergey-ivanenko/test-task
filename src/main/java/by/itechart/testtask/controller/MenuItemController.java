package by.itechart.testtask.controller;

import by.itechart.testtask.dto.CafeDto;
import by.itechart.testtask.dto.MenuItemDto;
import by.itechart.testtask.service.CafeService;
import by.itechart.testtask.service.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/menu-item")
public class MenuItemController {
    private static Logger logger = LoggerFactory.getLogger(MenuItemController.class);

    private final MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public List<MenuItemDto> findAll() {
        logger.info("invoked method findAll.");
        return menuItemService.findAll();
    }

    @GetMapping("/{id}")
    public MenuItemDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return menuItemService.findById(id);
    }

    @PostMapping("/add")
    public MenuItemDto add(@RequestBody @Valid MenuItemDto menuItemDto) {
        return menuItemService.add(menuItemDto);
    }

    @PutMapping("/update")
    public MenuItemDto update(@RequestBody @Valid MenuItemDto menuItemDto) {
        return menuItemService.update(menuItemDto);
    }

    @DeleteMapping("/{id}")
    public MenuItemDto deleteById(@PathVariable Long id) {
        return menuItemService.deleteById(id);
    }
}
