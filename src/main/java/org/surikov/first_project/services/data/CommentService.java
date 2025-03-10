package org.surikov.first_project.services.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surikov.first_project.entities.data.Comment;
import org.surikov.first_project.repository.data.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findByProjectId(Long projectId) {
        return commentRepository.findByProjectId(projectId);
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }


}
