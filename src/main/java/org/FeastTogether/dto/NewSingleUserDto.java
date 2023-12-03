package org.FeastTogether.dto;

import org.FeastTogether.entity.Ingredient;
import org.FeastTogether.entity.MenuItem;

import java.util.Set;

public record NewSingleUserDto(
        String firstName,
        String lastName,
        String userName,
        String email
) {
}
