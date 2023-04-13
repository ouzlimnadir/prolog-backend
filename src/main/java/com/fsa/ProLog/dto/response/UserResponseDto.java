package com.fsa.ProLog.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsa.ProLog.models.Role;
import lombok.Data;

@Data
public class UserResponseDto {
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String telephone;
    private Role role;
}
