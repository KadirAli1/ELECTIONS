package com.elections.controller;

import com.elections.domain.Constituency;
import com.elections.domain.Municipality;
import com.elections.service.ConstituencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/constituencies")
public class ConstituencyController {
    private ConstituencyService constituencyService;

    public ConstituencyController(ConstituencyService constituencyService) {
        this.constituencyService = constituencyService;
    }
    @GetMapping
    public ResponseEntity<List<Constituency>> getAllConstituencies(){
        return ResponseEntity.ok(constituencyService.getAllConstituencies());
    }
}
