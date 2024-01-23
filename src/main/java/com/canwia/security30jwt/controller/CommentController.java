package com.canwia.security30jwt.controller;

import com.canwia.security30jwt.dto.CommentDto;
import com.canwia.security30jwt.dto.request.CommentCreateRequest;
import com.canwia.security30jwt.dto.request.CommentUpdateRequest;
import com.canwia.security30jwt.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CommentController {

    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping("/comment")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentCreateRequest commentCreateRequest){
        return ResponseEntity.ok(commentService.createComment(commentCreateRequest));
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<List<CommentDto>> getAllComments(@PathVariable Long id){
        return ResponseEntity.ok(commentService.getAllComment(id));
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable Long id){
        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    @PutMapping("/comment/{id}")
    public ResponseEntity<CommentDto> updateCommentById(@PathVariable Long id, @RequestBody CommentUpdateRequest commentUpdateRequest){
        return ResponseEntity.ok(commentService.updateComment(id,commentUpdateRequest));
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<String> deleteCommentById(@PathVariable Long id){
        return ResponseEntity.ok(commentService.deleteComment(id));
    }

}
