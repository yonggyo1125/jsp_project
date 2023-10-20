package models.member;

import commons.Validator;
import jakarta.servlet.http.HttpServletRequest;

public class LoginService {

    private Validator<HttpServletRequest> validator;

    public LoginService(Validator<HttpServletRequest> validator) {
        this.validator = validator;
    }

    public void login(HttpServletRequest request) {

        validator.check(request);

    }
}
