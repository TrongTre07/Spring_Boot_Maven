package com.springbasic.controller;

import com.springbasic.entity.LoginBody;
import com.springbasic.entity.Response;
import com.springbasic.entity.User;
import com.springbasic.model.dto.UserDto;
import com.springbasic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getListUsers() {
        List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok(users);

    }

//    @GetMapping("/db")
//    public ResponseEntity<?> getListUsersWithDb() {
//        List<UserDto> users = userService.getUsersWithDb();
//        return ResponseEntity.ok(users);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser() {
        return null;
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(required = false, defaultValue = "") String keyword) {
        List<UserDto> result = userService.searchUser(keyword);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginBody loginBody) {
        Response res = userService.login(loginBody.getUsername(), loginBody.getPassword());
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        Response res = userService.deleteUser(id);
        return ResponseEntity.ok(res);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<?> editUser(@PathVariable int id, @RequestBody User user) {
        Response res = userService.editUser(id, user);
        return ResponseEntity.ok(res);
    }
}
