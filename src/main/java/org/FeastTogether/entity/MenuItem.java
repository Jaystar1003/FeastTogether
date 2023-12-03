package org.FeastTogether.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MenuItem {
    @Id
    private UUID id = UUID.randomUUID();
    @Version
    private Long version;
    @NotBlank(message = "Title must be added")
    private String title;
    private String description;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "ingredient_menu",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Ingredient> menu_ingredients = new HashSet<>();
    @ManyToMany(mappedBy = "menuItems")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<SingleUser> singleUsers = new HashSet<>();

    public MenuItem(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public void addNewIngredient(Ingredient ingredient) {
        this.menu_ingredients.add(ingredient);
    }
    public void addNewSingleUser(SingleUser singleUser) { this.singleUsers.add(singleUser); }
}
