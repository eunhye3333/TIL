package com.example.userservice.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint { // 인증되지 않은 유저가 요청했을 경우 동작하는 부분

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException authException) throws IOException {

        log.error("Responding with unauthorized error. Message - {}", authException.getMessage());

        ErrorCode unAuthorizationCode = (ErrorCode) request.getAttribute("unauthorization.code");

        request.setAttribute("response.failure.code", unAuthorizationCode.name());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, unAuthorizationCode.getMessage());
    }
}
