package com.example.petfinder.service;

import com.example.petfinder.dto.action.ActionDto;
import com.example.petfinder.error.exception.notFound.ActionNotFoundException;
import com.example.petfinder.model.action.Action;
import com.example.petfinder.repository.ActionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ActionService {

    private ActionRepository actionRepository;
    private ModelMapper modelMapper;

    public ActionService(ActionRepository actionRepository, ModelMapper modelMapper) {
        this.actionRepository = actionRepository;
        this.modelMapper = modelMapper;
    }

    public ActionDto findActionById(Long actionId) {
        Action action = actionRepository.findById(actionId)
                .orElseThrow(() -> new ActionNotFoundException(actionId));
        return modelMapper.map(action, ActionDto.class);
    }
}
