package com.techchallengev2.app.controllers;

import com.techchallengev2.app.models.Status;
import com.techchallengev2.app.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public ResponseEntity<List<Status>> listarStatus() {
        return ResponseEntity.ok(statusService.findAll());
    }
}