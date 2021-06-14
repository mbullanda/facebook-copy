package pl.michal.facebookcopy.service.posts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.repository.PostRepository;

@Service
@AllArgsConstructor
public class DeletePostService {

    private final PostRepository postRepository;

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
