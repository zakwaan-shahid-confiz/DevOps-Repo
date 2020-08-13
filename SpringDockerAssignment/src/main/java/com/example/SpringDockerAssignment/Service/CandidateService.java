package com.example.SpringDockerAssignment.Service;

import com.example.SpringDockerAssignment.Model.Candidate;
import com.example.SpringDockerAssignment.Repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> getAllCandidates()
    {
        List<Candidate> candidateList = new ArrayList<>();
        candidateRepository.findAll().forEach(candidateList::add);
        return candidateList;
    }

    public Optional<Candidate> getCandidate(int id)
    {
        return candidateRepository.findById(id);
    }

    public String addCandidate(Candidate candidate)
    {
        candidateRepository.save(candidate);
        return "Candidate Added with ID : " + candidate.getId();
    }

    public String updateCandidate(Candidate candidate)
    {
        if(candidateRepository.existsById(candidate.getId())) {
            candidateRepository.save(candidate);
            return "Candidate Updated with ID : " + candidate.getId();
        }
        return "No Such ID";
    }

    public String deleteCandidate(int id)
    {
        candidateRepository.deleteById(id);
        return "Candidate Deleted with ID : " + id;
    }

}
