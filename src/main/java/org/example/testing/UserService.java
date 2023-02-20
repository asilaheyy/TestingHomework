package org.example.testing;

import org.example.exceptions.UserNonUniqueException;

public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String userName, String email, String passw) {
        if (userName == null || userName.isBlank()
                || email == null || email.isBlank()
                || passw == null || passw.isBlank()) {

            throw new IllegalArgumentException("Заполните все поля.");
        }
        User user = new User(userName, email, passw);
        boolean userExists = this.userRepository
                .getAllUsers()
                .stream()
                .anyMatch(u -> u.equals(user));

        if (userExists) {
            throw new UserNonUniqueException("Пользователь уже существует");
        }
        this.userRepository.addUser(user);
    }
}
