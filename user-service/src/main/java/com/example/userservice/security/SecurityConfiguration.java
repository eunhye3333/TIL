package com.example.userservice.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors() // 교차 출처 리소스 공유 설정
        .and()
            .httpBasic() // 스프링 시큐리티에서 기본적으로 제공하는 로그인 화면 사용
        .and()
            .csrf() // 사이트 간 요청 위조 설정
            .disable()
            .exceptionHandling() // 인증, 허가 에러 시 공통으로 처리하는 부분
            .authenticationEntryPoint(jwtAuthenticationEntryPoint)
        .and()
            .sessionManagement() // JWT를 쓰려면 스프링 시큐리티에서 기본적으로 지원하는 session 설정을 해제해야 함
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .authorizeRequests() // 요청에 따른 권한 체크 설정 부분으로 /auth/** 경로로 들어오는 부분은 인증이 필요없음
            .antMatchers(RestControllerBase.API_URI_PREFIX + "/auth/**")
            .permitAll()
            .antMatchers(RestControllerBase.API_URI_PREFIX + "/**")
            .authenticated()
        .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .formLogin().disable().headers().frameOptions().disable();

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
