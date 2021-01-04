package com.capgemini.interviewtrackingsystem.dao;

import com.capgemini.interviewtrackingsystem.model.Candidate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CandidateManagementJpaDao.class)

@DataJpaTest
public class CandidateManagementJpaDaoTest  {

    @Autowired
    private CandidateManagementJpaDao  candidateManagementJpaDao;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testNewCandidate() throws Exception{
        Candidate candidate = getCandidate();
        Candidate saveInDb = testEntityManager.persist(candidate);
        Candidate getFromInDb = candidateManagementJpaDao.findById(saveInDb.getCandidateId()).get();
        assertThat(getFromInDb).isEqualTo(saveInDb);
    }

    @Test
    public void testGetCandidateById() throws Exception{
        Candidate candidate = new Candidate();
        candidate.setCandidateId(1);
        candidate.setCandidateName("Shraddha");
        candidate.setPrimarySkill("java");
        candidate.setSecondarySkill("database");
        candidate.setExperience("1year");
        candidate.setQualification("bsc");
        candidate.setDesignation("trainee");
        candidate.setNoticePeriod("2months");
        candidate.setLocation("Pune");

        //Insert Data into in memory database
        Candidate saveInDb = testEntityManager.persist(candidate);
        //Get Data from DB
        Candidate getInDb = candidateManagementJpaDao.findById(candidate.getCandidateId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
    }

    @Test
    public void testGetAllCandidates() throws Exception{
    	Candidate candidate1 = new Candidate();
        candidate1.setCandidateId(100);
        candidate1.setCandidateName("Shamshree");
        candidate1.setPrimarySkill("Pgsql");
        candidate1.setSecondarySkill("php");
        candidate1.setExperience("2years");
        candidate1.setQualification("bsc");
        candidate1.setDesignation("developer");
        candidate1.setNoticePeriod("10months");
        candidate1.setLocation("Pune");
        
        Candidate candidate2 = new Candidate();
        candidate2.setCandidateId(99);
        candidate2.setCandidateName("Shree");
        candidate2.setPrimarySkill("Pgsql");
        candidate2.setSecondarySkill("C");
        candidate2.setExperience("2years");
        candidate2.setQualification("msc");
        candidate2.setDesignation("developer");
        candidate2.setNoticePeriod("8months");
        candidate2.setLocation("Pune");
        
        //Save into in memory database
        testEntityManager.persist(candidate1);
        testEntityManager.persist(candidate2);

        //Retrieve all candidates
        List<Candidate> candidateList = (List<Candidate>) candidateManagementJpaDao.findAll();

        Assert.assertEquals(2, candidateList.size());
    }

    
    @Test
    public void testDeleteCandidateById() throws Exception{
    	Candidate candidate1 = new Candidate();
        candidate1.setCandidateId(100);
        candidate1.setCandidateName("Shamshree");
        candidate1.setPrimarySkill("Pgsql");
        candidate1.setSecondarySkill("php");
        candidate1.setExperience("2years");
        candidate1.setQualification("bsc");
        candidate1.setDesignation("developer");
        candidate1.setNoticePeriod("10months");
        candidate1.setLocation("Pune");
        
        Candidate candidate2 = new Candidate();
        candidate2.setCandidateId(99);
        candidate2.setCandidateName("Shree");
        candidate2.setPrimarySkill("Pgsql");
        candidate2.setSecondarySkill("C");
        candidate2.setExperience("2years");
        candidate2.setQualification("msc");
        candidate2.setDesignation("developer");
        candidate2.setNoticePeriod("8months");
        candidate2.setLocation("Pune");
        
        Candidate candidate = testEntityManager.persist(candidate1);
        testEntityManager.persist(candidate2);

        //delete one candidate DB
        testEntityManager.remove(candidate);

        List<Candidate> candidates = (List<Candidate>) candidateManagementJpaDao.findAll();
        Assert.assertEquals(candidates.size(), 1);

    }

 
    private Candidate getCandidate() {
    	Candidate candidate = new Candidate();
        candidate.setCandidateId(100);
        candidate.setCandidateName("Shamshree");
        candidate.setPrimarySkill("Pgsql");
        candidate.setSecondarySkill("php");
        candidate.setExperience("2years");
        candidate.setQualification("bsc");
        candidate.setDesignation("developer");
        candidate.setNoticePeriod("10months");
        candidate.setLocation("Pune");
        
        return candidate;
    }
}









































































/*  @Test
public void testUpdateCandidate(){

	
    Candidate candidate2 = new Candidate();
    candidate2.setCandidateId(99);
    candidate2.setCandidateName("Shree");
    candidate2.setPrimarySkill("Pgsql");
    candidate2.setSecondarySkill("C");
    candidate2.setExperience("2years");
    candidate2.setQualification("msc");
    candidate2.setDesignation("developer");
    candidate2.setNoticePeriod("8months");
    candidate2.setLocation("Pune");
    
    testEntityManager.persist(candidate2);

    Candidate getFromDb = candidateManagementJpaDao.findById(88);
    getFromDb.setCandidateId(109);
    testEntityManager.persist(getFromDb);

    assertThat(getFromDb.getCandidateId()).isEqualTo(99);
}
*/
