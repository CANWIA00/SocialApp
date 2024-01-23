package com.canwia.security30jwt.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    private String nickName;

    private String name;

    private String surname;

    private String email;

    private String password;
}
