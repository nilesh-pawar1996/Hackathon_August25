package com.sunbeam.dto;

import com.sunbeam.entities.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private UserRole role; // No password exposed
}