package com.gridge.GridgeTest.config;

import com.gridge.GridgeTest.handler.oauth2.OAuth2AuthenticationFailureHandler;
import com.gridge.GridgeTest.handler.oauth2.OAuth2AuthenticationSuccessHandler;
import com.gridge.GridgeTest.repository.HttpCookieOAuth2AuthorizationRequestRepository;
import com.gridge.GridgeTest.sercurity.JwtExceptionFilter;
import com.gridge.GridgeTest.sercurity.TokenAuthenticationFilter;
import com.gridge.GridgeTest.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
    private final OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;
    private final JwtExceptionFilter jwtExceptionFilter;
    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic().disable()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS
                )
                .and()
                .cors().configurationSource(corsConfigurationSource())

                .and()
                .oauth2Login()
                .authorizationEndpoint()
                .baseUri("/api/oauth2/authorize")
                .authorizationRequestRepository(cookieAuthorizationRequestRepository())
                .and()
                .redirectionEndpoint()
                .baseUri("/api/oauth2/callback/*")
                .and()
                .userInfoEndpoint()
                .userService(customOAuth2UserService)
                .and()
                .successHandler(oAuth2AuthenticationSuccessHandler)
                .failureHandler(oAuth2AuthenticationFailureHandler);

        httpSecurity.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        httpSecurity.addFilterBefore(jwtExceptionFilter, TokenAuthenticationFilter.class);
    }
    @Bean
    public HttpCookieOAuth2AuthorizationRequestRepository cookieAuthorizationRequestRepository() {
        return new HttpCookieOAuth2AuthorizationRequestRepository();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("http://localhost:8080");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }


    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("/v3/api-docs", "/swagger/**", "/swagger-ui.html", "/webjars/**", "/swagger-resources/**");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
