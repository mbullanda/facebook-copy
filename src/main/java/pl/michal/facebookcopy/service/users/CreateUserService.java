package pl.michal.facebookcopy.service.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.User;
import pl.michal.facebookcopy.repository.UserRepository;
import pl.michal.facebookcopy.service.converters.users.CreateUserConverter;
import pl.michal.facebookcopy.web.rest.dto.users.CreateUserRequest;
import pl.michal.facebookcopy.web.rest.dto.users.CreateUserResponse;

@Service
@AllArgsConstructor
public class CreateUserService {

    private final UserRepository userRepository;
    private final CreateUserConverter createUserConverter;

    public CreateUserResponse createUser(CreateUserRequest request){
        User userToCreate = createUserConverter.fromDto(request);
        return createUserConverter.toDto(userRepository.save(userToCreate));
    }
}
