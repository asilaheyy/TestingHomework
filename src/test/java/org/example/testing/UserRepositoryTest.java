package org.example.testing;

import org.example.exceptions.UserNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNull;


public class UserRepositoryTest {

    UserRepository userRepository = new UserRepository();

    User user1 = new User("user1", "user1@", "1234");


    @Test
    @DisplayName("When there are users in repository, repository returns users list.")
    public void getAllUsersTest() {
        if (userRepository != null) {
            userRepository.addUser(user1);
            Assertions.assertIterableEquals(userRepository.getAllUsers(), List.of(user1));
        } else {
            throw new UserNotFoundException("Список пользователей пуст.");
        }
    }


    @Test
    @DisplayName("When there are no users in repository then repository returns empty list.")
    public void emptyRepoTest() {
        if (userRepository == null) {
            Assertions.assertIterableEquals(userRepository.getAllUsers(), List.of(null));
        } else {
            userRepository.getAllUsers().stream().toList();
        }
    }


    // Выдает No tests were found
    @Test
    @DisplayName("When there is username that matches given user name in repository, then repository returns user.")
    public void userSearchByNameTest() {
        String givenUserName;
        String actualResult = userRepository.getUserByUserName(givenUserName);
        Assertions.assertEquals(userRepository, actualResult);

    }


    // Выдает No tests were found
    @Test
    @DisplayName("When there is not username found  that matches given user name in repository, then repository returns false.")
    public void userSearchByNameWhenUserNotFoundTest(String givenUserName) {
        if (userRepository.getAllUsers().stream().noneMatch(givenUserName)) {
            throw new UserNotFoundException("");
        } else {


        }
    }
}
