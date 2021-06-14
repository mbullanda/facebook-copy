package pl.michal.facebookcopy.service.mappers.comments;

import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.Comment;
import pl.michal.facebookcopy.service.mappers.Convertable;
import pl.michal.facebookcopy.web.rest.dto.comments.GetCommentResponse;

@Service
public class GetCommentMapper implements Convertable<Void, Comment, GetCommentResponse> {
    @Override
    public Comment fromDto(Void input) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public GetCommentResponse toDto(Comment comment) {
        return GetCommentResponse.builder()
                .id(comment.getId())
                .text(comment.getText())
                .userId(comment.getUser().getId())
                .build();
    }
}
