package pl.michal.facebookcopy.service.mappers.posts;

import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.Post;
import pl.michal.facebookcopy.service.mappers.Convertable;
import pl.michal.facebookcopy.web.rest.dto.posts.CreatePostRequest;
import pl.michal.facebookcopy.web.rest.dto.posts.CreatePostResponse;

@Service
public class CreatePostMapper implements Convertable<CreatePostRequest, Post, CreatePostResponse> {

    @Override
    public Post fromDto(CreatePostRequest input) {
        Post post = Post.builder()
                .text(input.getText())
                .imagePath(input.getImagePath())
                .build();
        return post;
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
