package org.example.testing;

import org.example.exceptions.EmailException;
import org.example.exceptions.PasswordException;
import org.example.exceptions.UserNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {


    @Test
    @DisplayName("When passed username is null, then username exception is thrown.")
    public void NameNotNullTest() {
        assertThrows(UserNameException.class, () -> new User("", "asila@gmail.com", "1234"));

    }

    @Test
    @DisplayName("When passed userName to no argument constructor is null, then username exception is thrown.")
    public void noArgsConstructorUserNameTest() {
        var user = new User();
        assertThrows(UserNameException.class, () -> user.userNameNotNull(String.valueOf(new User(null, null, null))));
    }

    @Test
    @DisplayName("When passed email to no argument constructor is null, then email exception is thrown.")
    public void noArgsConstructorEmailTest() {
        var user = new User();
        assertThrows(EmailException.class, () -> user.emailNotNull(String.valueOf(new User("A", null, null))));
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
