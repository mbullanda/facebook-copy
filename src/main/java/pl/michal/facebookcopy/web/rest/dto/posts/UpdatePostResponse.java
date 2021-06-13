package pl.michal.facebookcopy.web.rest.dto.posts;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdatePostResponse {
    private long id;
    private String text;
    private String imagePath;
}
