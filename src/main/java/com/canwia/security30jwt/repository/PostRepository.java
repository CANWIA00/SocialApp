package com.canwia.security30jwt.repository;

import com.canwia.security30jwt.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    Optional<List<Post>> findPostByUserId(String id);
}
