package pl.michal.facebookcopy.service.posts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.facebookcopy.model.Post;
import pl.michal.facebookcopy.repository.PostRepository;
import pl.michal.facebookcopy.service.converters.posts.UpdatePostConverter;
import pl.michal.facebookcopy.web.rest.dto.posts.UpdatePostRequest;
import pl.michal.facebookcopy.web.rest.dto.posts.UpdatePostResponse;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UpdatePostService {
    private final PostRepository postRepository;
    private final UpdatePostConverter updatePostConverter;

    public UpdatePostResponse updatePost(Long id, UpdatePostRequest request){
        Post postToUpdate = postRepository.findById(id).orElseThrow(NoSuchElementException::new);
        postToUpdate.setText(request.getText());
        postToUpdate.setImagePath(request.getImagePath());
        return updatePostConverter.toDto(postToUpdate);
    }
}
