package com.example.petfinder.service;

import com.example.petfinder.dto.request.RequestDto;
import com.example.petfinder.error.exception.notFound.RequestNotFoundException;
import com.example.petfinder.model.request.Request;
import com.example.petfinder.repository.RequestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RequestService {

    private RequestRepository requestRepository;
    private ModelMapper modelMapper;

    public RequestService(RequestRepository requestRepository, ModelMapper modelMapper) {
        this.requestRepository = requestRepository;
        this.modelMapper = modelMapper;
    }

    public RequestDto findRequestById(Long requestId) {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new RequestNotFoundException(requestId));
        return modelMapper.map(request, RequestDto.class);
    }
}
