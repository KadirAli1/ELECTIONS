package com.elections.repository;

import com.elections.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.nio.channels.MulticastChannel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class DbInit implements CommandLineRunner {
    private ElectionRepository electionRepository;
    private PartyRepository partyRepository;
    private CandidateRepository candidateRepository;
    private MunicipalityRepository municipalityRepository;
    private ConstituencyRepositroy constituencyRepositroy;
    private  CitizenRepository citizenRepository;
    private  VoteRepository voteRepository;

    public DbInit(ElectionRepository electionRepository, PartyRepository partyRepository, CandidateRepository candidateRepository,
                  MunicipalityRepository municipalityRepository, ConstituencyRepositroy constituencyRepositroy,
                  CitizenRepository citizenRepository, VoteRepository voteRepository){
        this.electionRepository = electionRepository;
        this.partyRepository = partyRepository;
        this.candidateRepository = candidateRepository;
        this.municipalityRepository = municipalityRepository;
        this.constituencyRepositroy = constituencyRepositroy;
        this.citizenRepository = citizenRepository;
        this.voteRepository = voteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Election election1 = new Election(LocalDate.now().minusYears(1), "Parliamentary elections");
        Election election2 = new Election(LocalDate.now().minusYears(5), "Presidential elections");

        Party party1 = new Party("Демократска партија на Албанците","ДПА");
        Party party2 = new Party("Внатрешна македонска револуционерна организација - Демократска партија за македонско национално единство","ВМРО-ДПМНЕ");
        Party party3 = new Party("Демократска Унија за Интеграција","ДУИ");
        Party party4 = new Party("Социјалдемократски сојуз на Македонија","СДСМ");

        electionRepository.save(election1);
        electionRepository.save(election2);

        partyRepository.save(party1);
        partyRepository.save(party2);
        partyRepository.save(party3);
        partyRepository.save(party4);


        Election e1 = electionRepository.findByDetails(election1.getDetails());
        Election e2 = electionRepository.findByDetails(election2.getDetails());
        Party p1 = partyRepository.findByName(party1.getName());
        Party p2 = partyRepository.findByName(party2.getName());
        Party p3 = partyRepository.findByName(party3.getName());
        Party p4 = partyRepository.findByName(party4.getName());

        e1.addParty(p1);
        e1.addParty(p2);
        e1.addParty(p3);

        e2.addParty(p3);
        e2.addParty(p4);

        electionRepository.save(e1);
        electionRepository.save(e2);

        Candidate candidate1 = new Candidate("1000","Fisnik","Limani","M","Albanian","fisnik.limani1@gmail.com", LocalDate.now(),"+38971698944",p1);
        Candidate candidate2 = new Candidate("1001","Kadir","Ali","M","Albanian","kadir.ali@gmail.com", LocalDate.now(),"+38971698944",p3);
        Candidate candidate3 = new Candidate("1002","Musli","Ademi","M","Macedonian","musli.ademi@gmail.com", LocalDate.now(),"+38971698944",p2);
        Candidate candidate4 = new Candidate("1003","Ylle","Sulejmani","F","Albanian","ylle.sulejmani@gmail.com", LocalDate.now(),"+38971698944",p4);
        Candidate candidate5 = new Candidate("1004","Petko","Petkovski","M","Macedonian","petko.petkovski@gmail.com", LocalDate.now(),"+38971698944",p4);

        candidateRepository.save(candidate1);
        candidateRepository.save(candidate2);
        candidateRepository.save(candidate3);
        candidateRepository.save(candidate4);
        candidateRepository.save(candidate5);

        // ADDING CONSTITUENCIES
        Constituency constituency1 = new Constituency("Constituency1");
        Constituency constituency2 = new Constituency("Constituency2");
        Constituency constituency3 = new Constituency("Constituency3");
        Constituency constituency4 = new Constituency("Constituency4");
        Constituency constituency5 = new Constituency("Constituency5");
        Constituency constituency6 = new Constituency("Constituency6");

        List<Constituency> constituencies = new ArrayList<>();
        constituencies.add(constituency1);
        constituencies.add(constituency2);
        constituencies.add(constituency3);
        constituencies.add(constituency4);
        constituencies.add(constituency5);
        constituencies.add(constituency6);

        constituencyRepositroy.saveAll(constituencies);

        // ADDING MUNICIPALITIES
        constituencies = constituencyRepositroy.findAll();
        List<Municipality> municipalities = new ArrayList<>();
        for(int i = 1; i <= 30; ++i){
            Random random = new Random();
            Municipality municipality = new Municipality("Municipality" + i, constituencies.get(random.nextInt(6)));
            municipalities.add(municipality);
        }
        municipalityRepository.saveAll(municipalities);


        // ADDING CITIZENS
        municipalities = municipalityRepository.findAll();
        List<Citizen> citizens = new ArrayList<>();
        for(int i = 1; i <= 100; ++i){
            Random random = new Random();
            Citizen citizen = new Citizen(Integer.toString(i+1999), "CitizenName" + i, "CitizenSurname" + i, LocalDate.now().minusDays(i*50), random.nextBoolean() ? "M" : "F", random.nextBoolean() ? "Albanian" : "Macedonian", municipalities.get(random.nextInt(30)));
            citizens.add(citizen);
        }
        citizenRepository.saveAll(citizens);

        // ADDING VOTES

        citizens = citizenRepository.findAll();
        List<Party> parties = partyRepository.findAll();
        List<Vote> votes = new ArrayList<>();
        for(Citizen citizen : citizens){
            Random random = new Random();
            Party party = parties.get(random.nextInt(4));
            Vote vote = new Vote(citizen,party);
            votes.add(vote);
        }
        voteRepository.saveAll(votes);
    }
}
