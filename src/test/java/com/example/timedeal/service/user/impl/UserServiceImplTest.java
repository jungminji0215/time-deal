package com.example.timedeal.service.user.impl;

import com.example.timedeal.domain.user.User;
import com.example.timedeal.domain.user.UserRepository;
import com.example.timedeal.dto.user.request.CreateUserRequest;
import com.example.timedeal.enumeration.UserType;
import com.example.timedeal.exception.TimeDealException;
import com.example.timedeal.service.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    // TODO 테스트코드의 중복을 어떻게 줄일수 있을까

    /*
    @Test
    void 회원가입_성공적으로_동작() {
        // given
        String name = "정민지";
        String password = "0215";

        CreateUserRequest request = new CreateUserRequest();
        request.setName(name);
        request.setPassword(password);
        request.setType(UserType.USER);


        when(userRepository.findByName(name)).thenReturn(Optional.empty());
        when(userRepository.save(any())).thenReturn(Optional.of(mock(User.class)));

        // when
        // then
        Assertions.assertDoesNotThrow(() -> userService.join(request));
    }

    @Test
    void 회원가입시_아이디가_중복되는_경우_ERROR_반환() {
        // given
        String name = "정민지";
        String password = "0215";

        CreateUserRequest request = new CreateUserRequest();
        request.setName(name);
        request.setPassword(password);
        request.setType(UserType.USER);


        when(userRepository.findByName(name)).thenReturn(Optional.of(mock(User.class)));
        when(userRepository.save(any())).thenReturn(Optional.of(mock(User.class)));

        // when
        // then
        Assertions.assertThrows(TimeDealException.class, () -> userService.join(request));
    }

     */
}