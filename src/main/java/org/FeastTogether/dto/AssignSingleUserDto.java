package org.FeastTogether.dto;

import java.util.UUID;

public record AssignSingleUserDto(
        UUID ingredientId,
        UUID SingleUserId,
        String message
) {
}
