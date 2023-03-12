package com.example.timedeal.controller;

import com.example.timedeal.dto.user.request.CreateUserRequest;
import com.example.timedeal.dto.user.request.UpdateUserRequest;
import com.example.timedeal.dto.user.response.CreateUserResponse;
import com.example.timedeal.dto.user.response.DeleteUserResponse;
import com.example.timedeal.dto.user.response.UpdateUserResponse;
import com.example.timedeal.service.user.UserService;
import com.example.timedeal.utils.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user")
    public ResponseResult list(){
        return userService.list();
    }

    @GetMapping("/user/{userId}")
    public ResponseResult findOne(
            @PathVariable Long userId
    ){
        return userService.findOne(userId);
    }

    @PostMapping("/user")
    public CreateUserResponse createUser(@RequestBody  CreateUserRequest request){
        return userService.join(request);
    }

    @PutMapping("/user/{userId}")
    private UpdateUserResponse updateUser(
            @PathVariable Long userId,
            @RequestBody UpdateUserRequest request
    ){
        return userService.update(userId, request);
    }

    @DeleteMapping("/user/{userId}")
    public DeleteUserResponse deleteUser(@PathVariable Long userId){
        return userService.delete(userId);
    }
}
