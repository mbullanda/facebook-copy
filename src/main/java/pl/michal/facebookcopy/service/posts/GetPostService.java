package pl.michal.facebookcopy.service.posts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.repository.PostRepository;
import pl.michal.facebookcopy.service.mappers.posts.GetPostMapper;
import pl.michal.facebookcopy.web.rest.dto.posts.GetAllPostsResponse;
import pl.michal.facebookcopy.web.rest.dto.posts.GetPostResponse;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GetPostService {

    private final PostRepository postRepository;
    private final GetPostMapper getPostMapper;

    public GetPostResponse getById(Long postId){
        return getPostMapper.toDto(postRepository.findById(postId).orElseThrow(NoSuchElementException::new));
    }

    public GetAllPostsResponse getAll() {
        return GetAllPostsResponse.builder()
                .posts(postRepository.findAll().stream()
                    .map(getPostMapper::toDto)
                        .collect(Collectors.toList())
                )
                .build();
    }
}
