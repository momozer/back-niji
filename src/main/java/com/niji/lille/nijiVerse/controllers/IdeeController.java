package com.niji.lille.nijiVerse.controllers;

import com.niji.lille.nijiVerse.services.IdeeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/idees")
@CrossOrigin
public class IdeeController {

    private final IdeeService service;

    public IdeeController(IdeeService service) {
        this.service = service;
    }
}
