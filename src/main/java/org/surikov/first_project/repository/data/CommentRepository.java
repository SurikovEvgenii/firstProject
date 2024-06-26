package org.surikov.first_project.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.surikov.first_project.entities.data.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
