package pl.michal.facebookcopy.web.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.michal.facebookcopy.service.posts.CreatePostService;
import pl.michal.facebookcopy.service.posts.GetPostService;
import pl.michal.facebookcopy.web.rest.dto.posts.CreatePostRequest;
import pl.michal.facebookcopy.web.rest.dto.posts.CreatePostResponse;
import pl.michal.facebookcopy.web.rest.dto.posts.GetAllPostResponse;
import pl.michal.facebookcopy.web.rest.dto.posts.GetPostResponse;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
@Transactional
public class PostRestController {

    private final CreatePostService createPostService;
    private final GetPostService getPostService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatePostResponse createPost(@RequestBody @Valid CreatePostRequest request){
        return createPostService.createPost(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetPostResponse getPostById(@PathVariable Long id){
        return getPostService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetAllPostResponse getAllPosts(){
        return getPostService.getAll();
    }
}
