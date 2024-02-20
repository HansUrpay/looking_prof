package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.model.Comment;
import com.lookingprof.lookingProf.model.User;
import com.lookingprof.lookingProf.repository.ICommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService{

    private final ICommentRepository iCommentRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Comment> findByUserOrigin(User user) {
        return iCommentRepository.findByUserOrigin(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findByUserDestination(User user) {
        return iCommentRepository.findByUserDestination(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findByUserDestinationAndQualification(User user, Integer qualify) {
        return iCommentRepository.findByUserDestinationAndQualification(user,qualify);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> listAll() {
        return iCommentRepository.findAll();
    }

    @Override
    @Transactional
    public Comment createComment(Comment dto) {
        try{
            return iCommentRepository.save(dto);
        }catch (Exception e){
            throw new RuntimeException("Error creating comment");
        }
    }

    @Override
    @Transactional
    public Comment updateComment(Integer id, Comment dto) {
        try {
            Comment existingComment = iCommentRepository.findById(id).orElse(null);
            if (existingComment != null) {
                existingComment.setDescription(dto.getDescription());
                return iCommentRepository.save(existingComment);
            }
            else throw new RuntimeException("Comment not found");
        }catch (Exception e){
            throw new RuntimeException("Error while updating comment");
        }
    }

    @Override
    @Transactional
    public HashMap<String, String> deleteComment(Integer id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "Comment was deleted succesfully");
            iCommentRepository.deleteById(id);
            return response;
        }catch (Exception e){
            throw new RuntimeException("Error while deleting comment");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Comment> findById(Integer id) {
        return iCommentRepository.findById(id);
    }


}
