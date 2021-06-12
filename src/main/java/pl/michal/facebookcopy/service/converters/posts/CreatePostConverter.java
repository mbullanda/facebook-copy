package pl.michal.facebookcopy.service.converters.posts;

import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.Post;
import pl.michal.facebookcopy.service.converters.Convertable;
import pl.michal.facebookcopy.web.rest.dto.posts.CreatePostRequest;
import pl.michal.facebookcopy.web.rest.dto.posts.CreatePostResponse;

@Service
public class CreatePostConverter implements Convertable<CreatePostRequest, Post, CreatePostResponse> {

    @Override
    public Post fromDto(CreatePostRequest input) {
        Post entity = Post.builder()
                .text(input.getText())
                .imagePath(input.getImagePath())
                .build();
        return entity;
    }

    @Override
    public CreatePostResponse toDto(Post post) {
        return CreatePostResponse.builder()
                .id(post.getId())
                .text(post.getText())
                .imagePath(post.getImagePath())
                .build();
    }
}
