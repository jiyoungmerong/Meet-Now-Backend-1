package com.meetnow.meetnowbackend.api.user.controller;

import com.meetnow.meetnowbackend.api.user.dto.NewUserDto;
import com.meetnow.meetnowbackend.domain.user.User;
import com.meetnow.meetnowbackend.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // userId : 1
    @PostMapping("/users")
    public ResponseEntity<NewUserDto.Response> createUser(@RequestBody NewUserDto.Request requestDto){

        // 저장할 user
        User user = User.builder()
                .username(requestDto.getUsername())
                .build();

        // DB에 저장된 후에 다시 조회해온 User
        User savedUser = userService.save(user);

        // Todo 토큰 반환으로 변경
        NewUserDto.Response result = new NewUserDto.Response(savedUser.getId());
        return ResponseEntity.ok(result);
    }
}















