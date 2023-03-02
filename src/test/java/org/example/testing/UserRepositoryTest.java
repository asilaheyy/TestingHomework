package org.example.testing;

import org.example.exceptions.UserNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


public class UserRepositoryTest {

    UserRepository userRepository = new UserRepository();

    User user1 = new User("user1", "user1@", "1234");


    @Test
    @DisplayName("When there are users in repository, repository returns users list.")
    public void getAllUsersTest() {
        if (userRepository != null) {
            userRepository.getAllUsers().stream().toList();
        } else {
            throw new UserNotFoundException("Список пользователей пуст.");
        }
    }


    // Выдает No tests were found
    @Test
    @DisplayName("When there are no users in repository then repository returns empty list.")
    public Collection<User> EmptyRepositoryTest() {
        if (userRepository == null || userRepository.getAllUsers().isEmpty()) {
            return Collections.emptyList();
        } else {
            return userRepository.getAllUsers().stream().toList();
        }
    }


    // Выдает No tests were found
    @Test
    @DisplayName("When there is username that matches given user name in repository, then repository returns user.")
    public Optional<User> userSearchByNameTest(String givenUserName) {
        return userRepository.getAllUsers().stream()
                .filter(u -> u.getUserName().equals(givenUserName))
                .findFirst();
    }


    // Выдает No tests were found
    @Test
    @DisplayName("When there is not username found  that matches given user name in repository, then repository returns false.")
    public boolean userSearchByNameWhenUserNotFoundTest(String givenUserName) {
        if (userRepository.getAllUsers().stream().noneMatch(givenUserName :: equals)) {
            return true;
        } else {
            return false;
        }

    }
}
