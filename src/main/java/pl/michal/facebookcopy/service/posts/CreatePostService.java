package pl.michal.facebookcopy.service.posts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.Post;
import pl.michal.facebookcopy.repository.PostRepository;
import pl.michal.facebookcopy.repository.UserRepository;
import pl.michal.facebookcopy.service.converters.posts.CreatePostConverter;
import pl.michal.facebookcopy.service.users.GetUserService;
import pl.michal.facebookcopy.web.rest.dto.posts.CreatePostRequest;
import pl.michal.facebookcopy.web.rest.dto.posts.CreatePostResponse;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CreatePostService {

    private final PostRepository postRepository;
    private final CreatePostConverter createPostConverter;
    private final GetUserService getUserService;
    private final UserRepository userRepository;

    public CreatePostResponse createPost(CreatePostRequest request){
        Post postToCreate = createPostConverter.fromDto(request);
            postToCreate.setUser(userRepository.findById(request.getUserId()).orElseThrow(NoSuchElementException::new));
            postToCreate.getUser().getPosts().add(postToCreate);
        return createPostConverter.toDto(postRepository.save(postToCreate));
    }

}
