package org.example.testing;

public class User {
    private final String userName;
    private final String userEMail;
    private String userPassw;

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
}
