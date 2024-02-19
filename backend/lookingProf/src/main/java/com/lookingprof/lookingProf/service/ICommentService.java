package com.lookingprof.lookingProf.service;


import com.lookingprof.lookingProf.model.Comment;
import com.lookingprof.lookingProf.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface ICommentService {

    public List<Comment> findByUserOrigin(User user);
    public List<Comment> findByUserDestination(User user);
    public List<Comment> findByUserDestinationAndQualification(User user, Integer qualify);
    public List<Comment> listAll();
    public Comment createComment(Comment dto);
    public Comment updateComment(Integer id, Comment dto);
    public HashMap<String, String> deleteComment(Integer id);

    public Optional<Comment> findById(Integer id);

}
