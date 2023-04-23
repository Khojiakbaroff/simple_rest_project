package uz.pdp.simple_rest_project.user;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.pdp.simple_rest_project.exception.RecordNotFoundException;
import uz.pdp.simple_rest_project.util.CustomDateFormatter;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;
    private final UserRequestMapper userRequestMapper;
    private final CustomDateFormatter customDateFormatter;

    public List<UserDTO> getAllUsers(int page, int size, String prop) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by(prop));
        return userRepository.findAll(pageable).stream().map(userDTOMapper).toList();
    }

    public UserDTO addUser(UserRequest userRequest) {
        UserEntity userEntity = userRequestMapper.apply(userRequest);
        userEntity.setCreatedDateTime(customDateFormatter.now());
        userEntity.setLastModifiedDateTime(customDateFormatter.now());
        UserEntity savedEntity = userRepository.save(userEntity);
        return userDTOMapper.apply(savedEntity);
    }

    public UserDTO getUserById(long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("User with id [%s] not found ".formatted(id)));

        return userDTOMapper.apply(userEntity);
    }


}
