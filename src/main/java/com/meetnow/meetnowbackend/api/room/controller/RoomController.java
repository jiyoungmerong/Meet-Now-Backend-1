package com.meetnow.meetnowbackend.api.room.controller;


import com.meetnow.meetnowbackend.api.room.dto.NewRoomDto;
import com.meetnow.meetnowbackend.domain.room.Room;
import com.meetnow.meetnowbackend.domain.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    /**
     *  어떤 요청의 경우는 응답DTO만 필요하거나, DTO 생성 자체가 필요없을 수도 있다.
     *  DELETE 요청의 경우 url에 달린 식별자를 @PathVariable 로 받고 삭제시킨 다음
     *  아무것도 반환하지 않을 수도 있음.
     */

    @PostMapping("/rooms")
    public ResponseEntity<NewRoomDto.Response> createRoom(@RequestBody NewRoomDto.Request requestDto){
        // 1. 뭘 받아올지 -> requestDto

        // 2. 받아온걸로 뭘 할지
        Random random = new Random();
        String invitationCode = String.valueOf(random.nextInt(9999 - 1000 + 1) + 1000);

        Room room = Room.builder()
                .roomName(requestDto.getRoomName())
                .appointmentHour(requestDto.getAppointmentHour())
                .invitationCode(invitationCode)
                .startDate(requestDto.getStartDate())
                .endDate(requestDto.getEndDate())
                .build();

        Room savedRoom = roomService.save(room);
        // 3. 무엇을 반환(응답)할지
        NewRoomDto.Response result = new NewRoomDto.Response(savedRoom.getRoomName(), savedRoom.getInvitationCode());
        return ResponseEntity.ok(result);
    }
}






















