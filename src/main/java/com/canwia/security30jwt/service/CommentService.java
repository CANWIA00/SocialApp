package com.canwia.security30jwt.service;

import com.canwia.security30jwt.config.security.AuthUtil;
import com.canwia.security30jwt.dto.CommentDto;
import com.canwia.security30jwt.dto.converter.CommentConverter;
import com.canwia.security30jwt.dto.request.CommentCreateRequest;
import com.canwia.security30jwt.dto.request.CommentUpdateRequest;
import com.canwia.security30jwt.exception.ApiRequestException;
import com.canwia.security30jwt.model.Comment;
import com.canwia.security30jwt.model.Post;
import com.canwia.security30jwt.model.User;
import com.canwia.security30jwt.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final PostService postService;
    private final UserService userService;

    private final CommentConverter commentConverter;

    private final CommentRepository commentRepository;

    public CommentService(PostService postService, UserService userService, CommentConverter commentConverter, CommentRepository commentRepository) {
        this.postService = postService;
        this.userService = userService;
        this.commentConverter = commentConverter;
        this.commentRepository = commentRepository;
    }


    public CommentDto createComment(CommentCreateRequest commentCreateRequest) {

        User user = userService.getUserByUserName(AuthUtil.handleRequest());

        Post post = postService.getPost(commentCreateRequest.getPostId());

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPost(post);
        comment.setContext(commentCreateRequest.getContext());

        commentRepository.save(comment);

        return commentConverter.convertFrom(comment);
    }

    public List<CommentDto> getAllComment(Long id) {

        List<Comment> comments = commentRepository.findByPostId(id)
                .orElseThrow(()->new ApiRequestException("There is no any comment by postId " + id + "{commentService error}!!!!"));

        return commentConverter.commentFrom(comments);
    }

    public CommentDto getCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(()->new ApiRequestException("There is no any comment by commentId " + id + "{commentService error}!!!!"));
        return  commentConverter.convertFrom(comment);
    }


    public CommentDto updateComment(Long id, CommentUpdateRequest commentUpdateRequest) {

        Comment comment = commentRepository.findById(id)
                .orElseThrow(()->new ApiRequestException("There is no any comment by commentId " + id + "{commentService error}!!!!"));

        comment.setContext(commentUpdateRequest.getContext());
        commentRepository.save(comment);
        return commentConverter.convertFrom(comment);
    }

    public String deleteComment(Long id) {
        User user = userService.getUserFromToken();
        Comment comment = commentRepository.findById(id)
                .orElseThrow(()->new ApiRequestException("There is no any comment by commentId " + id + "{commentService error}!!!!"));

        if(user != comment.getUser()){
            throw new ApiRequestException("You don't have to delete permission. Because you are not owner of this comment");
        }

        commentRepository.deleteById(id);
        return "Comment has been deleted successfully!!";
    }
}
