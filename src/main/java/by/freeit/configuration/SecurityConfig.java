package by.freeit.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends AbstractSecurityWebApplicationInitializer {

    // Spring provided beans
    //    @Bean
//    public UserDetailsService users(){
//                 UserDetails admin = User.builder()
//                .username("admin")
//                .password("$2a$10$16LRcu7p7D6VRyNOXMcYIOlOXpVHbfOPTlCatuYwqbBoPsfg2Q20O")
//                .roles("ADMIN", "USER")
//                .build();
//        UserDetails user = User.builder()
//                .username("user")
//                .password("$2a$10$bRZV/NV/U6jhIPMholXGpesOZgyRHNmEdgUUeGU/N16XZMM7iZL2S")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
//    }
//
//    @Bean
//    DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(H2)
//                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//                .build();
//    }

//    @Autowired
//    private CustomAuthenticationProvider authenticationProvider;

    @Bean
    public UserDetailsManager users(@Autowired DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }


//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new CustomUserDetailService();
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authenticationProvider(authenticationProvider);
        return httpSecurity.authorizeHttpRequests(configure -> {
                    try {
                        configure
                                .requestMatchers("/").hasAnyAuthority("ADMIN", "USER")
                                .requestMatchers("/addPatient/**").hasAuthority("ADMIN")
                                .anyRequest().authenticated()
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
