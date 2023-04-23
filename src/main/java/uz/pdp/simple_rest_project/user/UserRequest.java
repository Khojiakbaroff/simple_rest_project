package uz.pdp.simple_rest_project.user;

import java.util.List;

public record UserRequest(
        Long id,
        String username,
        String password,
        String firstname,
        String lastname,
        Gender gender,
        List<Role> roles

) {

}
