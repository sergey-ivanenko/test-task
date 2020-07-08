package by.itechart.testtask.controller;

import by.itechart.testtask.dto.IngredientDto;
import by.itechart.testtask.service.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private static Logger logger = LoggerFactory.getLogger(IngredientController.class);

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<IngredientDto> findAll() {
        logger.info("invoked method findAll.");
        return ingredientService.findAll();
    }

    @GetMapping("/{id}")
    public IngredientDto findById(@PathVariable Long id) {
        logger.info("invoked method findById.");
        return ingredientService.findById(id);
    }

    @PostMapping("/add")
    public IngredientDto add(@RequestBody @Valid IngredientDto ingredientDto) {
        return ingredientService.add(ingredientDto);
    }

    @PutMapping("/update")
    public IngredientDto update(@RequestBody @Valid IngredientDto ingredientDto) {
        return ingredientService.update(ingredientDto);
    }

    @DeleteMapping("/{id}")
    public IngredientDto deleteById(@PathVariable Long id) {
        return ingredientService.deleteById(id);
    }
}
