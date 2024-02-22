package com.lookingprof.lookingProf.controller;

import com.lookingprof.lookingProf.model.Comment;
import com.lookingprof.lookingProf.model.User;
import com.lookingprof.lookingProf.service.CommentService;
import com.lookingprof.lookingProf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor()
public class CommentController {

    private CommentService commentService;
    private UserService userService;


    @GetMapping()
    public ResponseEntity<List<Comment>> getAllComments(){
        try{
            return ResponseEntity.ok(commentService.listAll());
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getById(Integer id ){
        try{
            Optional<Comment> comment = commentService.findById(id);
            return comment.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getByUserDestination/{idUser}")
    public ResponseEntity<List<Comment>> getByDestinatiion(@PathVariable Integer idUser){
        try{
            User user = userService.findById(idUser).orElse(null);
            List<Comment> commentList = commentService.findByUserDestination(user);
            return ResponseEntity.ok(commentList);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByUserOrigin/{idUser}")
    public ResponseEntity<List<Comment>> getByOrigin(@PathVariable Integer idUser){
        try{
            User user = userService.findById(idUser).orElse(null);
            List<Comment> commentList = commentService.findByUserOrigin(user);
            return ResponseEntity.ok(commentList);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment dto){
        try{
            Comment createdComment = commentService.createComment(dto);
            return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Integer id, @RequestBody Comment dto){
        try{
            Comment updatedComment = commentService.updateComment(id, dto);
            if (updatedComment!=null) return new ResponseEntity<>(updatedComment, HttpStatus.OK);
            else return ResponseEntity.notFound().build();
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, String>> deleteComment(@PathVariable Integer id){
        try{
            HashMap<String, String> response = commentService.deleteComment(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




}
