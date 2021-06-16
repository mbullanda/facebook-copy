package pl.michal.facebookcopy.service.comments;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.Comment;
import pl.michal.facebookcopy.repository.CommentRepository;
import pl.michal.facebookcopy.service.mappers.comments.UpdateCommentMapper;
import pl.michal.facebookcopy.web.rest.dto.comments.UpdateCommentRequest;
import pl.michal.facebookcopy.web.rest.dto.comments.UpdateCommentResponse;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UpdateCommentService {

    private final CommentRepository commentRepository;
    private final UpdateCommentMapper updateCommentMapper;

    public UpdateCommentResponse updateComment(Long id, UpdateCommentRequest request){
        Comment commentToUpdate = commentRepository.findById(id).orElseThrow(NoSuchElementException::new);
        commentToUpdate.setText(request.getText());
        return updateCommentMapper.toDto(commentToUpdate);
    }
}
