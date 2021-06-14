package pl.michal.facebookcopy.service.comments;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.Comment;
import pl.michal.facebookcopy.model.Post;
import pl.michal.facebookcopy.repository.CommentRepository;
import pl.michal.facebookcopy.repository.PostRepository;
import pl.michal.facebookcopy.repository.UserRepository;
import pl.michal.facebookcopy.service.mappers.comments.CreateCommentMapper;
import pl.michal.facebookcopy.web.rest.dto.comments.CreateCommentRequest;
import pl.michal.facebookcopy.web.rest.dto.comments.CreateCommentResponse;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CreateCommentService {

    private final CommentRepository commentRepository;
    private final CreateCommentMapper createCommentMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CreateCommentResponse createComment(CreateCommentRequest request, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(NoSuchElementException::new);
        Comment commentToCreate = createCommentMapper.fromDto(request);
        commentToCreate.setPost(post);
        commentToCreate.setUser(userRepository.findById(request.getUserId()).orElseThrow(NoSuchElementException::new));
        return createCommentMapper.toDto(commentRepository.save(commentToCreate));
    }
}
