package com.springbasic.service;

import com.springbasic.entity.Response;
import com.springbasic.entity.User;
import com.springbasic.exception.NotFoundException;
import com.springbasic.model.dto.UserDto;
import com.springbasic.model.mapper.UserMapper;
import com.springbasic.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Linda", "lind@gmail.com", "0333333", "https://fastly.picsum.photos/id/242/500/500.jpg?hmac=_2EOQqUaWWLne0zEhD6IGOXKoJ5E3ng4imXmM2-0_6Q", "123123"));
        users.add(new User(2, "Cam Lan", "lian@gmail.com", "0999999", "https://fastly.picsum.photos/id/842/500/500.jpg?hmac=qjrdT1pIwg8PHCOwzaQBGYZevZ0K-RbCFqS8wuRFfXg", "123123"));
        users.add(new User(3, "Hung", "lian@gmail.com", "0999999", "https://fastly.picsum.photos/id/242/500/500.jpg?hmac=_2EOQqUaWWLne0zEhD6IGOXKoJ5E3ng4imXmM2-0_6Q", "123123"));
        users.add(new User(4, "David", "lian@gmail.com", "0999999", "https://fastly.picsum.photos/id/29/500/500.jpg?hmac=SRJnJefAoI-8brNUEsgA-04cYCPJ_tnniPjIkFCwF5c", "123123"));
        users.add(new User(5, "Ngoo", "lian@gmail.com", "0999999", "https://fastly.picsum.photos/id/214/500/500.jpg?hmac=qr5jequsSH_22JUygvSKOowwlXMnrp5ZUz8_ioIcw9U", "123123"));
        users.add(new User(6, "Trang", "lian@gmail.com", "0999999", "https://fastly.picsum.photos/id/802/500/500.jpg?hmac=kf0imTLQW_VKLpMY-xvunI8aKnM_Kph9knma-8rl_GM", "123123"));
    }

//    private final UserRepository userRepository;
//
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public List<UserDto> getUsers() {
        List<UserDto> result = new ArrayList<>();
        for (User user : users) {
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

//    @Override
//    public List<UserDto> getUsersWithDb() {
//        List<User> users = userRepository.findAll();
//        List<UserDto> userDtos = new ArrayList<>();
//
//        for (User user : users) {
//            UserDto userDto = UserMapper.toUserDto(user);
//            userDtos.add(userDto);
//        }
//
//        return userDtos;
//    }

    @Override
    public UserDto getUserById(int id) {
        UserDto userDto = new UserDto();
        for (User user : users) {
            if (user.getId() == id) {
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("User not found");
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> result = new ArrayList<>();
        for (User user : users) {
            if (user.getName().contains(keyword)) {
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }

    @Override
    public Response login(String username, String password) {
        Response res = new Response();
        for (User user : users) {
            if (user.getName().equals(username)) {
                if (user.getPassword().equals(password)) {
                    res.setCode(200);
                    res.setMessage("Login success");
                    return res;
                } else {
                    res.setCode(400);
                    res.setMessage("Wrong password");
                    return res;
                }
            }
        }
        res.setCode(400);
        res.setMessage("User not found");
        return res;
    }

    @Override
    public Response register(String username, String password, String phone, String email) {
        Response res = new Response(200, "User added");
        users.add(new User(users.size() + 1, username, email, phone, "", password));
        return res;
    }

    @Override
    public Response deleteUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return new Response(200, "Delete successfully");
            }
        }
        return new Response(400, "User not found");
    }

    @Override
    public Response editUser(int id, User user) {
        for (User u : users) {
            if (u.getId() == id) {
                u.setName(user.getName());
                u.setEmail(user.getEmail());
                u.setPhone(user.getPhone());

                return new Response(200, "User updated");
            }
        }
        return new Response(400, "Update fail");
    }

}

