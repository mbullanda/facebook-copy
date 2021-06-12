package pl.michal.facebookcopy.mapper;

import org.springframework.stereotype.Component;
import pl.michal.facebookcopy.model.Post;
import pl.michal.facebookcopy.web.rest.dto.PostResponse;

@Component
public class PostToPostResponseMapper {

    public PostResponse toResponse(Post post){
        return PostResponse.builder()
                .id(post.getId())
                .text(post.getText())
                .imagePath(post.getImagePath())
                .userId(post.getUser().getId())
                .build();
    }
}

