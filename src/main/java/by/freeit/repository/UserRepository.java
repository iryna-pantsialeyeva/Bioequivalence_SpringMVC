package by.freeit.repository;

import by.freeit.model.User;

public interface UserRepository {
    User loadUserByName(String username);
}
