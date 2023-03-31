package com.example.timedeal.user.service;

import com.example.timedeal.user.dto.request.CreateUserRequest;
import com.example.timedeal.user.dto.request.UpdateUserRequest;
import com.example.timedeal.user.dto.response.CreateUserResponse;
import com.example.timedeal.user.dto.response.DeleteUserResponse;
import com.example.timedeal.user.dto.response.GetUserResponse;
import com.example.timedeal.user.dto.response.UpdateUserResponse;

import java.util.List;

public interface UserService {
    List<GetUserResponse> list();

    GetUserResponse findOne(Long userId);

    CreateUserResponse join(CreateUserRequest request);

    UpdateUserResponse update(Long userId, UpdateUserRequest request);

    DeleteUserResponse delete(Long userId);


}
