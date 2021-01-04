package com.capgemini.interviewtrackingsystem.controller;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.capgemini.interviewtrackingsystem.exception.ResourceNotFoundException;
import com.capgemini.interviewtrackingsystem.model.Candidate;
import com.capgemini.interviewtrackingsystem.services.CandidateManagementService;

@RestController
@RequestMapping("/managecandidate")

public class CandidateManagementController {
	 
	private static final Logger logger = LogManager.getLogger(CandidateManagementController.class);

	    @Autowired
	    private CandidateManagementService candidateManagementService;

	    @GetMapping("/getAllCandidates")
	    public List<Candidate> getAllCandidates(){
	    	logger.info(" in controller..");
	    	return (List<Candidate>) candidateManagementService.getAllCandidates();
	    }

	    @GetMapping("/getCandidateById/{candidateId}")
	    public Candidate getCandidateById(@PathVariable Integer candidateId) throws ResourceNotFoundException{
	       // Candidate candidate=candidateManagementService.findCandidateById(candidateId)
	        //		.orElseThrow(() -> new ResourceNotFoundException("candidate not found for id :-" +candidateId));
	    	logger.info(" in candidate management controller.. (getCandidateById)");
	    	if (candidateId==null) throw new ResourceNotFoundException("Candidate not found for this id :: " + candidateId);
	    	return candidateManagementService.findCandidateById(candidateId);
	    }
	    
	   /* @GetMapping("/getCandidateById/{candidateId}")
	    public Optional<Candidate> getCandidateById(@PathVariable(value= "candidateId") Integer candidateId) throws ResourceNotFoundException {	    
	    	logger.info("start getCandidateById in controller");	    	
	    	candidateManagementService.findCandidateById(candidateId)
	    	.orElseThrow(() -> new ResourceNotFoundException("Candidate not found for this id ::" + candidateId));	    	    
	        return candidateManagementService.findCandidateById(candidateId);
	    }
	    */
	    	    
	    @PostMapping("/createCandidate")
	    public Candidate createCandidate(@RequestBody Candidate candidate){
	    	logger.info(" in candidate management controller.. (createCandidate)");
	        return candidateManagementService.createCandidate(candidate);
	    }

	    @DeleteMapping("/deleteCandidateById/candidate/{candidateId}")
	    public boolean deleteCandidateById(@PathVariable Integer candidateId)  throws ResourceNotFoundException{
	    	logger.info(" in candidate management controller.. (deleteCandidateById)");
	    	//Candidate candidate=candidateManagementService.findCandidateById(candidateId)
	    		//	.orElseThrow(() -> new ResourceNotFoundException("candidate for given id not found" +candidateId));
	    	if (candidateId==null) throw new ResourceNotFoundException("Candidate not found for this id :: " + candidateId);	
	    	return candidateManagementService.deleteCandidateById(candidateId);
	    
	    }
	    
}















































































































/*
@PutMapping("/updateCandidatebyId/candidate/{candidateId}")
public Candidate updateCandidateById( @PathVariable Integer candidateId) throws ResourceNotFoundException{
   
	//Candidate candidate = candidateManagementService.findCandidateById(candidateId)
		//	.orElseThrow(() -> new ResourceNotFoundException("Candidate not found for this id :: " + candidateId));

	//candidate.setCandidateId(candidate.getCandidateId());
	//candidate.setCandidateName(candidate.getCandidateName());
	//candidate.setFirstName(employeeDetails.getFirstName());
	//final Candidate updatedCandidateById = candidateManagementService.save(candidate);

	
	return candidateManagementService.updateCandidateById(candidateId);
}*/


/*@PutMapping("/updateCandidatebyId/candidate/{candidateId}")
public Candidate updateCandidateById( @PathVariable Integer candidateId) throws ResourceNotFoundException{
   
	Candidate candidate = candidateManagementService.findCandidateById(candidateId)
			.orElseThrow(() -> new ResourceNotFoundException("Candidate not found for this id :: " + candidateId));

	candidate.setCandidateId(candidate.getCandidateId());
	candidate.setCandidateName(candidate.getCandidateName());
	//candidate.setFirstName(employeeDetails.getFirstName());
	final Candidate updatedCandidateById = candidateManagementService.save(candidate);

	
	return candidateManagementService.updateCandidateById(candidateId);
}*/

