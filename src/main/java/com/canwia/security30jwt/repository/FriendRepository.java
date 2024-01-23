package com.canwia.security30jwt.repository;

import com.canwia.security30jwt.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Long> {

    @Query(value = "SELECT * FROM friends WHERE user_id",nativeQuery = true)
    Optional<List<Friend>> findAllByUserId(String id);
    @Query(value = "SELECT * FROM friends WHERE friend_id",nativeQuery = true)
    Optional<Friend> findByFriendId(String id);
}
