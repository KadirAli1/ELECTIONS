package com.elections.service;

import com.elections.domain.Party;
import com.elections.repository.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService {
    private PartyRepository partyRepository;

    public PartyService(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    public List<Party> getAllParties(){
        return partyRepository.findAll();
    }
}
