package pl.michal.facebookcopy.web.rest.dto.posts;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePostResponse {
    private long id;
    private String text;
    private String imagePath;
}
