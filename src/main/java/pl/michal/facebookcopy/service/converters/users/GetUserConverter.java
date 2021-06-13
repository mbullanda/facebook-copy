package pl.michal.facebookcopy.service.converters.users;

import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.User;
import pl.michal.facebookcopy.service.converters.Convertable;
import pl.michal.facebookcopy.web.rest.dto.posts.GetPostResponse;
import pl.michal.facebookcopy.web.rest.dto.users.GetUserResponse;

@Service
public class GetUserConverter implements Convertable<Void, User, GetUserResponse> {

    @Override
    public User fromDto(Void input) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public GetUserResponse toDto(User user) {
        return GetUserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .mail(user.getMail())
                .active(user.isActive())
                .build();
    }
}
