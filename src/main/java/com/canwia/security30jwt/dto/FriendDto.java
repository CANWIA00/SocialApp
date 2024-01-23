package com.canwia.security30jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendDto {

    private Long id;

    private String name;

    private String surname;

    private String nickName;

    private String mail;


}
