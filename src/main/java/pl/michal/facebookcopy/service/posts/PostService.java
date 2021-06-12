package pl.michal.facebookcopy.service.posts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.Post;
import pl.michal.facebookcopy.repository.PostRepository;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post createPost(Post post){
        return postRepository.save(post);
    }

}
