package pl.michal.facebookcopy.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"user", "comments"})
@ToString(exclude = {"user","comments"})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String imagePath;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

}
