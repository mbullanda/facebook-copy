package pl.michal.facebookcopy.mapper;

import org.springframework.stereotype.Component;
import pl.michal.facebookcopy.model.Post;
import pl.michal.facebookcopy.web.rest.dto.CreatePostRequest;

@Component
public class CreatePostRequestToPostMapper {

    public Post toDomain(CreatePostRequest request){
        return Post.builder()
                .text(request.getText())
                .imagePath(request.getImagePath())
                .build();
    }
}
