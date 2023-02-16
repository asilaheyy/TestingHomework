package org.example.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user = new User("asilaheyy", "asila@gmail.com", "1234");


    @Test
    @DisplayName("When name is passed to user, then user returns correct name.")
    public void NameNotNullTest() {
        String actualResult = user.userNameNotNull("asilaheyy");
        Assertions.assertNotNull(actualResult);
        assertEquals("asilaheyy", actualResult, "asilaheyy should be returned");

    }

    @Test
    @DisplayName("When email is passed to user, then user returns correct email.")
    public void emailNotNullTest() {
        String actualResult = user.emailNotNull("asila@gmail.com");
        Assertions.assertNotNull(actualResult);
        assertEquals("asila@gmail.com", actualResult, "asila@gmail.com should be returned");
    }

    @Test
    @DisplayName("When there's correct email with '@' symbol passed to the user,then user returns email.")
    public void correctEmailTest() {
        String actualResult = user.correctEmail("asila@gmail.com");
        Assertions.assertNotNull(actualResult);
        assertEquals("asila@gmail.com", actualResult, "asila@gmail.com should be returned");
    }

    @Test
    @DisplayName("When passed password doesnt match email, user returns password.")
    public void passwAndEmailDontMatchTest() {
        String actualResult = user.emailAndPasswDontMatch("asila@gmail.com", "1234");
        Assertions.assertNotNull(actualResult);
        assertEquals("1234", actualResult, "Password matches email. Change password. Should return 1234");
    }

}
