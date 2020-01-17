package com.elections.domain;

import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Citizen {
    @Id
    private String embg;
    private String name;
    private String surName;
    private LocalDate birthday;
    //private String email;
    private String sex;
    private String nationality;

    @ManyToOne
    private Municipality municipality;

    @OneToOne(mappedBy = "citizen")
    private Vote vote;

    public Citizen(){

    }

    public Citizen(String embg, String name, String surName, LocalDate birthday, String sex, String nationality,
                   Municipality municipality) {
        this.embg = embg;
        this.name = name;
        this.surName = surName;
        this.birthday = birthday;
        this.sex = sex;
        this.nationality = nationality;
        this.municipality = municipality;
    }

    public String getEmbg() {
        return embg;
    }

    public void setEmbg(String embg) {
        this.embg = embg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }
}
