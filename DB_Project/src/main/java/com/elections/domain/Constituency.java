package com.elections.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Constituency {
    //Izborna edinica
    @Id
    private String name;

    @OneToMany(mappedBy = "constituency")
    private List<Municipality> municipalities;

    public Constituency(){

    }

    public Constituency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Municipality> getMunicipalities() {
//        return municipalities;
//    }
}
