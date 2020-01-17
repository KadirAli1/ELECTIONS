package com.elections.service;

import com.elections.domain.Party;
import com.elections.domain.Vote;
import com.elections.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {
    private VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public List<Vote> getAllVotes(){
        return voteRepository.findAll();
    }

    public List<Vote> getAllFemalesVotes(){
        return voteRepository.findByCitizenSex("F");
    }

    public List<Vote> getAllMaleVotes(){
        return voteRepository.findByCitizenSex("M");
    }

    public List<Vote> getAllVotesFromConstituency(int zone){
        return voteRepository.findByCitizenMunicipalityConstituencyName("Constituency" + zone);
    }
}
