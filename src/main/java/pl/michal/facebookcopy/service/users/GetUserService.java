package pl.michal.facebookcopy.service.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.User;
import pl.michal.facebookcopy.repository.UserRepository;
import pl.michal.facebookcopy.service.converters.users.GetUserConverter;
import pl.michal.facebookcopy.web.rest.dto.users.GetAllUsersResponse;
import pl.michal.facebookcopy.web.rest.dto.users.GetUserResponse;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetUserService {

    private final UserRepository userRepository;
    private final GetUserConverter getUserConverter;

    public GetUserResponse getUserById(Long id){
        return getUserConverter.toDto(userRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    public GetAllUsersResponse getAll(){
        return GetAllUsersResponse.builder()
                .users(userRepository.findAll().stream()
                        .map(getUserConverter::toDto)
                        .collect(Collectors.toList())
                )
                .build();
    }


}
