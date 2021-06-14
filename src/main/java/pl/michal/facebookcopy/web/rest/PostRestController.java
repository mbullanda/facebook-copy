package pl.michal.facebookcopy.web.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.michal.facebookcopy.service.posts.CreatePostService;
import pl.michal.facebookcopy.service.posts.DeletePostService;
import pl.michal.facebookcopy.service.posts.GetPostService;
import pl.michal.facebookcopy.service.posts.UpdatePostService;
import pl.michal.facebookcopy.web.rest.dto.posts.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
@Transactional
public class PostRestController {

    private final CreatePostService createPostService;
    private final GetPostService getPostService;
    private final UpdatePostService updatePostService;
    private final DeletePostService deletePostService;

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
    public GetAllPostsResponse getAllPosts(){
        return getPostService.getAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatePostResponse updatePost(@PathVariable Long id, @RequestBody @Valid UpdatePostRequest request){
        return updatePostService.updatePost(id, request);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id){
        deletePostService.deletePost(id);
    }
}
