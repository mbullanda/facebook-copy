package pl.michal.facebookcopy.web.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.michal.facebookcopy.mapper.CreatePostRequestToPostMapper;
import pl.michal.facebookcopy.mapper.PostToPostResponseMapper;
import pl.michal.facebookcopy.model.Post;
import pl.michal.facebookcopy.service.posts.PostService;
import pl.michal.facebookcopy.service.users.UserService;
import pl.michal.facebookcopy.web.rest.dto.CreatePostRequest;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PostRestController {

    private final PostService postService;
    private final CreatePostRequestToPostMapper createPostRequestToPostMapper;
    private final UserService userService;
    private final PostToPostResponseMapper postToPostResponseMapper;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody @Valid CreatePostRequest request, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            Map<String, String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

            return ResponseEntity.badRequest().body(errors);
        }
        Post postToCreate = createPostRequestToPostMapper.toDomain(request);
        postToCreate.setUser(userService.getUserById(request.getUserId()));
        postToCreate.getUser().getPosts().add(postToCreate);

        return new ResponseEntity<>(postToPostResponseMapper.toResponse(postService.createPost(postToCreate)) , HttpStatus.CREATED);
    }
}
