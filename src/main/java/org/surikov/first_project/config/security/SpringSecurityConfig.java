package org.surikov.first_project.config.security;

import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    static final String[] AUTH_WHITELIST = {
            "/",
            "/authorization/**",
            "/registration/**"
    };

    @Bean
    public SecurityFilterChain defaultUserSecurityFilterChain(HttpSecurity httpSecurity,
                                                              EmbeddedWebServerFactoryCustomizerAutoConfiguration.NettyWebServerFactoryCustomizerConfiguration
                                                                      nettyWebServerFactoryCustomizerConfiguration) throws Exception {

        httpSecurity.authorizeHttpRequests((requests) -> {
            requests.requestMatchers(AUTH_WHITELIST).permitAll()
                    .requestMatchers("/project/delete/**").hasRole("DESIGNER")
                    .requestMatchers("/project/update/**").hasRole("DESIGNER")
                    .requestMatchers("/personal/designer/**").hasRole("DESIGNER")
                    .requestMatchers("/personal/user/**").hasRole("USER")
                    .requestMatchers("/designer/**").hasAnyRole("USER","DESIGNER")
                    .requestMatchers("/like").hasAnyRole("USER","DESIGNER")
                    .requestMatchers("/create").hasRole("DESIGNER")
                    .requestMatchers("/comment/**").hasAnyRole("USER","DESIGNER");

        });

        httpSecurity
                .formLogin(login-> login
                .loginPage("/authorization")
                .failureForwardUrl("/authorization?error")
                        .defaultSuccessUrl("/",true)
                .usernameParameter("login")
                .passwordParameter("password")
                .permitAll());

        httpSecurity.logout(logout -> logout.logoutUrl("/logout").permitAll());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> {
            web.ignoring().requestMatchers("/css/**", "/images/**", "/js/**");
        };
    }

}
