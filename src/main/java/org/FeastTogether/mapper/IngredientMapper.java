package org.FeastTogether.mapper;

import org.FeastTogether.dto.IngredientDto;
import org.FeastTogether.dto.NewIngredientDto;
import org.FeastTogether.entity.Ingredient;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class IngredientMapper {
    public Ingredient mapDtoToIngredient(NewIngredientDto newIngredientDto) {
        return new Ingredient(
                newIngredientDto.name()
        );
    }
    public IngredientDto mapIngredientToDto(Ingredient ingredient) {
        if (ingredient.getSingleUsers() == null) {
            ingredient.setSingleUsers(new HashSet<>());
        }
        if (ingredient.getMenuItems() == null) {
            ingredient.setMenuItems(new HashSet<>());
        }
        return new IngredientDto(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getSingleUsers(),
                ingredient.getMenuItems()
        );
    }

}
