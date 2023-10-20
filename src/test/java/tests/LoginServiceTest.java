package tests;

import jakarta.servlet.http.HttpServletRequest;
import models.member.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로그인 기능 단위 테스트")
public class LoginServiceTest {

    private LoginService loginService;
    private HttpServletRequest request;

    @BeforeEach
    void init() {
        loginService = new LoginService();
    }
    
    @Test
    @DisplayName("로그인 성공시 예외가 발생하지 않음")
    void loginSuccess() {
        assertDoesNotThrow(() -> {
            loginService.login(request);
        });
    }
}
