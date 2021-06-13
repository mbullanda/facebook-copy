package pl.michal.facebookcopy.service.converters.users;

import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.User;
import pl.michal.facebookcopy.service.converters.Convertable;
import pl.michal.facebookcopy.web.rest.dto.users.CreateUserRequest;
import pl.michal.facebookcopy.web.rest.dto.users.CreateUserResponse;

@Service
public class CreateUserConverter implements Convertable<CreateUserRequest, User, CreateUserResponse> {

    @Override
    public User fromDto(CreateUserRequest input) {
        User user = User.builder()
                .username(input.getUsername())
                .password(input.getPassword())
                .mail(input.getMail())
                .active(false)
                .build();
        return user;
    }

    @Override
    public CreateUserResponse toDto(User user) {
        return CreateUserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .mail(user.getMail())
                .active(user.isActive())
                .build();
    }
}
