package com.canwia.security30jwt.service;

import com.canwia.security30jwt.config.security.AuthUtil;
import com.canwia.security30jwt.config.security.JwtService;
import com.canwia.security30jwt.dto.UserDto;
import com.canwia.security30jwt.dto.converter.UserConverter;
import com.canwia.security30jwt.exception.ApiRequestException;
import com.canwia.security30jwt.model.User;
import com.canwia.security30jwt.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserConverter userConverter, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserByUserName(String username){
        return userRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User can not found exception!"));
    }

    public UserDto getUserDtoFromToken() {
        User user = getUserByUserName(AuthUtil.handleRequest());
        return userConverter.convertFrom(user);
    }

    public UserDto getUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(()->new ApiRequestException("User can not found with id " + id +" !!"));
        return userConverter.convertFrom(user);
    }

    /* //TODO
    public AuthenticationResponse updateUser(UserUpdateRequest userUpdateRequest) {
        User user = getUserByUserName(AuthUtil.handleRequest());

        user.setName(userUpdateRequest.getName());
        user.setSurname(userUpdateRequest.getSurname());
        user.setNickName(user.getNickName());
        user.setEmail(user.getEmail());
        user.setPassword(passwordEncoder.encode(userUpdateRequest.getPassword()));

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }


    public String deleteUser() {
        User user = getUserByUserName(AuthUtil.handleRequest());

        userRepository.deleteById(user.getId());

        return "User has been deleted!";
    }
    */


    public User getUser(String id){
        return userRepository.findById(id).orElseThrow(()->new ApiRequestException("User can not found with id " + id +" !!"));
    }

    public User getUserFromToken(){
        return getUserByUserName(AuthUtil.handleRequest());
    }


}
