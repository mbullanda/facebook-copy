package pl.michal.facebookcopy.service.converters.posts;

import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.Post;
import pl.michal.facebookcopy.service.converters.Convertable;
import pl.michal.facebookcopy.web.rest.dto.posts.UpdatePostRequest;
import pl.michal.facebookcopy.web.rest.dto.posts.UpdatePostResponse;

@Service
public class UpdatePostConverter implements Convertable<UpdatePostRequest, Post, UpdatePostResponse> {
    @Override
    public Post fromDto(UpdatePostRequest input) {
        return Post.builder()
                .text(input.getText())
                .imagePath(input.getImagePath())
                .build();
    }

    @Override
    public UpdatePostResponse toDto(Post post) {
        return UpdatePostResponse.builder()
                .id(post.getId())
                .text(post.getText())
                .imagePath(post.getImagePath())
                .build();
    }
}
