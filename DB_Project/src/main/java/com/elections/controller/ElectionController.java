package com.elections.controller;

import com.elections.domain.Election;
import com.elections.service.ElectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/elections")
public class ElectionController {
    private ElectionService electionService;

    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }

    @GetMapping
    public ResponseEntity<List<Election>> getAllElections(){
        return ResponseEntity.ok(electionService.getAllElections());
    }
}
