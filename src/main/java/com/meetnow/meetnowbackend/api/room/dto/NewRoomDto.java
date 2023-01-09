package com.meetnow.meetnowbackend.api.room.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class NewRoomDto {

    @NoArgsConstructor
    @Getter
    public static class Request{

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private String roomName;
        private Short appointmentHour;

        // StartDate와 endDate는 해당 방에서 잡을 수 있는 약속시간의 범위
        private String startDate;
        private String endDate;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Response{
        private String roomName;
        private String invitationCode;
    }


}
