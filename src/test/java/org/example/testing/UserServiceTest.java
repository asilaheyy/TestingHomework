package org.example.testing;


import org.example.exceptions.UserNonUniqueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("When users in repository then count should be calculated correctly.")
    void correctUsersCalculationTest() {
        when(userRepository.getAllUsers()).thenReturn(List.of(new User("user1", "aa@", "1234"), new User("user2", "bb@", "5678")));
        assertThat(userService.getAllUsersCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("When repository is empty then count should be zero.")
    void correctEmptyRepositoryUserCalculationTest() {
        when(userRepository.getAllUsers()).thenReturn(List.of());
        assertThat(userService.getAllUsersCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("When existing user is passed to the service then service throws exception.")
    void userAlreadyExistsTest() {
        when(userRepository.getAllUsers()).thenReturn(List.of(new User("u1", "AA4@", "1234")));
        assertThatThrownBy(() -> userService.addUser("u1", "AA4@", "1234"))
                .isInstanceOf(UserNonUniqueException.class)
                .hasMessage("User already exists");
    }

}
