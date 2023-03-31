package com.example.timedeal.user.domain;

import com.example.timedeal.user.dto.request.CreateUserRequest;
import com.example.timedeal.user.dto.request.UpdateUserRequest;
import com.example.timedeal.user.enumeration.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @ColumnDefault("false")
    private boolean quit;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

    // soft delete
    private LocalDateTime deletedAt;

    @PrePersist
    void registeredAt(){
        this.registeredAt = LocalDateTime.now();
    }

    public static User of(CreateUserRequest request){
        return User.builder()
                .name(request.getName())
                .password(request.getPassword())
                .type(request.getType())
                .build();
    }

    public void update(UpdateUserRequest request) {
        this.name = request.getName();
        this.password = request.getPassword();
        this.type = request.getType();
        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.quit = true;
        this.deletedAt = LocalDateTime.now();
    }
}
