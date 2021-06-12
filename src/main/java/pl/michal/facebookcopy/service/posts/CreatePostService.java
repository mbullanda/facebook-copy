package pl.michal.facebookcopy.service.posts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.mapper.CreatePostRequestToPostMapper;
import pl.michal.facebookcopy.mapper.PostToPostResponseMapper;
import pl.michal.facebookcopy.model.Post;
import pl.michal.facebookcopy.repository.PostRepository;
import pl.michal.facebookcopy.service.converters.posts.CreatePostConverter;
import pl.michal.facebookcopy.service.users.GetUserService;
import pl.michal.facebookcopy.web.rest.dto.posts.CreatePostRequest;
import pl.michal.facebookcopy.web.rest.dto.posts.CreatePostResponse;
import pl.michal.facebookcopy.web.rest.dto.posts.PostResponse;

@Service
@AllArgsConstructor
public class CreatePostService {

    private final PostRepository postRepository;
    private final CreatePostConverter createPostConverter;
    private final GetUserService getUserService;

    public CreatePostResponse createPost(CreatePostRequest request){
        Post postToCreate = createPostConverter.fromDto(request);
            postToCreate.setUser(getUserService.getUserById(request.getUserId()));
            postToCreate.getUser().getPosts().add(postToCreate);
        return createPostConverter.toDto(postRepository.save(postToCreate));
    }

}
