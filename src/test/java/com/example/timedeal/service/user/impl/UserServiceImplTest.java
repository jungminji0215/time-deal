package com.example.timedeal.service.user.impl;

import com.example.timedeal.domain.user.User;
import com.example.timedeal.domain.user.UserRepository;
import com.example.timedeal.dto.user.request.CreateUserRequest;
import com.example.timedeal.enumeration.UserType;
import com.example.timedeal.service.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void clear(){
        userRepository.deleteAll();
    }

    @Test
    void 회원_가입_확인() {
        // given
        String name = "정민지";
        UserType userType = UserType.GENERAL;

        CreateUserRequest createUserRequest = new CreateUserRequest();

        createUserRequest.setName(name);
        createUserRequest.setType(userType);

        // when
        userService.join(createUserRequest);

        // then
        List<User> user = userRepository.findAll();

        assertThat(user).hasSize(1);
        assertThat(name).isEqualTo(user.get(0).getName());
        assertThat(userType).isEqualTo(user.get(0).getType());
    }
}