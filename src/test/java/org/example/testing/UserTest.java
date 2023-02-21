package org.example.testing;

import org.example.exceptions.EmailException;
import org.example.exceptions.PasswordException;
import org.example.exceptions.UserNameException;
import org.example.exceptions.UserNonUniqueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    private User user = new User();


    @Test
    @DisplayName("When passed username is null, then username exception is thrown.")
    public void NameNotNullTest() {
        assertThrows(UserNameException.class, () -> new User("","asila@gmail.com", "1234"));

    }

    @Test
    @DisplayName("When passed userName to no argument constructor is null, then username exception is thrown.")
    public void noArgsConstructorUserNameTest(){
        assertThrows(UserNameException.class, () -> new User("","",""));
    }

    @Test
    @DisplayName("When passed email to no argument constructor is null, then email exception is thrown.")
    public void noArgsConstructorEmailTest(){
        assertThrows(EmailException.class, () -> new User("asilaheyy", "", ""));
    }

    @Test
    @DisplayName("When passed password and email to the no argument constructor match, password exception is thrown.")
    public void noargsConstructorPasswordAndEmailDontMatchTest(){
        assertThrows(PasswordException.class, () -> new User("asilaheyy", "asilaheyy@gmail.com", "asilaheyy@gmail.com"));
    }

    @Test
    @DisplayName("When passed email is null, then email exception is thrown.")
    public void emailNotNullTest() {
        assertThrows(EmailException.class, () -> new User("asilaheyy", "", "1234"));
    }

    @Test
    @DisplayName("When there's  not correct email with '@' symbol passed to the user,then email exception is thrown.")
    public void correctEmailTest() {
        assertThrows(EmailException.class, () -> new User("asilaheyy", "asila.gmail.com", "1234"));
    }

    @Test
    @DisplayName("When passed password matches email, password exception is thrown.")
    public void passwAndEmailDontMatchTest() {
        assertThrows(PasswordException.class, () -> new User("asilaheyy", "asilaheyy@gmail.com", "asilaheyy@gmail.com"));
    }

}
