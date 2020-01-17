package com.elections.domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String abbreviation; //Shkurtesat (PDSH)
    //private  String candidat_details;

    @ManyToMany(mappedBy = "parties")
    List<Election> electionsParticipatedIn = new ArrayList<>();

    @OneToMany(
            mappedBy = "party"
    )
    List<Candidate> candidates = new ArrayList<>();

    @OneToMany(mappedBy = "party")
    private List<Vote> votes = new ArrayList<>();

    public Party(){

    }

    public Party(String name,String abbreviation){
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

//    public List<Election> getElectionsParticipatedIn() {
//        return electionsParticipatedIn;
//    }

    public void addElection(Election election){
        electionsParticipatedIn.add(election);
    }

}
