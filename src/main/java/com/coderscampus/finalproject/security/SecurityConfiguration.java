package com.coderscampus.finalproject.security;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration{

	@Autowired
    private final UserDetailsService userDetailsService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public SecurityConfiguration () {
		this.userDetailsService = null;}

    public SecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    //.anyRequest().hasRole("USER")
//            )
        .authorizeHttpRequests(authorize -> authorize
        .requestMatchers("/odontologos/**", "/odontologoAlta/**", "/odontologosList/**", "/pacienteAlta/**", "/pacientesList/**" ).permitAll()
        //.anyRequest().authenticated()
        .anyRequest().hasRole("USER")
        
    )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")
                    .defaultSuccessUrl("/index")
                    .permitAll()
                    
            );
            //.csrf().disable();
        
        return http.build();
    }

    //public PasswordEncoder passwordEncoder() {
    //    return new BCryptPasswordEncoder();
    //}
    
    
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }
}
