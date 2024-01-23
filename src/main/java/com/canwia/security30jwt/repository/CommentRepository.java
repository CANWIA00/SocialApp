package com.canwia.security30jwt.repository;

import com.canwia.security30jwt.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query(value = "SELECT * FROM comments WHERE post_id",nativeQuery = true)
    Optional<List<Comment>> findByPostId(Long post_id);
}
