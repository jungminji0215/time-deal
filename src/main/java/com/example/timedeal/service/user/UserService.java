package com.example.timedeal.service.user;

import com.example.timedeal.dto.user.request.CreateUserRequest;
import com.example.timedeal.dto.user.request.UpdateUserRequest;
import com.example.timedeal.dto.user.response.CreateUserResponse;
import com.example.timedeal.dto.user.response.DeleteUserResponse;
import com.example.timedeal.dto.user.response.UpdateUserResponse;
import com.example.timedeal.utils.ResponseResult;

public interface UserService {
    CreateUserResponse join(CreateUserRequest request);

    UpdateUserResponse update(Long userId, UpdateUserRequest request);

    DeleteUserResponse delete(Long userId);

    ResponseResult list();

    ResponseResult findOne(Long userId);
}
