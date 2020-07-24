package com.example.petfinder.service;

import com.example.petfinder.dto.user.UserDto;
import com.example.petfinder.error.exception.notFound.UserNotFoundException;
import com.example.petfinder.error.exception.unauthorized.InvalidPasswordException;
import com.example.petfinder.model.user.User;
import com.example.petfinder.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if(!oldPassword.equals(userDto.getPassword())){
            throw new InvalidPasswordException();
        }
        userDto.setPassword(passwordEncoder.encode(newPassword));
        User user = modelMapper.map(userDto, User.class);

        userRepository.save(user);
    }

    private UserDto findUserById(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        return modelMapper.map(user, UserDto.class);
    }


}
