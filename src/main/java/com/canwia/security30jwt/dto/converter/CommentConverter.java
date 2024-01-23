package com.canwia.security30jwt.dto.converter;

import com.canwia.security30jwt.dto.CommentDto;
import com.canwia.security30jwt.model.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentConverter {


    public CommentDto convertFrom(Comment comment){

        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setContext(comment.getContext());
        commentDto.setPostId(comment.getPost().getId());
        commentDto.setUserId(comment.getUser().getId());

        return commentDto;
    }

    public List<CommentDto> commentFrom(List<Comment> commentList){
        return commentList.stream().map(this::convertFrom).collect(Collectors.toList());
    }
}
