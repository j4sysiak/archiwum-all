package com.example.demo;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepo;
import com.example.demo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsServiceImpl;
    private AppUserRepo appUserRepo;

    @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, AppUserRepo appUserRepo) {
        this.userDetailsServiceImpl = userDetailsService;
        this.appUserRepo = appUserRepo;
    }

    //zarządzanie dostępami z poziomu bazy danych
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //użytkownik pobieany z pamięci
//        auth.inMemoryAuthentication().withUser(
//                new User("xxx", passwordEncoder().encode("xxx"), Collections.singleton(new SimpleGrantedAuthority("user"))));

        //użytkownik pobierany z bazy danych
        auth.userDetailsService(userDetailsServiceImpl);
    }

    //zarządzanie dostępami z poziomu http
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test1").hasRole("USER")
                .antMatchers("/test2").hasRole("ADMIN")
                .antMatchers("/upload").hasRole("ADMIN")
                .antMatchers("/galery").hasRole("USER")
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable()  // cross side request foreign - zabezpieczenie springa, zęby nie łączył się z zewnętrznego hosta
                .httpBasic();   // dostęp przez Postmana
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // to się odpali zawsze na początku - taki trigger
    // zapisuje użytkownika nowego do bazy
    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        appUserRepo.save(AppUser.builder()
                .username("uuu")
                .password(passwordEncoder().encode("uuu"))
                .role("ROLE_USER")
                .build());

        appUserRepo.save(AppUser.builder()
                .username("aaa")
                .password(passwordEncoder().encode("aaa"))
                .role("ROLE_ADMIN")
                .build());
    }
}
