package pl.michal.facebookcopy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.michal.facebookcopy.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
