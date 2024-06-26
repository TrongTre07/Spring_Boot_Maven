package com.springbasic.model.mapper;

import com.springbasic.entity.User;
import com.springbasic.model.dto.UserDto;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setEmail(user.getEmail());
        tmp.setPhone(user.getPhone());
        tmp.setAvt(user.getAvatar());

        return tmp;
    }
}
