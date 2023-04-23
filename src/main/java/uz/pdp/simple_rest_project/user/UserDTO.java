package uz.pdp.simple_rest_project.user;

import java.time.LocalDateTime;
import java.util.List;

public record UserDTO(
        Long id,
        String username,
        String firstname,
        String lastname,
        Gender gender,
        List<Role> roles,
        LocalDateTime createdDateTime,
        LocalDateTime lastModifiedDateTime
) {
}
