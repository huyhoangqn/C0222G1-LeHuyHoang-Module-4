package com.example.demo.config;


import com.example.demo.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    //Sử dụng thuật toán Bcrypt để mã hóa password.
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //Khi tạo mới tài khoản thì cần mã hóa mật khẩu trước khi lưu vào DB
//        String password = bCryptPasswordEncoder.encode("123");
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();


        http.authorizeRequests()
                .antMatchers("/employee/show", "/customer/show", "/contract/show", "/service/showAll")
                .access("hasRole('ROLE_USER')");

        http.authorizeRequests()
                .antMatchers("/employee/*", "/customer/*", "contract/*", "/service/*")
                .access("hasRole('ROLE_ADMIN')");

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/login/403");

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
                // Submit URL của trang login
                .loginProcessingUrl("/j_spring_security") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/home/")// đăng nhập thành công -> call 1 request /userInfo
                .failureUrl("/login?error=true")// đăng nhập thất bại -> /login?error = true
                .usernameParameter("username")//
                .passwordParameter("password")
                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login/logoutSuccessful/");

        // Cấu hình Remember Me.
        http.authorizeRequests().and() //
                .rememberMe()
                .userDetailsService(userDetailsService)//
                .tokenValiditySeconds(24 * 60 * 60);
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        return new InMemoryTokenRepositoryImpl();
    }

}