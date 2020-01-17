package com.elections.controller;

import com.elections.domain.Party;
import com.elections.domain.Vote;
import com.elections.repository.VoteRepository;
import com.elections.service.VoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {
    private VoteService  voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    public ResponseEntity<List<Vote>> getAllVotes(){
        return ResponseEntity.ok(voteService.getAllVotes());
    }

    @GetMapping("/females")
    public ResponseEntity<List<Vote>> getAllFemalesVotes(){
        return ResponseEntity.ok(voteService.getAllFemalesVotes());
    }

    @GetMapping("/males")
    public ResponseEntity<List<Vote>> getAllMaleVotes(){
        return ResponseEntity.ok(voteService.getAllMaleVotes());
    }

    @GetMapping("/constituency/{zone}")
    public ResponseEntity<List<Vote>> getAllVotesFromConstituency(@PathVariable Integer zone){
        if(zone > 6){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(voteService.getAllVotesFromConstituency(zone));
    }
}

