package pl.michal.facebookcopy.service.comments;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.repository.CommentRepository;
import pl.michal.facebookcopy.service.mappers.comments.GetCommentMapper;
import pl.michal.facebookcopy.web.rest.dto.comments.GetAllCommentsResponse;
import pl.michal.facebookcopy.web.rest.dto.comments.GetCommentResponse;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetCommentService {

    private final CommentRepository commentRepository;
    private final GetCommentMapper getCommentMapper;

    public GetAllCommentsResponse getAllCommentsByPostId(Long id) {
        return GetAllCommentsResponse.builder()
                .comments(commentRepository.getAllByPostId(id).stream()
                        .map(getCommentMapper::toDto)
                        .collect(Collectors.toList())
                )
                .build();
    }

    public GetCommentResponse getById(Long id) {
        return getCommentMapper.toDto(commentRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }
}
