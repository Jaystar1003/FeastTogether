package org.FeastTogether.controller;

import org.FeastTogether.dto.AssignMenuItemDto;
import org.FeastTogether.dto.AssignSingleUserDto;
import org.FeastTogether.dto.IngredientDto;
import org.FeastTogether.dto.NewIngredientDto;
import org.FeastTogether.service.IngredientService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @GetMapping
    public List<IngredientDto> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }
    @GetMapping("/{id}")
    public IngredientDto getIngredientById(@PathVariable UUID id) {
        return ingredientService.getIngredientById(id);
    }
    @GetMapping(params = {"page", "size", "sort"})
    public List<IngredientDto> getAllIngredients(Pageable pageable){
        return ingredientService.getAllIngredients(pageable);
    }

    @PostMapping
    public IngredientDto createIngredient(@RequestBody NewIngredientDto newIngredientDto) {
        return ingredientService.addIngredient(newIngredientDto);
    }

    @PutMapping("/{ingredientId}/singleUsers/{singleUserId}")
    public AssignSingleUserDto assignIngredientToSingleUser(@PathVariable UUID ingredientId, @PathVariable UUID singleUserId) {
        return ingredientService.assignSingleUser(ingredientId, singleUserId);
    }
    @PutMapping("/{ingredientId}/menuItems/{menuItemId}")
    public AssignMenuItemDto assignIngredientToMenuItem(@PathVariable UUID ingredientId, @PathVariable UUID menuItemId) {
        return ingredientService.assignMenuItem(ingredientId, menuItemId);
    }
}
