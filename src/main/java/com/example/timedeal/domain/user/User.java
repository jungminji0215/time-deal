package com.example.timedeal.domain.user;

import com.example.timedeal.domain.order.Order;
import com.example.timedeal.dto.user.request.UpdateUserRequest;
import com.example.timedeal.dto.user.response.CreateUserResponse;
import com.example.timedeal.dto.user.response.DeleteUserResponse;
import com.example.timedeal.dto.user.response.UpdateUserResponse;
import com.example.timedeal.enumeration.UserType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @ColumnDefault("false")
    private boolean quit;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public User(Long id, String name, UserType type, boolean quit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quit = quit;
    }

    public CreateUserResponse toCreateResponse() {
        return CreateUserResponse.builder()
                .id(id)
                .name(name)
                .type(type)
                .quit(quit)
                .build();
    }

    public UpdateUserResponse toUpdateResponse() {
        return UpdateUserResponse.builder()
                .id(id)
                .name(name)
                .type(type)
                .quit(quit)
                .build();
    }

    public void update(UpdateUserRequest request) {
        this.name = request.getName();
        this.type = request.getType();
    }

    public void delete() {
        this.quit = true;
    }

    public DeleteUserResponse toDeleteResponse() {
        return DeleteUserResponse.builder()
                .id(id)
                .quit(quit)
                .build();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
