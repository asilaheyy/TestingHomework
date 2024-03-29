package org.example.testing;

import org.example.exceptions.UserNonUniqueException;
import org.example.exceptions.UserNotFoundException;

import java.util.Collection;
import java.util.List;

public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String userName, String email, String passw) {
        if (userName == null || userName.isBlank()
                || email == null || email.isBlank()
                || passw == null || passw.isBlank()) {

            throw new IllegalArgumentException("Заполните все поля.");
        }
        User user = new User(userName, email, passw);
        boolean userExists = this.userRepository
                .getAllUsers()
                .stream()
                .anyMatch(u -> u.equals(user));

        if (userExists) {
            throw new UserNonUniqueException("User already exists");
        }
        this.userRepository.addUser(user);
    }

    public List<User> getAllUserNames(){
        try {
            Collection<User> users = this.userRepository.getAllUsers();
            if (users.isEmpty()){
                return users.stream().toList();
            }
            return users
                    .stream()
                    .toList();
        } catch (RuntimeException e){
            return null;
        }
    }

    public int getAllUsersCount(){
        try{
            Collection<User> users = this.userRepository.getAllUsers();
            if (users == null){
                return 0;
            }
            return (int) users
                    .stream()
                    .count();
        } catch (UserNotFoundException e){
            return 0;
        }
    }

}
