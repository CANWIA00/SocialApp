package com.canwia.security30jwt.controller;

import com.canwia.security30jwt.dto.FriendDto;
import com.canwia.security30jwt.service.FriendService;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class FriendController {


    private final FriendService friendService;


    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }



    @GetMapping("/friendList")
    public ResponseEntity<List<FriendDto>> getAllFriend(){
        return ResponseEntity.ok(friendService.getAllFriend());
    }


    @GetMapping("/friend/{id}")
    public ResponseEntity<FriendDto> getFriendById(String id){
        return ResponseEntity.ok(friendService.getById(id));
    }

    @PostMapping("/friend")
    public ResponseEntity<FriendDto> createFriendById(@RequestParam String id){
        return ResponseEntity.ok(friendService.createFriendById(id));
    }

    @DeleteMapping("/friend/{id}")
    public ResponseEntity<String> deleteFriendById(String id){

        return ResponseEntity.ok(friendService.deleteFriendById(id));
    }
}
