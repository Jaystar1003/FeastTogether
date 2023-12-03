package org.FeastTogether.mapper;

import org.FeastTogether.dto.NewSingleUserDto;
import org.FeastTogether.dto.SingleUserDto;
import org.FeastTogether.entity.SingleUser;
import org.springframework.stereotype.Component;

@Component
public class SingleUserMapper {
    public SingleUser mapDtoToSingleUser(NewSingleUserDto newSingleUserDto) {
        return new SingleUser(
                newSingleUserDto.firstName(),
                newSingleUserDto.lastName(),
                newSingleUserDto.userName(),
                newSingleUserDto.email()
        );
    }
    public SingleUserDto mapSingleUserToDto(SingleUser singleUser) {
        return new SingleUserDto(
                singleUser.getId(),
                singleUser.getFirstName(),
                singleUser.getLastName(),
                singleUser.getUserName(),
                singleUser.getEmail(),
                singleUser.getIngredients().stream().toList(),
                singleUser.getMenuItems().stream().toList()
        );
    }
}
