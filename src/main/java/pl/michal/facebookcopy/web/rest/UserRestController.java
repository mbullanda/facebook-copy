package pl.michal.facebookcopy.web.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.michal.facebookcopy.service.users.CreateUserService;
import pl.michal.facebookcopy.service.users.GetUserService;
import pl.michal.facebookcopy.web.rest.dto.users.CreateUserRequest;
import pl.michal.facebookcopy.web.rest.dto.users.CreateUserResponse;
import pl.michal.facebookcopy.web.rest.dto.users.GetAllUsersResponse;
import pl.michal.facebookcopy.web.rest.dto.users.GetUserResponse;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Transactional
public class UserRestController {

    private final CreateUserService createUserService;
    private final GetUserService getUserService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse createUser(@RequestBody @Valid CreateUserRequest request){
        return createUserService.createUser(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetUserResponse getUserById(@PathVariable Long id){
        return getUserService.getUserById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetAllUsersResponse getAllUsers(){
        return getUserService.getAll();
    }
}
