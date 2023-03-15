package com.example.timedeal.dto.order.response;

import com.example.timedeal.dto.user.response.UserResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class OrderProductResponse {
    private Long id;

    private List<UserResponse> userResponseList = new ArrayList<>();
}
