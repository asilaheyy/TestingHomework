package org.example.testing;

import java.util.*;

public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public User addUser(User user) {
        this.users.add(user);
        return user;
    }


    public Collection<User> getAllUsers() {
        return Collections.unmodifiableCollection(users);

    }

    public void addNewUser(User newUser) {
        users.add(new User(newUser.getUserName(), newUser.getUserEMail(), newUser.getUserPassw()));
    }

    public Optional<User> getUserByUserName(String givenUserName) {
        return users.stream()
                .filter(u -> u.getUserName().equals(givenUserName))
                .findFirst();
    }


    public Optional<User> getUserByNameAndPassw(String givenUserName, String givenPassw) {
        return users.stream()
                .filter(u -> u.getUserName().equals(givenUserName) &&
                        u.getUserPassw().equals(givenPassw))
                .findFirst();


    }
}


