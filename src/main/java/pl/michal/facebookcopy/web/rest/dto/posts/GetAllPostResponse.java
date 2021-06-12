package pl.michal.facebookcopy.web.rest.dto.posts;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetAllPostResponse {
    private List<GetPostResponse> posts;
}
