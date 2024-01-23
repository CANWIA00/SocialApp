package com.canwia.security30jwt.controller;

import com.canwia.security30jwt.dto.PostDto;
import com.canwia.security30jwt.dto.request.PostCreateRequest;
import com.canwia.security30jwt.dto.request.PostUpdateRequest;
import com.canwia.security30jwt.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PostController {


    private final PostService postService;

    @GetMapping("/postAll")
    public ResponseEntity<List<PostDto>> getAll(){
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/postUserAll")
    public ResponseEntity<List<PostDto>> getAllPost(){
        return ResponseEntity.ok(postService.getAllPost());
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PostMapping("/post")
    public ResponseEntity<PostDto> createPost(@RequestBody PostCreateRequest postCreateRequest){
        return ResponseEntity.ok(postService.createPostById(postCreateRequest));
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequest postUpdateRequest){
        return ResponseEntity.ok(postService.updatePost(id,postUpdateRequest));
    }

    @DeleteMapping("post/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id){
        return ResponseEntity.ok(postService.deletePostById(id));
    }

}
