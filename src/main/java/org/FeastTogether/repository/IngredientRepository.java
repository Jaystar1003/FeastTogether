package org.FeastTogether.repository;

import org.FeastTogether.dto.IngredientDto;
import org.FeastTogether.entity.Ingredient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {
    @Query("SELECT distinct ing FROM Ingredient ing LEFT JOIN FETCH ing.menuItems")
    List<Ingredient> findAllBy();

    @Query("SELECT distinct ing FROM Ingredient ing " +
            "LEFT JOIN FETCH ing.menuItems WHERE ing.id = :id")
    Optional<Ingredient> findOneById(UUID id);

    @Query("SELECT distinct ing FROM Ingredient ing LEFT JOIN FETCH ing.menuItems")
    List<Ingredient> findAllBy(Pageable pageable);
}
