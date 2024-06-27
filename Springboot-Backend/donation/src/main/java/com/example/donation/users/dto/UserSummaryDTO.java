package com.example.donation.users.dto;

import com.example.donation.users.dao.entities.User;

import lombok.Builder;

@Builder
public record UserSummaryDTO(
        Long id,
        String firstname) {
            public static UserSummaryDTO toUserSummaryDTO(User user) {
                UserSummaryDTO userSummaryDTO = UserSummaryDTO.builder()
                        .id(user.getId())
                        .firstname(user.getFirstname()).build();
                return userSummaryDTO;
    }
}
