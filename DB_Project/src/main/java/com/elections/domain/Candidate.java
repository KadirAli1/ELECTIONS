package com.elections.domain;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Candidate {
    @Id
    private String embg;
    private String name;
    private String surname;
    private String sex;
    private String nationality;
    private String email;
    private LocalDate birthday;
    private String mobileNumber;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private Party party;

    public Candidate(){

    }

    public Candidate(String embg, String name,String surname,String sex, String nationality, String email, LocalDate birthday, String mobileNumber, Party party) {
        this.embg = embg;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.nationality = nationality;
        this.email = email;
        this.birthday = birthday;
        this.mobileNumber = mobileNumber;
        this.party = party;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
}
