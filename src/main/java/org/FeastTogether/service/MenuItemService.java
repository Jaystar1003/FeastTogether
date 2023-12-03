package org.FeastTogether.service;

import org.FeastTogether.dto.*;
import org.FeastTogether.entity.Ingredient;
import org.FeastTogether.entity.MenuItem;
import org.FeastTogether.entity.SingleUser;
import org.FeastTogether.mapper.MenuItemMapper;
import org.FeastTogether.repository.MenuItemRepository;
import org.FeastTogether.repository.SingleUserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;
    private final MenuItemMapper menuItemMapper;

    public MenuItemService(MenuItemRepository menuItemRepository, MenuItemMapper menuItemMapper) {
        this.menuItemRepository = menuItemRepository;
        this.menuItemMapper = menuItemMapper;
    }
    public List<MenuItemDto> getAllMenuItems() {
        return this.menuItemRepository.findAllBy()
                .stream().map(menuItemMapper::mapMenuItemToDto)
                .toList();
    }
    public MenuItemDto addMenuItem(NewMenuItemDto newMenuItemDto) {
        MenuItem menuItem = menuItemMapper.mapDtoToMenuItem(newMenuItemDto);
        MenuItem savedMenuItem = menuItemRepository.save(menuItem);
        return menuItemMapper.mapMenuItemToDto(savedMenuItem);
    }
    public MenuItemDto getMenuItemById(UUID id) {
        return menuItemRepository.findOneById(id)
                .map(menuItemMapper::mapMenuItemToDto)
                .orElseThrow();
    }
    public List<MenuItemDto> getAllMenuItems(Pageable pageable) {
        return menuItemRepository.findAllBy(pageable).stream()
                .map(menuItemMapper::mapMenuItemToDto).toList();
    }

}
