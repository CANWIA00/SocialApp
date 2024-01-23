package com.canwia.security30jwt.dto;

import com.canwia.security30jwt.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Long id;

    private String context;

    private BigInteger like;

    private String userId;

    private String userName;

    private String nickName;
}
