package com.capgemini.interviewtrackingsystem.service;

import com.capgemini.interviewtrackingsystem.dao.CandidateManagementJpaDao;
import com.capgemini.interviewtrackingsystem.model.Candidate;
import com.capgemini.interviewtrackingsystem.services.CandidateManagementService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CandidateManagementServiceTest {

    @MockBean
    private CandidateManagementJpaDao candidateManagementJpaDao;

    @Autowired
    private CandidateManagementService candidateManagementService;

    @Test
    public void testCreateCandidate(){
    	Candidate candidate = new Candidate();
        candidate.setCandidateId(101);
        candidate.setCandidateName("Senthil");
        candidate.setPrimarySkill("C++");
        candidate.setSecondarySkill(".Net");
        candidate.setExperience("5years");
        candidate.setQualification("msc");
        candidate.setDesignation("developer");
        candidate.setNoticePeriod("10days");
        candidate.setLocation("Pune");
        
        Mockito.when(candidateManagementJpaDao.save(candidate)).thenReturn(candidate);
        assertThat(candidateManagementService.createCandidate(candidate)).isEqualTo(candidate);
    }

    @Test
    public void testGetCandidateById() throws Exception{
    	Candidate candidate = new Candidate();
    	candidate.setCandidateId(10);
    	candidate.setCandidateName("Ram");
        candidate.setPrimarySkill("C++");
        candidate.setSecondarySkill("php");
        candidate.setExperience("2years");
        candidate.setQualification("bsc");
        candidate.setDesignation("developer");
        candidate.setNoticePeriod("10months");
        candidate.setLocation("Pune");
         Candidate cc=candidateManagementJpaDao.findById(10).get();
        Mockito.when(cc).thenReturn(candidate);
        assertThat(candidateManagementService.findCandidateById(101)).isEqualTo(candidate);
    }

    @Test
    public void testGetAllAddedCandidatess() throws Exception{
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
        
        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(candidate1);
        candidateList.add(candidate2);

        Mockito.when(candidateManagementJpaDao.findAll()).thenReturn(candidateList);
        assertThat(candidateManagementService.getAllCandidates()).isEqualTo(candidateList);
    }


    @Test
    public void testFindById() throws Exception{
    	Candidate candidate = new Candidate();
    	candidate.setCandidateId(10);
    	candidate.setCandidateName("Ram");
        candidate.setPrimarySkill("C++");
        candidate.setSecondarySkill("php");
        candidate.setExperience("2years");
        candidate.setQualification("bsc");
        candidate.setDesignation("developer");
        candidate.setNoticePeriod("10months");
        candidate.setLocation("Pune");
        
        Mockito.when(candidateManagementJpaDao.findById(10).get()).thenReturn(candidate);
        assertThat(candidateManagementService.findCandidateById(10)).isEqualTo(candidate);
    }

    @Test
    public void testDeleteCandidateById() throws Exception{
    	Candidate candidate = new Candidate();
    	candidate.setCandidateId(10);
    	candidate.setCandidateName("Ram");
        candidate.setPrimarySkill("C++");
        candidate.setSecondarySkill("php");
        candidate.setExperience("2years");
        candidate.setQualification("bsc");
        candidate.setDesignation("developer");
        candidate.setNoticePeriod("10months");
        candidate.setLocation("Pune");
        
        Mockito.when(candidateManagementJpaDao.save(candidate)).thenReturn(candidate);
        Mockito.when(candidateManagementJpaDao.findById(10).get()).thenReturn(candidate);
        candidateManagementJpaDao.deleteById(candidate.getCandidateId());
        Mockito.when(candidateManagementJpaDao.findById(10).get()).thenReturn(candidate);
        Assert.assertNotEquals(candidate, new Candidate());
        Assert.assertEquals(candidateManagementService.deleteCandidateById(10), false);
    }

    @Test
    public void testDeleteCandidateByNull() throws Exception{
        Candidate candidate = new Candidate();
        candidate.setCandidateId(10);
        Candidate nullCandidate = null;
        Mockito.when(candidateManagementJpaDao.findById(10).get()).thenReturn(nullCandidate);
        candidateManagementJpaDao.deleteById(candidate.getCandidateId());
        Assert.assertEquals(candidateManagementService.deleteCandidateById(10), true);
    }

}







































































/* @Test
public void testUpdateCandidate() throws Exception{

	Candidate candidate2 = new Candidate();
    candidate2.setCandidateId(101);
    candidate2.setCandidateName("Senthil");
    candidate2.setPrimarySkill("C++");
    candidate2.setSecondarySkill(".Net");
    candidate2.setExperience("5years");
    candidate2.setQualification("msc");
    candidate2.setDesignation("developer");
    candidate2.setNoticePeriod("10days");
    candidate2.setLocation("Pune");
    
    Mockito.when(candidateManagementJpaDao.findById(101).get()).thenReturn(candidate2);
    candidate2.setCandidateId(66);
    Mockito.when(candidateManagementJpaDao.save(candidate2)).thenReturn(candidate2);
    System.out.println(candidate2.getCandidateId());
    //assertThat(candidateManagementService.updateCandidateById(66)).isEqualTo(candidate2);
}
*/
