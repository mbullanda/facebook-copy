package pl.michal.facebookcopy.web.rest.dto.users;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserResponse {
    private long id;
    private String username;
    private String mail;
    private boolean active;
}
