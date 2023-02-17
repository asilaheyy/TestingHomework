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

    public Optional<User> getUserByUserName(String givenUserName) {
        boolean userExists = users
                .stream().anyMatch(u -> u.equals(givenUserName));
        if (userExists) {




    public Optional<User> getUserByNameAndPassw(String givenUserName,String givenPassw) {
                userExists = users.stream().anyMatch(u -> u.equals(givenUserName))
                        & users.stream().anyMatch(u -> u.equals(givenPassw));
         //как вернуть Optional


    }
}

