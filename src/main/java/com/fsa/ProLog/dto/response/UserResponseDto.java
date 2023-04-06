package com.fsa.ProLog.dto.response;

import com.fsa.ProLog.models.Role;
import lombok.Data;

@Data
public class UserResponseDto {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String telephone;
    private Role role;
}
