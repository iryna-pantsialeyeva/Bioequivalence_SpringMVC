package by.freeit.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends AbstractSecurityWebApplicationInitializer {

//    public void configure(@Autowired AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.inMemoryAuthentication()
//                .withUser("Alex")
//                .password("Winston")
//                .roles("ADMIN", "USER")
//                .and()
//                .withUser("Uu")
//                .password("Qat")
//                .roles("USER");
//    }
    @Bean
    public UserDetailsService getUsers(){
        UserDetails user1 = User.builder()
                .username("Alex")
                .password("{noop}Winston")
                .roles("ADMIN", "USER")
                .build();
        UserDetails user2 = User.builder()
                .username("Uu")
                .password("{noop}Qat")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(configure -> {
                    try {
                        configure
                                 .anyRequest()
                                 .authenticated()
                                        .and()
                                        .formLogin()
                                        .permitAll();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                 .build();
    }
}
