package com.fsa.ProLog.dto.request;

import com.fsa.ProLog.models.FactureColis;
import com.fsa.ProLog.models.FactureVehicule;
import com.fsa.ProLog.models.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class UserRequestDto {
    private String username;
    private String password;
    private String email;
    private String telephone;
    private Role role;
}
