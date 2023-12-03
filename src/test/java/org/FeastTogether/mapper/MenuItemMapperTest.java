package org.FeastTogether.mapper;

import org.FeastTogether.dto.MenuItemDto;
import org.FeastTogether.entity.Ingredient;
import org.FeastTogether.entity.MenuItem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class MenuItemMapperTest {
    private MenuItemMapper testedMapper = new MenuItemMapper();

    @Test()
    @DisplayName("Testing if mapper correctly maps Menu Item to Dto")
    void shouldMapMenuItemEntityToDto() {
        UUID menuItemUuid = UUID.fromString("17c4cea2-8e6d-4aad-87ad-eba5738eca01");
        //given
        MenuItem menuItem =
                new MenuItem("testedTitle", "testedDescription");
        menuItem.setId(menuItemUuid);

        Ingredient ingredient1 =
                new Ingredient("Ingredient1");
        ingredient1.setId(UUID.fromString("82ecfd0e-103c-48f2-8c07-6a2c7c31c29e"));

        Ingredient ingredient2 =
                new Ingredient("Ingredient2");
        ingredient2.setId(UUID.fromString("219ab3c9-63f1-43a7-8c19-bd0ab4c9bcf9"));

        menuItem.setMenu_ingredients(Set.of(ingredient1, ingredient2));
        ingredient1.setMenuItems(Set.of(menuItem));
        ingredient2.setMenuItems(Set.of(menuItem));
        //when
        MenuItemDto actualDto = testedMapper.mapMenuItemToDto(menuItem);
        //then
        MenuItemDto expectedDto = new MenuItemDto(menuItemUuid, "testedTitle",
                "testedDescription",
                List.of(ingredient1, ingredient2));

        Assertions.assertThat(expectedDto.id()).isEqualTo(actualDto.id());
        Assertions.assertThat(expectedDto.title()).isEqualTo(actualDto.title());
        Assertions.assertThat(expectedDto.description()).isEqualTo(actualDto.description());
        Assertions.assertThat(expectedDto.listOfIngredients()
                .stream().anyMatch(element -> actualDto.listOfIngredients().contains(element))).isTrue();
    }
}
