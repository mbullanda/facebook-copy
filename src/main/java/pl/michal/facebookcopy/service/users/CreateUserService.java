package pl.michal.facebookcopy.service.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.User;
import pl.michal.facebookcopy.repository.UserRepository;
import pl.michal.facebookcopy.service.mappers.users.CreateUserMapper;
import pl.michal.facebookcopy.web.rest.dto.users.CreateUserRequest;
import pl.michal.facebookcopy.web.rest.dto.users.CreateUserResponse;

@Service
@AllArgsConstructor
public class CreateUserService {

    private final UserRepository userRepository;
    private final CreateUserMapper createUserMapper;

    public CreateUserResponse createUser(CreateUserRequest request){
        User userToCreate = createUserMapper.fromDto(request);
        return createUserMapper.toDto(userRepository.save(userToCreate));
    }
}
