### 0. 유저 생성  - 완료 // 토큰방식 전환 예정
- #### [POST] /users
- 요청 - 사용자는 이름 입력
- 응답 - JWT 토큰 반환
- 
### 1. 사용자가 속한 방의 리스트 조회 // 0번을 맨 마지막에 구현하므로, User 테이블의 PK를 보내도 괜찮을듯 
- #### [GET] /rooms/user/{id}
- 요청 - 사용자는 토큰을 Authorization 헤더에 담아 요청
- 응답 - 해당 토큰에 맞는 사용자가 속한 방의 리스트 전체 반환

### 2. 방 생성  - 완료
- #### [POST] /rooms
- 요청 - 약속에 대한 정보를 받는다. 
- 서버 - 정보를 DB에 저장한다.
- 응답 - (6번째 그림에 보이는) 약속 이름, 초대코드

### 3.  시간표 등록 - 호지영
- #### [POST] /rooms/{초대코드}/timetables
- 요청 - 어떤 요일, 몇시부터 몇시까지 가능한지 (의 리스트)를 0번에서 발급받은 토큰과 함께 보냄
    // 지금 토큰 방식이 아니니까 사용자를 구분 다른 요소(username, id(PK))
    초대코드로 방을, 토큰이나 다른 값으로 사용자를 식별 가능

- 응답 - 반환타입 void

1. UserService.findByXXX()로 user 찾아오기
2. RoomService.findByInvitationCode() 로 Room 찾아오기
3. Timetable.builder().user().room().build(). 로 TimeTable 객체 생성
4. TimetableService.save(3번에서 만든 TimeTable 객체)
5. AppointmentDate 객체 생성에 필요한 데이터를 @RequestBody 뭐시기DTO.Request로 받아옴
6. AppointmentDate.builder().date().appoStart().appoEnd()
   .timeTable(4번에서 생성된 TimeTable).build() 로 객체 생성
7. AppointmentService.save(6번에서 만든 객체)
8. 끝 ! 저장만 하고 반환하지 않는다.

### 4. 해당 방의 시간표 모두 조회
- #### [GET] /rooms/{초대코드}/timetables
- 요청 - 방의 초대코드 보내기
- 응답 - 해당 방의 전체 사용자의 시간표 모두 보내주기
- #### 방에 처음 입장할 때, 새로고침 버튼을 누를 때 사용됨

- Room을 조회할 경우 연관된 Timetables와 appointmentDate 함께 조회됨







1. 요청으로 어떤 값들을 받아올지 (요청 DTO)

2. 어떤 작업을 할지

3. 받아서 어떻게 응답할지 (응답 DTO)

### 0. 유저 생성  - 먼저
- #### [POST] /users
- 요청 - 사용자는 이름 입력
- 응답 - //JWT 토큰 반환(X) 기본키 반환






















