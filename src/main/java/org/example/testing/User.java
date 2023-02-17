package org.example.testing;

import java.util.Objects;

public class User {
    private final String userName;
    private final String userEMail;
    private final String userPassw;

    public User(String userName, String userEMail, String userPassw) {
        this.userName = userName;
        this.userEMail = userEMail;
        this.userPassw = userPassw;
    }

    public String userNameNotNull(String passedUserName) {
        if (passedUserName == null || passedUserName.isBlank()) {
            passedUserName = "Anonymous";
        }
        return passedUserName;
    }

    public String emailNotNull(String passedUserEMail) {
        if (passedUserEMail == null || passedUserEMail.isBlank()) {
            passedUserEMail = "Empty email";
        }
        return passedUserEMail;
    }

    public String correctEmail(String passedEmail) {
        if (!passedEmail.contains("@")) {
            passedEmail = "Email should contain '@'";
        }
        return passedEmail;
    }

    public String emailAndPasswDontMatch(String passedEmail, String passedPassw) {
        if (passedEmail.equals(passedPassw)) {
            passedPassw = "Password should not match email";
        }
        return passedPassw;
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
