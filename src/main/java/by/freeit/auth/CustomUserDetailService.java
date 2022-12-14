package by.freeit.auth;

//import by.freeit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

//@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private JdbcTemplate template;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = template.queryForObject("select * from users where username=?", User.class, User.class, username);
//        List<String> auth = template.queryForList("select authority from authorities where username = ?", String.class, username);
//        user.setRoles(new HashSet<>(auth));
        return new MyCustomUser();
    }
}
