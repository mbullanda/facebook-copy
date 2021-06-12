package pl.michal.facebookcopy.web.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.michal.facebookcopy.model.User;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostRequest {

    @NotBlank(message = "Text cannot be blank")
    private String text;

    private String imagePath;

    private long userId;
}
