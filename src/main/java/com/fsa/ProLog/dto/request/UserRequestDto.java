package com.fsa.ProLog.dto.request;

import com.fsa.ProLog.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String username;
    private String password;
    private String email;
    private String telephone;
    private Role role;
}
