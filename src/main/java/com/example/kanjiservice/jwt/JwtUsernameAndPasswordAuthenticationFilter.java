package com.example.kanjiservice.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final String key;
    private final int days;

    public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager, String key, int days) {
        this.authenticationManager = authenticationManager;
        this.key = key;
        this.days = days;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

        try {
            UsernameAndPasswordAuthenticationRequest authenticationRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), UsernameAndPasswordAuthenticationRequest.class);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), //this is the principle
                    authenticationRequest.getPassword() //this is the credential
            );
            Authentication authenticate = authenticationManager.authenticate(authentication);
            return authenticate;
            //checks if username exist and password is correct, and if so this request is authenticated
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //this sends back the token after successful auth
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        //JwtKey jwt = BeanUtil.getBean(JwtKey.class);

        String token = Jwts.builder()
                .setSubject(authResult.getName()) //gets username
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(days)))
                .signWith(Keys.hmacShaKeyFor(key.getBytes()))
                .compact();

        PrintWriter out = response.getWriter();
        response.setContentType(APPLICATION_JSON_VALUE);
        //response.setCharacterEncoding("UTF-8");
        out.print(token);
        response.addHeader("Authorization", token);
    }
}
