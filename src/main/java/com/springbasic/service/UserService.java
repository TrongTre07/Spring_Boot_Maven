package com.springbasic.service;

import com.springbasic.entity.Response;
import com.springbasic.entity.User;
import com.springbasic.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDto> getUsers();

//    public List<UserDto> getUsersWithDb();

    public UserDto getUserById(int id);

    public List<UserDto> searchUser(String keyword);

    public Response login(String username, String password);

    public Response register(String username, String password, String phone, String email);

    public Response deleteUser(int id);

    public Response editUser(int id, User user);
}
