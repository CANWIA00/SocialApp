package com.canwia.security30jwt.service;

import com.canwia.security30jwt.config.security.AuthUtil;
import com.canwia.security30jwt.dto.converter.PostConverter;
import com.canwia.security30jwt.dto.PostDto;
import com.canwia.security30jwt.dto.request.PostCreateRequest;
import com.canwia.security30jwt.dto.request.PostUpdateRequest;
import com.canwia.security30jwt.exception.ApiRequestException;
import com.canwia.security30jwt.model.Post;
import com.canwia.security30jwt.model.User;
import com.canwia.security30jwt.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostConverter postConverter;
    private final UserService userService;

    public PostService(PostRepository postRepository, PostConverter postConverter, UserService userService) {
        this.postRepository = postRepository;
        this.postConverter = postConverter;
        this.userService = userService;
    }

    public List<PostDto> getAll() {

        List<Post> postList = postRepository.findAll();

        return postConverter.convertListTo(postList);
    }


    public List<PostDto> getAllPost() {
        User user = userService.getUserByUserName(AuthUtil.handleRequest());

        List<Post> postList = postRepository.findPostByUserId(user.getId()).orElseThrow(()->
                new ApiRequestException("There is a problem when catching post by (" + user.getId() + ") userId!!!"));
        return postConverter.convertListTo(postList);
    }

    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->
                new ApiRequestException("There is a problem when catching post by ("+id+") id!!!"));
        return postConverter.convertTo(post);
    }

    public Post getPost(Long id){
        return postRepository.findById(id).orElseThrow(()->
                new ApiRequestException("There is a problem when catching post by ("+id+") id!!!"));
    }

    public PostDto createPostById(PostCreateRequest postCreateRequest) {
        User user = userService.getUserByUserName(AuthUtil.handleRequest());


        Post post = new Post();
        post.setText(postCreateRequest.getContext());
        post.setUser(user);
        post.setLikes(null);
        postRepository.save(post);

        return postConverter.convertTo(post);

    }

    public PostDto updatePost(Long id, PostUpdateRequest postUpdateRequest) {

        User user = userService.getUserByUserName(AuthUtil.handleRequest());

        Post post = postRepository.findById(id).orElseThrow(()->
                new ApiRequestException("There is a problem when catching post by ("+id+") id!!!"));

        if(!Objects.equals(user.getId(), post.getUser().getId())){
            throw new ApiRequestException("You have not authorization to do that process.");
        }

        post.setText(postUpdateRequest.getContext());
        postRepository.save(post);
        return postConverter.convertTo(post);

    }

    public String deletePostById(Long id) {
        User user = userService.getUserByUserName(AuthUtil.handleRequest());

        Post post = postRepository.findById(id).orElseThrow(()->
                new ApiRequestException("There is a problem when catching post by ("+id+") id!!!"));

        if(!Objects.equals(user.getId(), post.getUser().getId())){
            throw new ApiRequestException("You have not authorization to do that process.");
        }
        postRepository.deleteById(id);

        return "Post has been deleted.";
    }


}
