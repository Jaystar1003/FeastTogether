package org.FeastTogether.dto;

import org.FeastTogether.entity.MenuItem;
import org.FeastTogether.entity.SingleUser;

import java.util.Set;
import java.util.UUID;

public record IngredientDto(
        UUID id,
        String name,
        Set<SingleUser> singleUsers,
        Set<MenuItem> menuItems
) {
}
