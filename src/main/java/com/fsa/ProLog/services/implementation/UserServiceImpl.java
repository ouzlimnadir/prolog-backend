package com.fsa.ProLog.services.implementation;

import com.fsa.ProLog.dao.UserDao;
import com.fsa.ProLog.dto.request.UserRequestDto;
import com.fsa.ProLog.dto.response.UserResponseDto;
import com.fsa.ProLog.models.User;
import com.fsa.ProLog.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private ModelMapper modelMapper;

    // GET methods
    @Override
    public List<UserResponseDto> findAll() {
        return userDao.findAll()
                .stream().map(el->modelMapper.map(el,UserResponseDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public UserResponseDto findById(Integer id) {
        User user = userDao.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        return modelMapper.map(user,UserResponseDto.class);
    }
    @Override
    public UserResponseDto findByUsername(String username) {
        User user = userDao.findByUsername(username);
        return modelMapper.map(user, UserResponseDto.class);
    }
    @Override
    public UserResponseDto findByEmail(String email) {
        User user = userDao.findByUsername(email);
        return modelMapper.map(user, UserResponseDto.class);
    }

    // POST methods
    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        User user = modelMapper.map(userRequestDto,User.class);
        User saved = userDao.save(user);
        return modelMapper.map(saved,UserResponseDto.class);
    }

    // PUT methods
    @Override
    public UserResponseDto update(UserRequestDto userRequestDto, Integer id) {
        Optional<User> userOptional = userDao.findById(id);
        if(userOptional.isPresent()){
            User user = modelMapper.map(userRequestDto,User.class);
            user.setId(id);
            User updated = userDao.save(user);
            return modelMapper.map(updated,UserResponseDto.class);
        } else {
            throw new RuntimeException("UserNotFound");
        }
    }

    // DELETE methods
    @Override
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

}
