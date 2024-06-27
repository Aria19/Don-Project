package com.example.donation.users.dto;

import com.example.donation.users.dao.enums.Role;
import com.example.donation.users.dao.entities.User;

import lombok.Builder;

@Builder
public record UserDTO(Long id,
        String firstname,
        String lastname,
        String email,
        String number,
        String password,
        Role role,
        String image) {
            public static UserDTO toUserDTO(User user) {
                UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .email(user.getEmail())
                    .number(user.getNumber())
                    .password(user.getPassword())
                    .role(user.getRole())
                    .image(user.getImage()).build();
                return userDTO;
            }
            public static User fromUserDTO(UserDTO userDTO) {
                User user = User.builder()
                    .id(userDTO.id)
                    .firstname(userDTO.firstname)
                    .lastname(userDTO.lastname)
                    .email(userDTO.email)
                    .number(userDTO.number)
                    .password(userDTO.password)
                    .role(userDTO.role)
                    .image(userDTO.image).build();
                return user;
            }
}
