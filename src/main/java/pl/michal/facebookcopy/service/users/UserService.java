package pl.michal.facebookcopy.service.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.User;
import pl.michal.facebookcopy.repository.UserRepository;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

}
