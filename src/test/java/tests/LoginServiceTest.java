package tests;

import jakarta.servlet.http.HttpServletRequest;
import models.member.JoinService;
import models.member.LoginService;
import models.member.Member;
import models.member.ServiceManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@DisplayName("로그인 기능 단위 테스트")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
public class LoginServiceTest {

    private LoginService loginService;

    @Mock
    private HttpServletRequest request;

    private Member member;

    @BeforeEach
    void init() {
        loginService = new LoginService();

        member = getMember();
        JoinService joinService = ServiceManager.getInstance().joinService();
        joinService.join(member);
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

    private void createRequestData(String userId, String userPw) {
        given(request.getParameter("userId")).willReturn(userId);
        given(request.getParameter("userPw")).willReturn(userPw);
    }

    @Test
    @DisplayName("로그인 성공시 예외가 발생하지 않음")
    void loginSuccess() {
        createRequestData(member.getUserId(), member.getUserPw());
        assertDoesNotThrow(() -> {
            loginService.login(request);
        });
    }
    
    @Test
    @DisplayName("필수 항목 검증(아이디, 비밀번호), 검증 실패시 BadRequestException 발생")
    void requiredFieldCheck() {
        
    }
}
