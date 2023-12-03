package org.FeastTogether.controller;

import org.FeastTogether.dto.IngredientDto;
import org.FeastTogether.dto.MenuItemDto;
import org.FeastTogether.dto.NewIngredientDto;
import org.FeastTogether.dto.NewMenuItemDto;
import org.FeastTogether.service.MenuItemService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/menuItems")
public class MenuItemController {
    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }
    @GetMapping
    public List<MenuItemDto> getAllMenuItems() {
        return menuItemService.getAllMenuItems();
    }
    @GetMapping("/{id}")
    public MenuItemDto getMenuItemById(@PathVariable UUID id) {
        return menuItemService.getMenuItemById(id);
    }
    @GetMapping(params = {"page", "size", "sort"})
    public List<MenuItemDto> getAllMenuItems(Pageable pageable){
        return menuItemService.getAllMenuItems(pageable);
    }

    @PostMapping
    public MenuItemDto createMenuItem(@RequestBody NewMenuItemDto newMenuItemDto) {
        return menuItemService.addMenuItem(newMenuItemDto);
    }
}
