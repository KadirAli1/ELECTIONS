package com.elections.service;

import com.elections.domain.Election;
import com.elections.repository.ElectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionService {
    private ElectionRepository electionRepository;

    public ElectionService(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public List<Election> getAllElections(){
        return electionRepository.findAll();
    }

}
