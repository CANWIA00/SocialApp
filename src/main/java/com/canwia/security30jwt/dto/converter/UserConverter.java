package com.canwia.security30jwt.dto.converter;

import com.canwia.security30jwt.dto.UserDto;
import com.canwia.security30jwt.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    public UserDto convertFrom(User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setNickName(user.getNickName());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return  userDto;
    }

    public List<UserDto> convertListFrom(List<User> userList){
        return userList.stream().map(this::convertFrom).collect(Collectors.toList());
    }
}
