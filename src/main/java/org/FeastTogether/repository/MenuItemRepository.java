package org.FeastTogether.repository;

import org.FeastTogether.entity.Ingredient;
import org.FeastTogether.entity.MenuItem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MenuItemRepository extends JpaRepository<MenuItem, UUID> {
    @Query("SELECT distinct menu FROM MenuItem menu LEFT JOIN FETCH menu.menu_ingredients")
    List<MenuItem> findAllBy();

    @Query("SELECT distinct menu FROM MenuItem menu " +
            "LEFT JOIN FETCH menu.menu_ingredients WHERE menu.id = :id")
    Optional<MenuItem> findOneById(UUID id);

    @Query("SELECT distinct menu FROM MenuItem menu LEFT JOIN FETCH menu.menu_ingredients")
    List<MenuItem> findAllBy(Pageable pageable);
}
