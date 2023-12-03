package org.FeastTogether.mapper;

import org.FeastTogether.dto.SingleUserDto;
import org.FeastTogether.entity.Ingredient;
import org.FeastTogether.entity.SingleUser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.UUID;

class SingleUserMapperTest {
    private SingleUserMapper testedMapper = new SingleUserMapper();

    @Test()
    @DisplayName("Testing if mapper correctly maps Single User to Dto")
    void shouldMapSingleUserEntityToDto() {
        UUID singleUserUuid = UUID.fromString("17c4cea2-8e6d-4aad-87ad-eba5738eca01");
        //given
        SingleUser singleUser =
                new SingleUser("testedFirstName", "testedLastName", "testedUserName", "testedEmail");
        singleUser.setId(singleUserUuid);

        Ingredient ingredient1 =
                new Ingredient("Ingredient1");
        ingredient1.setId(UUID.fromString("82ecfd0e-103c-48f2-8c07-6a2c7c31c29e"));

        Ingredient ingredient2 =
                new Ingredient("Ingredient2");
        ingredient2.setId(UUID.fromString("219ab3c9-63f1-43a7-8c19-bd0ab4c9bcf9"));

        singleUser.setIngredients(Set.of(ingredient1, ingredient2));
        ingredient1.setSingleUsers(Set.of(singleUser));
        ingredient2.setSingleUsers(Set.of(singleUser));
        //when
        SingleUserDto actualDto = testedMapper.mapSingleUserToDto(singleUser);
        //then
        SingleUserDto expectedDto = new SingleUserDto(singleUserUuid, "testedFirstName",
                "testedLastName", "testedUserName", "testedEmail");

        Assertions.assertThat(expectedDto.id()).isEqualTo(actualDto.id());
        Assertions.assertThat(expectedDto.firstName()).isEqualTo(actualDto.firstName());
        Assertions.assertThat(expectedDto.lastName()).isEqualTo(actualDto.lastName());
        Assertions.assertThat(expectedDto.userName()).isEqualTo(actualDto.userName());
        Assertions.assertThat(expectedDto.email()).isEqualTo(actualDto.email());
    }
}
