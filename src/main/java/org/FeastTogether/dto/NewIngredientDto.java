package org.FeastTogether.dto;

import javax.validation.constraints.NotBlank;

public record NewIngredientDto(
        @NotBlank(message = "Name must be added.")
        String name
) {
}
