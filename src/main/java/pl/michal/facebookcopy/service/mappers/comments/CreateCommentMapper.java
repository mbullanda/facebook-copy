package pl.michal.facebookcopy.service.mappers.comments;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.Comment;
import pl.michal.facebookcopy.repository.UserRepository;
import pl.michal.facebookcopy.service.mappers.Convertable;
import pl.michal.facebookcopy.web.rest.dto.comments.CreateCommentRequest;
import pl.michal.facebookcopy.web.rest.dto.comments.CreateCommentResponse;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CreateCommentMapper implements Convertable<CreateCommentRequest, Comment, CreateCommentResponse> {

    //na ten moment tak wygląda dodawanie usera do komentarza, poprawić to później, jak ogarnie się użytkowników poprawnie
    // i usunąć to wstrzyknięte repo poniżej i adnotację AllArgs...
    private final UserRepository userRepository;

    @Override
    public Comment fromDto(CreateCommentRequest input) {
        return Comment.builder()
                .text(input.getText())
                .user(userRepository.findById(input.getUserId()).orElseThrow(NoSuchElementException::new))
                .build();
    }

    @Override
    public CreateCommentResponse toDto(Comment comment) {
        return CreateCommentResponse.builder()
                .id(comment.getId())
                .text(comment.getText())
                .userId(comment.getUser().getId())
                .build();
    }
}
