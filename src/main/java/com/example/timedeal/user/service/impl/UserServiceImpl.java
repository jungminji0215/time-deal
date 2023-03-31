package com.example.timedeal.user.service.impl;

import com.example.timedeal.user.domain.User;
import com.example.timedeal.user.domain.UserRepository;
import com.example.timedeal.user.dto.request.CreateUserRequest;
import com.example.timedeal.user.dto.request.UpdateUserRequest;
import com.example.timedeal.user.dto.response.CreateUserResponse;
import com.example.timedeal.user.dto.response.DeleteUserResponse;
import com.example.timedeal.user.dto.response.GetUserResponse;
import com.example.timedeal.user.dto.response.UpdateUserResponse;
import com.example.timedeal.utils.exception.ErrorCode;
import com.example.timedeal.utils.exception.TimeDealException;
import com.example.timedeal.user.service.UserService;
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
                .orElseThrow(()-> new TimeDealException(ErrorCode.USER_NOT_FOUNDED, "유저 아이디 : " + userId));

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
                .orElseThrow(()-> new TimeDealException(ErrorCode.USER_NOT_FOUNDED, "유저 아이디 : " + userId));
        user.update(request);

        return UpdateUserResponse.toUpdateResponse(user);
    }

    @Override
    @Transactional
    public DeleteUserResponse delete(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new TimeDealException(ErrorCode.USER_NOT_FOUNDED, "유저 아이디 : " + userId));
        user.delete();
        return DeleteUserResponse.toDeleteResponse(user);
    }
}
