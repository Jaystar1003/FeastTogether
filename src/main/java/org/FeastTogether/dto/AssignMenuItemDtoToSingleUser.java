package org.FeastTogether.dto;

import java.util.UUID;

public record AssignMenuItemDtoToSingleUser(
        UUID menuItemId,
        UUID SingleUserId,
        String message
) {
}
