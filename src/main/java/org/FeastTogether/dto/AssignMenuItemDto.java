package org.FeastTogether.dto;

import java.util.UUID;

public record AssignMenuItemDto(
        UUID ingredientId,
        UUID menuItemId,
        String message
) {
}
