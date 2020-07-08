package by.itechart.testtask.service;

import by.itechart.testtask.dto.IngredientDto;

import java.util.List;

public interface IngredientService {
    IngredientDto add(IngredientDto ingredientDto);

    IngredientDto findById(Long id);

    List<IngredientDto> findAll();

    IngredientDto update(IngredientDto ingredientDto);

    IngredientDto deleteById(Long id);
}
