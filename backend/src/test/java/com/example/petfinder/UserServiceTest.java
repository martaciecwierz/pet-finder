package com.example.petfinder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.example.petfinder.dto.user.UserDto;
import com.example.petfinder.error.exception.notFound.EmailNotFoundException;
import com.example.petfinder.error.exception.notFound.UserNotFoundException;
import com.example.petfinder.error.exception.unauthorized.InvalidPasswordException;
import com.example.petfinder.model.user.User;
import com.example.petfinder.repository.UserRepository;
import com.example.petfinder.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private UserService userService;

    private User user;
    private UserDto userDto;

    @Before
    public void setUp(){
        user = User.builder()
                .id(1L)
                .username("test_username")
                .email("test_email@gmail.com")
                .active(true)
                .build();
        userDto = UserDto.builder()
                .id(1L)
                .username("test_username")
                .email("test_email@gmail.com")
                .active(true)
                .build();

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(modelMapper.map(user, UserDto.class)).thenReturn(userDto);
    }

    @Test
    public void getUserByIdTest(){
        UserDto userDto = userService.findUserById(1L);

        assertEquals("test_username", userDto.getUsername());
    }

    @Test(expected = UserNotFoundException.class)
    public void userNotFoundTest() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        userService.findUserById(2L);
    }

    @Test
    public void findUserByEmailTest() {
        when(userRepository.findByEmail("test_email@gmail.com")).thenReturn(Optional.of(user));

        UserDto userDto = userService.findUserByEmail("test_email@gmail.com");

        assertEquals(1L, (long) userDto.getId());
        assertEquals("test_username", userDto.getUsername());
    }

    @Test(expected = EmailNotFoundException.class)
    public void emailNotFoundTest() {
        when(userRepository.findByEmail("fail_email@gmail.com")).thenReturn(Optional.empty());

        userService.findUserByEmail("fail_email@gmail.com");
    }

    @Test
    public void findAllUsersTest() {
        List<User> users = new ArrayList<>();
        User user2 = User.builder()
                .id(3L)
                .username("test_username2")
                .email("test_email2@gmail.com")
                .active(true)
                .build();
        users.add(user);
        users.add(user2);
        when(userRepository.findAll()).thenReturn(users);
        List<UserDto> userList = userService.findAllUsers();

        assertEquals(2, userList.size());
    }

    @Test(expected = UserNotFoundException.class)
    public void deactivateDeactivatedUserTest() {
        userDto.setActive(false);
        userService.deactivateUserProfile(1L);
    }


}
