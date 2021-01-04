package com.capgemini.interviewtrackingsystem.services.impl;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.interviewtrackingsystem.dao.CandidateManagementJpaDao;
import com.capgemini.interviewtrackingsystem.model.Candidate;
import com.capgemini.interviewtrackingsystem.services.CandidateManagementService;

@Service
@Transactional
public class CandidateManagementServiceImpl implements CandidateManagementService{
	private static final Logger logger = LogManager.getLogger(CandidateManagementServiceImpl.class);
	@Autowired
    private CandidateManagementJpaDao candidateManagementJpaDao;

    @Override
    public Iterable<Candidate> getAllCandidates() {
    	logger.info("in candidate management service implementations (getAllCandidates)");
        return candidateManagementJpaDao.findAll();
    }

    @Override
    public Candidate findCandidateById(Integer candidateId) {
    	logger.info("in candidate management service implementations (findCandidateById)"); 
        return candidateManagementJpaDao.findById(candidateId).get();  
    }
    
    /*
    @Override
    public Candidate findCandidateById(Integer candidateId) {
    	Candidate candidate = candidateManagementJpaDao.findById(candidateId).get();
    	logger.info("start with findCandidateById in service");
        return  candidateManagementJpaDao.findById(candidateId).get();  //Optional 
    }  */


   
    @Override
    public boolean deleteCandidateById(Integer candidateId) {
    	logger.info(" in candidate management service implementations class (deleteCandidateById)");
        Candidate candidate = candidateManagementJpaDao.findById(candidateId).get();
        if(null == candidate){
            return false;
        }
        candidateManagementJpaDao.deleteById(candidateId);
        return true;
    }

    @Override
    public Candidate createCandidate(Candidate candidate) {
    	logger.info(" in service implementations class");
        return candidateManagementJpaDao.save(candidate);
    }

	}









































































































/*@Override
public Candidate updateCandidateById(Integer candidateId) {
	
	Candidate candidate=candidateManagementJpaDao.findById(candidateId).get();
	candidate.setCandidateId(candidateId);
	return candidateManagementJpaDao.save(candidate);
	   
}*/


/* @Override
public Candidate updateEmailById(Integer ticketId, String email) {
    Ticket ticket = ticketBookingJpaDao.findById(ticketId).get();
    ticket.setEmail(email);
    return ticketBookingJpaDao.save(ticket);
}*/

