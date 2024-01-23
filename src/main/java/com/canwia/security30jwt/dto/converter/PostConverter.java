package com.canwia.security30jwt.dto.converter;

import com.canwia.security30jwt.dto.PostDto;
import com.canwia.security30jwt.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostConverter {

    public PostDto convertTo (Post post){
        PostDto postDto = new PostDto();

        postDto.setId(post.getId());
        postDto.setContext(post.getText());
        postDto.setLike(post.getLikes());
        postDto.setUserId(post.getUser().getId());
        postDto.setUserName(post.getUser().getName());
        postDto.setNickName(post.getUser().getNickName());

        return postDto;
    }


    public List<PostDto> convertListTo(List<Post> postList){
        return postList.stream().map(this::convertTo).collect(Collectors.toList());
    }
}
