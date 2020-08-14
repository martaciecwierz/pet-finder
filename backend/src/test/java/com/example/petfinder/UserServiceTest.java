package com.example.petfinder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.example.petfinder.dto.user.UserDto;
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

}
