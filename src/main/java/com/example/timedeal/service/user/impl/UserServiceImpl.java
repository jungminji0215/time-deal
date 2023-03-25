package com.example.timedeal.service.user.impl;

import com.example.timedeal.domain.user.User;
import com.example.timedeal.domain.user.UserRepository;
import com.example.timedeal.dto.user.request.CreateUserRequest;
import com.example.timedeal.dto.user.request.UpdateUserRequest;
import com.example.timedeal.dto.user.response.CreateUserResponse;
import com.example.timedeal.dto.user.response.DeleteUserResponse;
import com.example.timedeal.dto.user.response.UpdateUserResponse;
import com.example.timedeal.dto.user.response.GetUserResponse;
import com.example.timedeal.exception.ErrorCode;
import com.example.timedeal.exception.TimeDealException;
import com.example.timedeal.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    // TODO 페이징
    @Override
    @Transactional(readOnly = true)
    public List<GetUserResponse> list() {
        List<User> findUser = userRepository.findAll();
        List<GetUserResponse> result = findUser.stream()
                .map(GetUserResponse::toGetResponse)
                .collect(Collectors.toList());
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public GetUserResponse findOne(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new TimeDealException(ErrorCode.NOT_EXISTS_USER, "존재하지 않는 유저입니다"));

        return GetUserResponse.toGetResponse(user);
    }

    @Override
    @Transactional
    public CreateUserResponse join(CreateUserRequest request) {
        userRepository.findByName(request.getName()).ifPresent(it -> {
            throw new TimeDealException(ErrorCode.DUPLICATED_USER_NAME, "중복된 아이디 : " + request.getName());
        });

        return CreateUserResponse.toCreateResponse(userRepository.save(User.of(request)));
    }

    @Override
    @Transactional
    public UpdateUserResponse update(Long userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new TimeDealException(ErrorCode.NOT_EXISTS_USER, "존재하지 않는 유저입니다"));
        user.update(request);

        return UpdateUserResponse.toUpdateResponse(user);
    }

    @Override
    @Transactional
    public DeleteUserResponse delete(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new TimeDealException(ErrorCode.NOT_EXISTS_USER, "존재하지 않는 유저입니다"));
        user.delete();
        return DeleteUserResponse.toDeleteResponse(user);
    }
}
