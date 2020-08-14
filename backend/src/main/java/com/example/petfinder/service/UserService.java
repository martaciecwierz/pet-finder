package com.example.petfinder.service;

import com.example.petfinder.dto.user.UserDto;
import com.example.petfinder.error.exception.notFound.EmailNotFoundException;
import com.example.petfinder.error.exception.notFound.UserNotFoundException;
import com.example.petfinder.error.exception.unauthorized.InvalidPasswordException;
import com.example.petfinder.model.user.User;
import com.example.petfinder.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(readOnly = true)
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserDto updateProfile(UserDto userDto){
        UserDto dto = findUserById(userDto.getId());
        dto.setFirstName(userDto.getFirstName());
        dto.setLastName(userDto.getLastName());
        dto.setEmail(userDto.getEmail());

        User user = modelMapper.map(dto, User.class);
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Transactional
    public void changePassword(Long userId, String newPassword, String oldPassword) {
        UserDto userDto = findUserById(userId);

        if (!passwordEncoder.matches(userDto.getPassword(), passwordEncoder.encode(oldPassword))) {
            throw new InvalidPasswordException();
        }
        userDto.setPassword(passwordEncoder.encode(newPassword));
        User user = modelMapper.map(userDto, User.class);

        userRepository.save(user);
    }

    @Transactional
    public void deactivateUserProfile(Long userId) {
        UserDto userDto = findUserById(userId);
        if (!userDto.isActive())
            throw new UserNotFoundException(userId);
        userDto.setActive(false);
        userRepository.save(modelMapper.map(userDto, User.class));
    }

    public List<UserDto> findAllUsers() {
        List<User> users = StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public List<UserDto> findByFirstNameOrLastNameContaining(String firstName, String lastName) {
        List<User> users = userRepository.findByFirstNameContainsOrLastNameContainsAndActive_True(firstName, lastName);
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto findUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException(email));
        return modelMapper.map(user, UserDto.class);
    }

    public UserDto findUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        return modelMapper.map(user, UserDto.class);
    }


}
