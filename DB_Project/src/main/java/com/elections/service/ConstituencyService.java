package com.elections.service;

import com.elections.domain.Constituency;
import com.elections.domain.Party;
import com.elections.repository.ConstituencyRepositroy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstituencyService {
    private ConstituencyRepositroy constituencyRepositroy;

    public ConstituencyService(ConstituencyRepositroy constituencyRepositroy) {
        this.constituencyRepositroy = constituencyRepositroy;
    }
    public List<Constituency> getAllConstituencies(){
        return constituencyRepositroy.findAll();
    }
}
