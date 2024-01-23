package com.canwia.security30jwt.service;

import com.canwia.security30jwt.config.security.AuthUtil;
import com.canwia.security30jwt.dto.FriendDto;
import com.canwia.security30jwt.dto.converter.FriendConverter;
import com.canwia.security30jwt.exception.ApiRequestException;
import com.canwia.security30jwt.model.Friend;
import com.canwia.security30jwt.model.User;
import com.canwia.security30jwt.repository.FriendRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    private final FriendRepository friendRepository;
    private final UserService userService;

    private final FriendConverter friendConverter;

    public FriendService(FriendRepository friendRepository, UserService userService, FriendConverter friendConverter) {
        this.friendRepository = friendRepository;
        this.userService = userService;
        this.friendConverter = friendConverter;
    }

    public FriendDto createFriendById(String id) {

        User user = userService.getUserFromToken();

        User userFriend = userService.getUser(id);

        if(userFriend!=null || user != null){
            Friend friend = new Friend();

            friend.setUser(user);
            friend.setFriend(userFriend);

            friendRepository.save(friend);

            return friendConverter.convertFrom(friend);
        }else{
            throw new ApiRequestException("There is a problem about create friend request!!!");
        }

    }


    public List<FriendDto> getAllFriend() {

        String userId = AuthUtil.handleRequest();

        List<Friend> friendList = friendRepository.findAllByUserId(userId).orElseThrow(()->new ApiRequestException("There is no friendList with " + userId + "id!!!{FriendService}"));

        return friendConverter.convertFrom(friendList);

    }

    public FriendDto getById(String id) {
        Friend friend = friendRepository.findByFriendId(id).orElseThrow(()->new ApiRequestException("There is no friend with "+id + "friend id !!! {friendService}"));
        return friendConverter.convertFrom(friend);
    }

    public String deleteFriendById(String id) {
        Friend friend = friendRepository.findByFriendId(id).orElseThrow(()->new ApiRequestException("There is no friend with "+id + "friend id !!! {friendService}"));
        friendRepository.deleteById(friend.getId());
        return "Friend has been deleted successfully!!";
    }
}
