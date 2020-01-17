package com.elections.repository;

import com.elections.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer>{
    List<Vote> findByCitizenSex(String sex);
    List<Vote> findByCitizenMunicipalityConstituencyName(String name);
}
