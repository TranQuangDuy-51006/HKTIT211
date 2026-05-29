package re.hktit211.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.hktit211.entity.Post;

public interface PostRepository extends JpaRepository<Post,Long> {

}
