package org.example.testing;

import org.example.exceptions.UserNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


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


    // Поиск по логину
    @Test
    @DisplayName("When there is username that matches given user name in repository, then repository returns user.")
    public void userSearchByNameTest() {
        userRepository.addUser(user1);
        User user1 = new User("user1", "user1@", "1234");
        Assertions.assertEquals(userRepository.getUserByUserName("user1"), Optional.of(user1));


/*  Предыдущая реализация
        String givenusername = "user1";
        if (userRepository.getAllUsers().contains(givenusername)) {
            userRepository.getUserByUserName(givenusername);
        }*/

    }

    //Поиск по логину и паролю
    @Test
    @DisplayName("When there is username and password in repository that matches given user, then repository returns user.")
    public void userSearchByNameAndPasswordTest() {
        userRepository.addUser(user1);
        User user1 = new User("user1", "user1@", "1234");
        Assertions.assertEquals(userRepository.getUserByNameAndPassw("user1", "1234"), Optional.of(user1));

     /* Предыдущая реализация
      String givenuserName = "user1";
        String givenPassword = "1234";
        if (userRepository.getAllUsers().contains(givenuserName) && userRepository.getAllUsers().contains(givenPassword)) {
            userRepository.getUserByNameAndPassw(givenuserName, givenPassword);
        }*/
    }


    // Поиск пользователя по логину в случае если такого нет.
    @Test
    @DisplayName("When there is not username found  that matches given user name in repository")
    public void userSearchByNameWhenUserNotFoundTest() {
        userRepository.addUser(user1);
        User user1 = new User("user1", "user1@", "1234");
        Assertions.assertNotEquals(userRepository.getUserByUserName("user"), Optional.of(user1));

       /* Предыдущая реализация
       String givenUserName = "user";
        Assertions.assertNotEquals(userRepository.getUserByUserName(givenUserName), userRepository.getAllUsers().contains(givenUserName));
*/
    }


    @Test
    @DisplayName("When there is not username and user password found in repo that matches given username and password.")
    public void userSearchByNameAndPasswordWhenUserNotFoundTest() {
        userRepository.addUser(user1);
        User user1 = new User("user2", "user1@", "123");
        Assertions.assertNotEquals(userRepository.getUserByNameAndPassw("user1", "1234"), Optional.of(user1));
    }

    @Test
    @DisplayName("When there's not any match with password but with username test")
    public void userSearchByNameAndPasswordWhenNameMatchesButPasswordNotTest() {
        userRepository.addUser(user1);
        User user1 = new User("user1", "user1@", "123");
        Assertions.assertNotEquals(userRepository.getUserByNameAndPassw("user1", "1234"), Optional.of(user1));

    }

    @Test
    @DisplayName("When there's not any match with username but with password test")
    public void userSearchByNameAndPasswordWhenPasswordMatchesButUsernameNotTest() {
        userRepository.addUser(user1);
        User user1 = new User("user1", "user1@", "123");
        Assertions.assertNotEquals(userRepository.getUserByNameAndPassw("user", "1234"), Optional.of(user1));


    }
}

