package pl.michal.facebookcopy.service.mappers.comments;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.Comment;
import pl.michal.facebookcopy.repository.UserRepository;
import pl.michal.facebookcopy.service.mappers.Convertable;
import pl.michal.facebookcopy.web.rest.dto.comments.UpdateCommentRequest;
import pl.michal.facebookcopy.web.rest.dto.comments.UpdateCommentResponse;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UpdateCommentMapper implements Convertable<UpdateCommentRequest, Comment, UpdateCommentResponse> {

    private final UserRepository userRepository;

    @Override
    public Comment fromDto(UpdateCommentRequest input) {
        return Comment.builder()
                .text(input.getText())
                .user(userRepository.findById(input.getUserId()).orElseThrow(NoSuchElementException::new))
                .build();
    }

    @Override
    public UpdateCommentResponse toDto(Comment comment) {
        return UpdateCommentResponse.builder()
                .id(comment.getId())
                .text(comment.getText())
                .userId(comment.getUser().getId())
                .build();
    }
}
