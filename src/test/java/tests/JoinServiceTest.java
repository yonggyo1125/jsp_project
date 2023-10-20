package tests;

import commons.BadRequestException;
import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("회원가입 기능 단위테스트")
public class JoinServiceTest {

    private JoinService joinService;

    @BeforeEach
    void init() {
        joinService = ServiceManager.getInstance().joinService();
    }

    private Member getMember() {
        String userPw = "12345678";
        return Member.builder()
                .userId("user" + System.currentTimeMillis())
                .userPw(userPw)
                .confirmUserPw(userPw)
                .userNm("사용자")
                .email("user@test.org")
                .agree(true)
                .build();
    }

    @Test
    @DisplayName("회원가입 성공시 예외발생하지 않음")
    void joinSuccess() {
        assertDoesNotThrow(() -> {
            joinService.join(getMember());
        });
    }

    @Test
    @DisplayName("필수 항목 검증(아이디, 비밀번호, 비밀번호 확인, 회원명, 이메일, 회원가입약관 동의), 검증 실패시 BadRequestException 발생")
    void requiredFieldCheck() {
        // 아이디(userId)가 null 또는 빈값("")
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            Member member = getMember();

            member.setUserId(null);
            joinService.join(member);

            member.setUserId("   ");
            joinService.join(member);
        });

        String message = thrown.getMessage();
        //assertEquals("아이디를 입력하세요.", message);
        assertTrue(message.contains("아이디"));

        // 비밀번호(userPw)가 null 또는 빈값("")
        assertThrows(BadRequestException.class, () -> {
            Member member = getMember();

            member.setUserPw(null);
            joinService.join(member);

            member.setUserId("   ");
            joinService.join(member);
        });
    }

    private void requiredFieldEachCheck(Member member, String word) {
        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            joinService.join(member);
        });
        assertTrue(thrown.getMessage().contains(word));
    }
}
