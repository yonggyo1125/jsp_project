package models.member;

import commons.BadRequestException;

public class JoinService {
    public void join(Member member) {

        String userId = member.getUserId();
        if (userId == null || userId.isBlank()) {
            throw new BadRequestException("아이디를 입력하세요.");
        }
    }
}
