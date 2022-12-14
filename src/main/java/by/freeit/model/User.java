package by.freeit.model;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private String userName;
    private String password;
    private Boolean enabled;
    private Set<String> roles;

    public User(String userName, String password, Boolean enabled) {
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
    }
}
