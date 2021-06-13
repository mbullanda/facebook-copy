package pl.michal.facebookcopy.web.rest.dto.posts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostRequest {

    @NotBlank(message = "Text cannot be blank")
    private String text;

    private String imagePath;

    @Min(value = 1, message = "User id must be greater than 0")
    private long userId;
}
