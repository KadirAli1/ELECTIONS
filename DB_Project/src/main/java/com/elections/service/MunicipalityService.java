package com.elections.service;

import com.elections.domain.Municipality;
import com.elections.domain.Party;
import com.elections.repository.MunicipalityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalityService {
    private MunicipalityRepository municipalityRepository;

    public MunicipalityService(MunicipalityRepository municipalityRepository) {
        this.municipalityRepository = municipalityRepository;
    }
    public List<Municipality> getAllMunicipalities(){
        return municipalityRepository.findAll();
    }
}
