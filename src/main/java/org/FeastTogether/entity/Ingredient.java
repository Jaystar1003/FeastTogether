package org.FeastTogether.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    private UUID id = UUID.randomUUID();
    @NotBlank(message = "Name must be added.")
    private String name;
    private float quantity;
    @ManyToMany(mappedBy = "menu_ingredients")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<MenuItem> menuItems;
    @ManyToMany(mappedBy = "ingredients")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<SingleUser> singleUsers;


    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Ingredient(String name, float quantity, Set<MenuItem> menuItems) {
        this.name = name;
        this.quantity = quantity;
        this.menuItems = menuItems;
    }

    public void addNewSingleUser(SingleUser singleUser) {
        this.getSingleUsers().add(singleUser);
    }

    public void addNewMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }
}
