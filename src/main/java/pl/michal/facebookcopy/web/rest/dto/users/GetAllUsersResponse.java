package pl.michal.facebookcopy.web.rest.dto.users;

import lombok.Builder;
import lombok.Data;
import pl.michal.facebookcopy.model.User;

import java.util.List;

@Data
@Builder
public class GetAllUsersResponse {
    private List<GetUserResponse> users;
}
