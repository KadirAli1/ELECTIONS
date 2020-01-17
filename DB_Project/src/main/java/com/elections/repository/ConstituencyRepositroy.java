package com.elections.repository;

import com.elections.domain.Constituency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstituencyRepositroy extends JpaRepository<Constituency, String> {
}
