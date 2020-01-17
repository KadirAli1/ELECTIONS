package com.elections.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Municipality {
    //Opshtina
    @Id
    private String name;

    @ManyToOne
    private Constituency constituency;

    @OneToMany(mappedBy = "municipality")
    private List<Citizen> citizens;

    public Municipality(){

    }

    public Municipality( String name, Constituency constituency) {
        this.name = name;
        this.constituency = constituency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Constituency getConstituency() {
        return constituency;
    }

    public void setConstituency(Constituency constituency) {
        this.constituency = constituency;
    }
}
