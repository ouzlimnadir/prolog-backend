package com.fsa.ProLog.dto.request;

import com.fsa.ProLog.models.Role;
import lombok.Data;

@Data
public class UserRequestDto {
    private String username;
    private String password;
    private String email;
    private String telephone;
    private Role role;
}
