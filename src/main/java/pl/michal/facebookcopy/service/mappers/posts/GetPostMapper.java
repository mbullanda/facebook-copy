package pl.michal.facebookcopy.service.mappers.posts;

import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.Post;
import pl.michal.facebookcopy.service.mappers.Convertable;
import pl.michal.facebookcopy.web.rest.dto.posts.GetPostResponse;

@Service
public class GetPostMapper implements Convertable<Void, Post, GetPostResponse> {

    @Override
    public Post fromDto(Void input) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public GetPostResponse toDto(Post post) {
        return GetPostResponse.builder()
                .id(post.getId())
                .text(post.getText())
                .imagePath(post.getImagePath())
                .build();
    }
}
