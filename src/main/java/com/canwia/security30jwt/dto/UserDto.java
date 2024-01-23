package com.canwia.security30jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String id;

    private String nickName;

    private String name;

    private String surname;

    private String email;

    private String password;
}
