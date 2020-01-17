package com.elections.domain;

import lombok.Data;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate electionDate;
    private String details;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Party> parties = new ArrayList<>();

    public Election(){

    }

    public Election(LocalDate electionDate, String details){
        this.electionDate = electionDate;
        this.details = details;
    }

    public LocalDate getElectionDate() {
        return electionDate;
    }

    public void setElectionDate(LocalDate electionDate) {
        this.electionDate = electionDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Party> getParties() {
        return parties;
    }

    public void addParty(Party party){
        parties.add(party);
    }
}
