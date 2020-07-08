package by.itechart.testtask.controller;

import by.itechart.testtask.dto.AppealDto;
import by.itechart.testtask.service.AppealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/appeal")
public class AppealController {
    private static Logger logger = LoggerFactory.getLogger(AppealController.class);

    private final AppealService appealService;

    @Autowired
    public AppealController(AppealService appealService) {
        this.appealService = appealService;
    }

    @GetMapping
    public List<AppealDto> findAll() {
        logger.info("invoked method findAll.");
        return appealService.findAll();
    }

    @GetMapping("/{id}")
    public AppealDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return appealService.findById(id);
    }

    @PostMapping("/add")
    public AppealDto add(@RequestBody @Valid AppealDto appealDto) {
        return appealService.add(appealDto);
    }

    @PutMapping("/update")
    public AppealDto update(@RequestBody @Valid AppealDto appealDto) {
        return appealService.update(appealDto);
    }

    @DeleteMapping("/{id}")
    public AppealDto deleteById(@PathVariable Long id) {
        return appealService.deleteById(id);
    }
}
