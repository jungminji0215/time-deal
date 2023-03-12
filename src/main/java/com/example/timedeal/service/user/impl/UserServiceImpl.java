package com.example.timedeal.service.user.impl;

import com.example.timedeal.domain.user.User;
import com.example.timedeal.domain.user.UserRepository;
import com.example.timedeal.dto.user.request.CreateUserRequest;
import com.example.timedeal.dto.user.request.UpdateUserRequest;
import com.example.timedeal.dto.user.response.CreateUserResponse;
import com.example.timedeal.dto.user.response.DeleteUserResponse;
import com.example.timedeal.dto.user.response.UpdateUserResponse;
import com.example.timedeal.dto.user.response.UserResponse;
import com.example.timedeal.service.user.UserService;
import com.example.timedeal.utils.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public ResponseResult list() {
        List<User> findUser = userRepository.findAll();
        List<UserResponse> result = findUser.stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
        return new ResponseResult(result);
    }

    @Override
    public ResponseResult findOne(Long userId) {
        return new ResponseResult(userRepository.findById(userId));
    }

    @Override
    @Transactional
    public CreateUserResponse join(CreateUserRequest request) {
        User user = request.toEntity();
        return userRepository.save(user).toCreateResponse();
    }

    @Override
    @Transactional
    public UpdateUserResponse update(Long userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("유저를 찾을 수 없습니다. id:" + userId));
        user.update(request);

        // 변경된 것다시 조회해서 리턴
        return userRepository.findById(userId).get().toUpdateResponse();
    }

    @Override
    @Transactional
    public DeleteUserResponse delete(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("유저를 찾을 수 없습니다. id:" + userId));
        user.delete();
        return userRepository.findById(userId).get().toDeleteResponse();
    }
}
