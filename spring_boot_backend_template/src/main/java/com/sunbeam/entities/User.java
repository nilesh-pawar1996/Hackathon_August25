package com.sunbeam.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "secure_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password", callSuper = true)
public class User extends BaseEntity {

    @Column(length = 20)
    private String firstName;

    @Column(length = 20)
    private String lastName;

    @Column(length = 30, unique = true)
    private String email;

    @Column(length = 300, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private UserRole role;
}
