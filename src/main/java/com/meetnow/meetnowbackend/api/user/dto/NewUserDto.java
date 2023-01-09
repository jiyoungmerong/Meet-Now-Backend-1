package com.meetnow.meetnowbackend.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class NewUserDto {

    // 요청
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Request{
        private String username;
    }

    // 응답
    @AllArgsConstructor
    @Getter
    public static class Response{
        private Long userId;
    }
}
