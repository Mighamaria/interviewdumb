package com.USTInterviewScheduler.FeedBackForm.service;

import com.USTInterviewScheduler.FeedBackForm.entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import com.USTInterviewScheduler.FeedBackForm.repository.CandidateRepository;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;



    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }



//    public Candidate createCandidate(Candidate candidate) {
//        candidate.setInterviewResultDate(LocalDate.now());
//        return candidateRepository.save(candidate);
//    }



    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Candidate with id " + id + " not found"));
    }



    public Candidate updateCandidate(Long id, Candidate candidate) {
        Candidate existingCandidate = getCandidateById(id);
        existingCandidate.setName(candidate.getName());
        existingCandidate.setInterviewDate(candidate.getInterviewDate());
        existingCandidate.setInterviewTime(candidate.getInterviewTime());
        existingCandidate.setInterviewerName(candidate.getInterviewerName());
        existingCandidate.setInterviewResult(candidate.getInterviewResult());
        existingCandidate.setInterviewComments(candidate.getInterviewComments());
//        existingCandidate.setRecommendation(candidate.getRecommendation());
//        existingCandidate.setInterviewerSignature(candidate.getInterviewerSignature());
        return candidateRepository.save(existingCandidate);
    }



    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }
}

