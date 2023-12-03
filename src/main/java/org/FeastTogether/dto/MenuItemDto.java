package org.FeastTogether.dto;

import org.FeastTogether.entity.Ingredient;
import org.FeastTogether.entity.MenuItem;
import org.FeastTogether.entity.SingleUser;

import java.util.List;
import java.util.UUID;

public record MenuItemDto(
        UUID id,
        String title,
        String description,
        List<Ingredient> listOfIngredients,
        List<SingleUser> listOfSingleUsers

) {
}
