package com.example.petfinder.controller.api;


import com.example.petfinder.service.ActionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class ActionController {

    private ActionService actionService;

    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }
}
