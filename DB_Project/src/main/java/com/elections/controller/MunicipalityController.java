package com.elections.controller;


import com.elections.domain.Municipality;
import com.elections.domain.Party;
import com.elections.service.MunicipalityService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/municipalities")
public class MunicipalityController {
    private MunicipalityService municipalityService;

    public MunicipalityController(MunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }
    @GetMapping
    public ResponseEntity<List<Municipality>> getAllMunicipalities(){
        return ResponseEntity.ok(municipalityService.getAllMunicipalities());
    }
}
