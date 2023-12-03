package org.FeastTogether.dto;

import org.FeastTogether.entity.Ingredient;
import org.FeastTogether.entity.SingleUser;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public record NewMenuItemDto(
        @NotBlank(message = "Title must be added.")
        String title,
        @Size(min = 10, message = "Description must be longer!")
        String description,
        Set<Ingredient> ingredients,
        Set<SingleUser> singleUsers
) {
}
