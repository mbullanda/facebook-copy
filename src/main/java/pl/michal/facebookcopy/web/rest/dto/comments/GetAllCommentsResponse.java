package pl.michal.facebookcopy.web.rest.dto.comments;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllCommentsResponse {
    private List<GetCommentResponse> comments;
}
