package com.example.petfinder.service.common;

import com.example.petfinder.dto.user.UserDto;
import com.example.petfinder.error.exception.conflict.EmailConflictException;
import com.example.petfinder.error.exception.conflict.UsernameConflictException;
import com.example.petfinder.error.exception.validation.EmailValidationException;
import com.example.petfinder.error.exception.validation.FirstNameValidationException;
import com.example.petfinder.error.exception.validation.LastNameValidationException;
import com.example.petfinder.error.exception.validation.PasswordIValidationException;
import com.example.petfinder.model.user.User;
import com.example.petfinder.repository.UserRepository;
import com.example.petfinder.validation.UserValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrationService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserDto userDto){
        validateRegister(userDto);
        userDto.setActive(true);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
    }

    private void validateRegister(UserDto userDto){

        if(userRepository.existsByUsername(userDto.getUsername())){
            throw new UsernameConflictException(userDto.getUsername());
        }

        if(userRepository.existsByEmail(userDto.getEmail())){
            throw new EmailConflictException(userDto.getEmail());
        }

        if (!UserValidator.isPasswordValid(userDto.getPassword())) {
            throw new PasswordIValidationException(userDto.getPassword().length());
        }

        if (!UserValidator.isFirstNameValid(userDto.getFirstName())) {
            throw new FirstNameValidationException(userDto.getFirstName());
        }

        if (!UserValidator.isLastNameValid(userDto.getLastName())) {
            throw new LastNameValidationException(userDto.getLastName());
        }

        if (!UserValidator.isEmailValid(userDto.getEmail())) {
            throw new EmailValidationException(userDto.getEmail());
        }

    }
}
