package org.FeastTogether.mapper;

import org.FeastTogether.dto.IngredientDto;
import org.FeastTogether.entity.Ingredient;
import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.instancio.Select;
import org.junit.jupiter.api.Test;

public class IngredientMapperTest {
    private IngredientMapper ingredientMapper = new IngredientMapper();


    @Test
    void shouldMapIngredientToTaskDto() {
        Ingredient ingredient = Instancio.create(Ingredient.class);
        IngredientDto ingredientDto = ingredientMapper.mapIngredientToDto(ingredient);

        Assertions.assertThat(ingredientDto.id()).isEqualTo(ingredient.getId());
    }
}
