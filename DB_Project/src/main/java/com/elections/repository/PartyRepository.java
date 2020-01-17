package com.elections.repository;

import com.elections.domain.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {
    Party findByName(String name);
}
