package org.FeastTogether.mapper;

import org.FeastTogether.dto.MenuItemDto;
import org.FeastTogether.dto.NewMenuItemDto;
import org.FeastTogether.entity.MenuItem;
import org.springframework.stereotype.Component;

@Component
public class MenuItemMapper {
    public MenuItem mapDtoToMenuItem(NewMenuItemDto newMenuItemDto) {
        return new MenuItem(
                newMenuItemDto.title(),
                newMenuItemDto.description()
        );
    }
    public MenuItemDto mapMenuItemToDto(MenuItem menuItem) {
        return new MenuItemDto(
                menuItem.getId(),
                menuItem.getTitle(),
                menuItem.getDescription(),
                menuItem.getMenu_ingredients().stream().toList(),
                menuItem.getSingleUsers().stream().toList()
        );
    }
}
