package com.fsa.ProLog.faker;

import com.fsa.ProLog.dao.UserDao;
import com.fsa.ProLog.dto.request.UserRequestDto;
import com.fsa.ProLog.models.Role;
import com.fsa.ProLog.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFaker {
    UserDao userDao;
    public void creatUser(String fullname, String email, String password, String telephone, Role role) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);

        ModelMapper modelMapper = new ModelMapper();
        password = hashedPassword;

        UserRequestDto userRequestDto;
        User user;

        userRequestDto = new UserRequestDto(fullname,password, email, telephone, role);
        user = modelMapper.map(userRequestDto, User.class);
        userDao.save(user);
    }
}
