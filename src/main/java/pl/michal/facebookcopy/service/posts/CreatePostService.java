package pl.michal.facebookcopy.service.posts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.Post;
import pl.michal.facebookcopy.repository.PostRepository;
import pl.michal.facebookcopy.repository.UserRepository;
import pl.michal.facebookcopy.service.mappers.posts.CreatePostMapper;
import pl.michal.facebookcopy.service.users.GetUserService;
import pl.michal.facebookcopy.web.rest.dto.posts.CreatePostRequest;
import pl.michal.facebookcopy.web.rest.dto.posts.CreatePostResponse;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CreatePostService {

    private final PostRepository postRepository;
    private final CreatePostMapper createPostMapper;
    private final UserRepository userRepository;

    public CreatePostResponse createPost(CreatePostRequest request){
        Post postToCreate = createPostMapper.fromDto(request);
            postToCreate.setUser(userRepository.findById(request.getUserId()).orElseThrow(NoSuchElementException::new));
            postToCreate.getUser().getPosts().add(postToCreate);
        return createPostMapper.toDto(postRepository.save(postToCreate));
    }

}
