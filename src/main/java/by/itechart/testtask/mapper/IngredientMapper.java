package by.itechart.testtask.mapper;

import by.itechart.testtask.dto.IngredientDto;
import by.itechart.testtask.model.Ingredient;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface IngredientMapper {
    @Mappings({
            @Mapping(source = "menuItem.id", target = "menuItemId"),
            @Mapping(source = "product.id", target = "productId")
    })
    IngredientDto toDto(Ingredient ingredient);

    @InheritInverseConfiguration
    Ingredient toEntity(IngredientDto ingredientDto);
}
