package com.canwia.security30jwt.controller;

import com.canwia.security30jwt.auth.AuthenticationResponse;
import com.canwia.security30jwt.dto.UserDto;
import com.canwia.security30jwt.dto.request.UserUpdateRequest;
import com.canwia.security30jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<UserDto> getUser(){
        return ResponseEntity.ok(userService.getUserDtoFromToken());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
/*
    @PutMapping("/user")
    public ResponseEntity<AuthenticationResponse> updateUser(@RequestBody UserUpdateRequest userUpdateRequest){

        return ResponseEntity.ok(userService.updateUser(userUpdateRequest));
    }

    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(){

        return ResponseEntity.ok(userService.deleteUser());
    }
    */

}
