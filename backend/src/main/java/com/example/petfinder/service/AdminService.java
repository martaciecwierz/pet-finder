package com.example.petfinder.service;


import com.example.petfinder.dto.user.AdminDto;
import com.example.petfinder.error.exception.notFound.AdminNotFoundException;
import com.example.petfinder.model.user.Admin;
import com.example.petfinder.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AdminService {

    private AdminRepository adminRepository;
    private ModelMapper modelMapper;

    public AdminService(AdminRepository adminRepository, ModelMapper modelMapper) {
        this.adminRepository = adminRepository;
        this.modelMapper = modelMapper;
    }

    public AdminDto findAdminById(Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new AdminNotFoundException(adminId));
        return modelMapper.map(admin, AdminDto.class);
    }
}
