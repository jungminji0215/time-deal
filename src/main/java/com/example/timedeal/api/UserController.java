package com.example.timedeal.api;

import com.example.timedeal.dto.user.request.CreateUserRequest;
import com.example.timedeal.dto.user.request.UpdateUserRequest;
import com.example.timedeal.dto.user.response.DeleteUserResponse;
import com.example.timedeal.service.user.UserService;
import com.example.timedeal.utils.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseResult<?> list(){
        return new ResponseResult<>(userService.list());
    }

    @GetMapping("/users/{userId}")
    public ResponseResult<?> findOne(
            @PathVariable Long userId
    ){
        return new ResponseResult<>(userService.findOne(userId));
    }

    @PostMapping("/users")
    public ResponseResult<?>  createUser(@RequestBody  CreateUserRequest request){
        return new ResponseResult<>(userService.join(request));
    }

    @PutMapping("/users/{userId}")
    private ResponseResult<?>  updateUser(
            @PathVariable Long userId,
            @RequestBody UpdateUserRequest request
    ){
        return new ResponseResult<>(userService.update(userId, request));
    }

    @DeleteMapping("/users/{userId}")
    public DeleteUserResponse deleteUser(@PathVariable Long userId){
        return userService.delete(userId);
    }

}
