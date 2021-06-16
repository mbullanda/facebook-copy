package pl.michal.facebookcopy.service.mappers.comments;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.repository.CommentRepository;

@Service
@AllArgsConstructor
public class DeleteCommentService {

    private final CommentRepository commentRepository;

    public void deleteCommentById(Long id){
        commentRepository.deleteById(id);
    }
}
