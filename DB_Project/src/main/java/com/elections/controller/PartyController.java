package com.elections.controller;

import com.elections.domain.Election;
import com.elections.domain.Party;
import com.elections.service.PartyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Part;
import java.util.List;

@RestController
@RequestMapping("/parties")
public class PartyController {
    private PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping
    public ResponseEntity<List<Party>> getAllParties(){
        return ResponseEntity.ok(partyService.getAllParties());
    }
}
