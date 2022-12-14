package by.freeit.auth;

import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.Assert;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.isInstanceOf(MyCustomUser.class, authentication, "Not appropriate authentication class provided: " +
                authentication.getClass());
        String username = authentication.getName();
        UsernamePasswordAuthenticationToken result = UsernamePasswordAuthenticationToken.authenticated(authentication.getPrincipal(),
                authentication.getCredentials(), (authentication.getAuthorities()));
        result.setDetails(authentication.getDetails());
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (MyCustomUser.class.isAssignableFrom(authentication));
    }
}
