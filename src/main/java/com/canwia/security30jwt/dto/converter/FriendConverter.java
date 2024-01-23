package com.canwia.security30jwt.dto.converter;

import com.canwia.security30jwt.dto.FriendDto;
import com.canwia.security30jwt.model.Friend;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FriendConverter {


    public FriendDto convertFrom(Friend friend){

        FriendDto friendDto = new FriendDto();

       friendDto.setId(friend.getId());
       friendDto.setName(friend.getFriend().getName());
       friendDto.setSurname(friend.getFriend().getSurname());
       friendDto.setMail(friend.getFriend().getEmail());
       friendDto.setNickName(friend.getFriend().getNickName());


        return friendDto;
    }

    public List<FriendDto> convertFrom(List<Friend> friends){
        return friends.stream().map(this::convertFrom).collect(Collectors.toList());
    }
}
