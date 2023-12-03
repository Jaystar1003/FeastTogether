package org.FeastTogether.service;

import org.FeastTogether.dto.AssignMenuItemDto;
import org.FeastTogether.dto.AssignSingleUserDto;
import org.FeastTogether.dto.IngredientDto;
import org.FeastTogether.dto.NewIngredientDto;
import org.FeastTogether.entity.*;
import org.FeastTogether.mapper.IngredientMapper;
import org.FeastTogether.repository.*;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IngredientService {
    private IngredientRepository ingredientRepository;
    private SingleUserRepository singleUserRepository;
    private final MenuItemRepository menuItemRepository;
    private final IngredientMapper ingredientMapper;

    public IngredientService(IngredientRepository ingredientRepository, SingleUserRepository singleUserRepository,
                             MenuItemRepository menuItemRepository, IngredientMapper ingredientMapper) {
        this.ingredientRepository = ingredientRepository;
        this.singleUserRepository = singleUserRepository;
        this.menuItemRepository = menuItemRepository;
        this.ingredientMapper = ingredientMapper;
    }
    public List<IngredientDto> getAllIngredients() {
        return this.ingredientRepository.findAllBy()
                .stream().map(ingredientMapper::mapIngredientToDto)
                .toList();
    }
    public IngredientDto addIngredient(NewIngredientDto newIngredientDto) {
        Ingredient ingredient = ingredientMapper.mapDtoToIngredient(newIngredientDto);
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        return ingredientMapper.mapIngredientToDto(savedIngredient);
    }

    public IngredientDto getIngredientById(UUID id) {
        return ingredientRepository.findOneById(id)
                .map(ingredientMapper::mapIngredientToDto)
                .orElseThrow();
    }
    public List<IngredientDto> getAllIngredients(Pageable pageable) {
        return ingredientRepository.findAllBy(pageable).stream()
                .map(ingredientMapper::mapIngredientToDto).toList();
    }
    public AssignSingleUserDto assignSingleUser(UUID ingredientId, UUID singleUserId) {
        Ingredient ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow();
        SingleUser singleUser = singleUserRepository.findById(singleUserId)
                .orElseThrow();

        singleUser.addNewIngredient(ingredient);
        ingredient.addNewSingleUser(singleUser);

        ingredientRepository.save(ingredient);

        return new AssignSingleUserDto(ingredientId, singleUserId, "Ingredient assigned to User!");
    }
    public AssignMenuItemDto assignMenuItem(UUID ingredientId, UUID menuItemId) {
        Ingredient ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow();
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow();

        ingredient.addNewMenuItem(menuItem);
        menuItem.addNewIngredient(ingredient);

        menuItemRepository.save(menuItem);

        return new AssignMenuItemDto(ingredientId, menuItemId, "Ingredient assigned to Menu Item!");
    }

}
