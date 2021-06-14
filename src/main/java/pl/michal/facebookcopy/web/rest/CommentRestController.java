package pl.michal.facebookcopy.web.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.michal.facebookcopy.service.comments.CreateCommentService;
import pl.michal.facebookcopy.service.comments.GetCommentService;
import pl.michal.facebookcopy.web.rest.dto.comments.CreateCommentRequest;
import pl.michal.facebookcopy.web.rest.dto.comments.CreateCommentResponse;
import pl.michal.facebookcopy.web.rest.dto.comments.GetAllCommentsResponse;
import pl.michal.facebookcopy.web.rest.dto.comments.GetCommentResponse;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Transactional
public class CommentRestController {

    private final CreateCommentService createCommentService;
    private final GetCommentService getCommentService;

    @PostMapping("/posts/{postId}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCommentResponse createComment(@RequestBody @Valid CreateCommentRequest request, @PathVariable Long postId){
        return createCommentService.createComment(request, postId);
    }

    @GetMapping("/posts/{id}/comments")
    @ResponseStatus(HttpStatus.OK)
    public GetAllCommentsResponse getAllCommentsByPostId(@PathVariable Long id){
        return getCommentService.getAllCommentsByPostId(id);
    }

    @GetMapping("/comments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCommentResponse getCommentById(@PathVariable Long id){
        return getCommentService.getById(id);
    }
}
