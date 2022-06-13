package com.example.userservice.controller;

import com.example.userservice.domain.User;
import com.example.userservice.security.JwtTokenProvider;
import com.example.userservice.security.Token;
import com.example.userservice.security.Token.Response;
import com.example.userservice.security.UserAuthentication;
import com.example.userservice.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(AuthRestController.URL_PREFIX)
public class AuthRestController {
    static final String URL_PREFIX = "/auth";
    static final String LOGIN = "/login";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @RequestMapping(
        value = LOGIN,
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> login(final HttpServletRequest req, final HttpServletResponse res,
        @Valid @RequestBody Token.Request request) throws Exception{

        User user = userService.findByIdPw(request.getId()).orElseThrow(() -> new IllegalArgumentException("없는 사용자입니다."));

        if(!request.getSecret().equals(user.getUserPwd())){
            throw new IllegalArgumentException("비밀번호를 확인하세요.");
        }

        //Authentication authentication = new UserAuthentication(request.getId(), null, null);
        //String token = JwtTokenProvider.generateToken(authentication);

//        Response response = Response.builder().token(token).build();
//
//        return okResponse(response);

        return null;
    }
}
