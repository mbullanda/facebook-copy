package pl.michal.facebookcopy.web.rest.dto.comments;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateCommentResponse {
    private long id;
    private String text;
    private long userId;
}
