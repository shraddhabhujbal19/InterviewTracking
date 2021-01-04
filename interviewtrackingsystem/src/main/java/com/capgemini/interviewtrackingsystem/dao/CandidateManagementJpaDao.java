package com.capgemini.interviewtrackingsystem.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.interviewtrackingsystem.model.Candidate;

@Repository

public interface CandidateManagementJpaDao extends JpaRepository<Candidate,Integer> {
	    @Query("select c from Candidate c where c.candidateId=:candidateId")
	    Candidate findCandidateById(Integer candidateId);


}
