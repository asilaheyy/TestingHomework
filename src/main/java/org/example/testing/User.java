package org.example.testing;

import org.example.exceptions.EmailException;
import org.example.exceptions.PasswordException;
import org.example.exceptions.UserNameException;

import java.util.Objects;

public class User {
    private final String userName;
    private final String userEMail;
    private final String userPassw;




    public User(String userName, String userEMail, String userPassw) {
        userNameNotNull(userName);
        emailNotNull(userEMail);
        correctEmail(userEMail);
        emailAndPasswDontMatch(userEMail,userPassw);
        this.userName = userName;
        this.userEMail = userEMail;
        this.userPassw = userPassw;

    }

    public User(){
    this.userName = "UserName";
    this.userEMail = "Email";
    this.userPassw = "Password";

    }



    public void userNameNotNull(String passedUserName) {
        if (passedUserName == null || passedUserName.isBlank()) {
            throw new UserNameException("Empty username");
        }
    }

    public void emailNotNull(String passedUserEMail) {
        if (passedUserEMail == null || passedUserEMail.isBlank()) {
            throw new EmailException("Empty email");
        }
    }

    public void correctEmail(String passedEmail) {
        if (!passedEmail.contains("@")) {
            throw new EmailException("Email should contain '@'");
        }
    }

    public void emailAndPasswDontMatch(String passedEmail, String passedPassw) {
        if (passedEmail.equals(passedPassw)) {
            throw new PasswordException("Password should not match email");
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassw() {
        return userPassw;
    }

    public String getUserEMail() {
        return userEMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(userEMail, user.userEMail) && Objects.equals(userPassw, user.userPassw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userEMail, userPassw);
    }
}
