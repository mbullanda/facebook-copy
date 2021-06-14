package pl.michal.facebookcopy.service.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.repository.UserRepository;
import pl.michal.facebookcopy.service.mappers.users.GetUserMapper;
import pl.michal.facebookcopy.web.rest.dto.users.GetAllUsersResponse;
import pl.michal.facebookcopy.web.rest.dto.users.GetUserResponse;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetUserService {

    private final UserRepository userRepository;
    private final GetUserMapper getUserMapper;

    public GetUserResponse getUserById(Long id){
        return getUserMapper.toDto(userRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    public GetAllUsersResponse getAll(){
        return GetAllUsersResponse.builder()
                .users(userRepository.findAll().stream()
                        .map(getUserMapper::toDto)
                        .collect(Collectors.toList())
                )
                .build();
    }


}
