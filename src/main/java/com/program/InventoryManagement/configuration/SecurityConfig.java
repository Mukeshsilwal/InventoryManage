package com.program.InventoryManagement.configuration;
import com.program.InventoryManagement.entity.Permission1;
import com.program.InventoryManagement.entity.Roles;
import com.program.InventoryManagement.security.CustomUserDetailsService;
import com.program.InventoryManagement.security.JwtAuthenticationFilter;
import com.program.InventoryManagement.security.JwtEntryPoint1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtEntryPoint1 jwtEntryPoint;
    private final UserDetailsService userDetailsService;


    public SecurityConfig(@Lazy JwtAuthenticationFilter jwtAuthenticationFilter, JwtEntryPoint1 jwtEntryPoint, UserDetailsService userDetailsService) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.jwtEntryPoint = jwtEntryPoint;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/csv/**","/csv1/**","/auth/login").permitAll()
                .antMatchers("/api3/**").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/api3/user/{uId}","/api3/","/api3/{id}").hasAuthority("USER")
                .antMatchers("/api4/**").hasAuthority("ADMIN")
                .antMatchers("/api4/{id}","/api4/","/api4//user/{uId}/supplier/{supplierId}/").hasAuthority("USER")
                .antMatchers("/role/**").hasAuthority("ADMIN")
                .antMatchers("/auth/create_user").permitAll()
                .antMatchers("/api1/**").hasAuthority("ADMIN")
                .antMatchers("/permission/**").hasAuthority("ADMIN")
                .antMatchers("/api2/**").hasAuthority("USER")
                .anyRequest()
                .authenticated()
                .and()
                .authenticationProvider(daoAuthenticationProvider())
                .exceptionHandling(ex->ex.authenticationEntryPoint(jwtEntryPoint))
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){

        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
   @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
   }





}
