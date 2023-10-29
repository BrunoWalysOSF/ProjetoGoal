package digital.osf.hackazillians.mapper;

import digital.osf.hackazillians.dto.UserDto;
import digital.osf.hackazillians.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "password", ignore = true)
    public UserDto toDto(User user);

    @Mapping(target = "userName", source = "userName")
    User toEntity(UserDto userDto);
}
