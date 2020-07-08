package by.itechart.testtask.service;

import by.itechart.testtask.dto.IngredientDto;
import by.itechart.testtask.exception.CustomException;
import by.itechart.testtask.exception.ErrorType;
import by.itechart.testtask.mapper.IngredientMapper;
import by.itechart.testtask.model.Ingredient;
import by.itechart.testtask.repository.IngredientRepository;
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
public class IngredientServiceImpl implements IngredientService {
    private static Logger logger = LoggerFactory.getLogger(IngredientServiceImpl.class);

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository, IngredientMapper ingredientMapper) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientMapper = ingredientMapper;
    }

    @Override
    public IngredientDto add(IngredientDto ingredientDto) {
        logger.info(String.format("%s added.", ingredientDto));
        return ingredientMapper.toDto(ingredientRepository.save(ingredientMapper.toEntity(ingredientDto)));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public IngredientDto findById(Long id) {
        return ingredientMapper.toDto(ingredientRepository.findById(id).orElseThrow(() -> new CustomException(
                String.format(ErrorType.ENTITY_NOT_FOUND_BY_ID.getDescription(), id))));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<IngredientDto> findAll() {
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAll();
        return ingredients.stream().map(ingredientMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public IngredientDto update(IngredientDto ingredientDto) {
        logger.info(String.format("Ingredient %d updated.", ingredientDto.getId()));
        return ingredientMapper.toDto(ingredientRepository.save(ingredientMapper.toEntity(ingredientDto)));
    }

    @Override
    public IngredientDto deleteById(Long id) {
        IngredientDto deletedIngredient = ingredientMapper.toDto(ingredientRepository.findById(id).orElseThrow(
                () -> new CustomException(String.format(ErrorType.ENTITY_NOT_DELETED.getDescription(), id))));
        ingredientRepository.deleteById(id);
        logger.info(String.format("Ingredient %d deleted.", deletedIngredient.getId()));

        return deletedIngredient;
    }
}
