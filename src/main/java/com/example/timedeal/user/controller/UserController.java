package com.example.timedeal.user.controller;

import com.example.timedeal.user.dto.request.CreateUserRequest;
import com.example.timedeal.user.dto.request.UpdateUserRequest;
import com.example.timedeal.user.dto.response.CreateUserResponse;
import com.example.timedeal.user.dto.response.DeleteUserResponse;
import com.example.timedeal.user.dto.response.GetUserResponse;
import com.example.timedeal.user.dto.response.UpdateUserResponse;
import com.example.timedeal.user.service.UserService;
import com.example.timedeal.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ApiResponse<List<GetUserResponse>> list(){
        return ApiResponse.success(userService.list());
    }

    @GetMapping("/{userId}")
    public ApiResponse<GetUserResponse> findOne(
            @PathVariable Long userId
    ){
        return ApiResponse.success(userService.findOne(userId));
    }

    @PostMapping
    public ApiResponse<CreateUserResponse> join(
            @RequestBody CreateUserRequest request
    ){
        return ApiResponse.success(userService.join(request));
    }

    @PutMapping("/{userId}")
    private ApiResponse<UpdateUserResponse> updateUser(
            @PathVariable Long userId,
            @RequestBody UpdateUserRequest request
    ){
        return ApiResponse.success(userService.update(userId, request));
    }

    @DeleteMapping("/{userId}")
    public ApiResponse<DeleteUserResponse> deleteUser(
            @PathVariable Long userId
    ){
        return ApiResponse.success(userService.delete(userId));
    }
}
