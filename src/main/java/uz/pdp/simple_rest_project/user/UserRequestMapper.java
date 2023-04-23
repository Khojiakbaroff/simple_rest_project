package uz.pdp.simple_rest_project.user;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserRequestMapper implements Function<UserRequest, UserEntity> {

    @Override
    public UserEntity apply(UserRequest userRequest) {
        return UserEntity
                .builder()
                .firstname(userRequest.firstname())
                .lastname(userRequest.lastname())
                .username(userRequest.username())
                .password(userRequest.password())
                .gender(userRequest.gender())
                .roles(userRequest.roles())
                .build();
    }
}
