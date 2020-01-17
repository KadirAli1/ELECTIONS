package com.elections.service;

import com.elections.domain.Citizen;
import com.elections.domain.Party;
import com.elections.repository.CitizenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {
    private CitizenRepository citizenRepository;

    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }
    public List<Citizen> getAllCitizens(){
        return citizenRepository.findAll();
    }
}
