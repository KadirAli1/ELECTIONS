package com.elections.controller;

import com.elections.domain.Citizen;
import com.elections.domain.Party;
import com.elections.service.CitizenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/citizens")
public class CitizenController {
    private CitizenService citizenService;

    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping
    public ResponseEntity<List<Citizen>> getAllCitizens(){
        return ResponseEntity.ok(citizenService.getAllCitizens());
    }
}
