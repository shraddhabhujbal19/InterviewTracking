package com.capgemini.interviewtrackingsystem.services;

import com.capgemini.interviewtrackingsystem.model.Candidate;

//this class contains all methods needed to be called to perform certain operations on candidate

public interface CandidateManagementService {
	
	Iterable<Candidate> getAllCandidates();
   Candidate findCandidateById(Integer candidateId);
    boolean deleteCandidateById(Integer candidateId);
    Candidate  createCandidate(Candidate candidate);
	
}

