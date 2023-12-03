package org.FeastTogether.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleUser {
    @Id
    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "singleUser_ingredient",
            joinColumns = @JoinColumn(name = "singleUser_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<Ingredient> ingredients = new HashSet<>();
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "singleUser_menuItem",
            joinColumns = @JoinColumn(name = "singleUser_id"),
            inverseJoinColumns = @JoinColumn(name = "menuItem_id")
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<MenuItem> menuItems = new HashSet<>();

    public SingleUser(String firstName, String lastName, String userName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
    }
    public SingleUser(String firstName, String lastName, String userName, String email,
                      Set<Ingredient> ingredients) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.ingredients = ingredients;
    }

    public SingleUser(UUID id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public void addNewIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
    public void addNewMenuItem(MenuItem menuItem) { this.menuItems.add(menuItem); }
}
