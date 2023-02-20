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
    private User user = new User("asilaheyy", "asila@gmail.com", "1234");


    @Test
    @DisplayName("When passed username is null, then username exception is thrown.")
    public void NameNotNullTest() {
        assertThrows(UserNameException.class, () -> user.userNameNotNull(""));

    }

    @Test
    @DisplayName("When passed email is null, then email exception is thrown.")
    public void emailNotNullTest() {
        assertThrows(EmailException.class, () -> user.emailNotNull(""));
    }

    @Test
    @DisplayName("When there's  not correct email with '@' symbol passed to the user,then email exception is thrown.")
    public void correctEmailTest() {
        assertThrows(EmailException.class, () -> user.correctEmail("asilagmail.com"));
    }

    @Test
    @DisplayName("When passed password doesnt match email, password exception is thrown.")
    public void passwAndEmailDontMatchTest() {
        assertThrows(PasswordException.class, () -> user.emailAndPasswDontMatch("1234", "1234"));
    }

}
