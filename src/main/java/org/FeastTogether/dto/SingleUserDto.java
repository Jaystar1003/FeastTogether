package org.FeastTogether.dto;

import org.FeastTogether.entity.Ingredient;
import org.FeastTogether.entity.MenuItem;

import java.util.List;
import java.util.UUID;

public record SingleUserDto(
        UUID id,
        String firstName,
        String lastName,
        String userName,
        String email,
        List<Ingredient> listOfIngredients,
        List<MenuItem> listOfMenuItems
) {
}
