package uz.pdp.simple_rest_project.user;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDTOMapper implements Function<UserEntity, UserDTO> {

    @Override
    public UserDTO apply(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getUserId(),
                userEntity.getUsername(),
                userEntity.getFirstname(),
                userEntity.getLastname(),
                userEntity.getGender(),
                userEntity.getRoles(),
                userEntity.getCreatedDateTime(),
                userEntity.getLastModifiedDateTime()
        );
    }
}
