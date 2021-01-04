package com.capgemini.interviewtrackingsystem.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.capgemini.interviewtrackingsystem.model.Candidate;
import com.capgemini.interviewtrackingsystem.services.CandidateManagementService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CandidateManagementController.class)
public class CandidateManagementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CandidateManagementService candidateManagementService;


    @Test
    public void testNewCandidate() throws Exception{
        String URI = "/managecandidate/createCandidate";
        Candidate candidate = new Candidate();
        candidate.setCandidateId(101);
        candidate.setCandidateName("Shiv");
        candidate.setPrimarySkill("C++");
        candidate.setSecondarySkill(".Net");
        candidate.setExperience("5years");
        candidate.setQualification("msc");
        candidate.setDesignation("developer");
        candidate.setNoticePeriod("10days");
        candidate.setLocation("Pune");
        String jsonInput = this.converttoJson(candidate);

        Mockito.when(candidateManagementService.createCandidate(Mockito.any(Candidate.class))).thenReturn(candidate);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
    }

    @Test
    public void testGetCandidateById() throws Exception{
        String URI= "/managecandidate/getCandidateById/{candidateId}";
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
        String jsonInput = this.converttoJson(candidate);

        Mockito.when(candidateManagementService.findCandidateById(Mockito.any())).thenReturn(candidate);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
    }


    @Test
    public void testGetCandidateByIdIndividual() throws Exception{
        String URI= "/managecandidate/getCandidateById/{candidateId}";
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
         String jsonInput = this.converttoJson(candidate);

        Mockito.when(candidateManagementService.findCandidateById(Mockito.any())).thenReturn(candidate);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 10)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        System.out.println(jsonOutput);
        assertThat(jsonInput).isEqualTo(jsonOutput);
        assertThat(candidate.getCandidateName()).isEqualTo("Ram");
    }


    @Test
    public void testGetAllCandidates() throws Exception{
        String URI = "/managecandidate/getAllCandidates";
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

        String jsonInput = this.converttoJson(candidateList);

        Mockito.when(candidateManagementService.getAllCandidates()).thenReturn(candidateList);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
    }

      @Test
    public void testDeleteCandidateById() throws Exception{
        String URI = "/managecandidate/deleteCandidateById/candidate/{candidateId}";
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
        
        Mockito.when(candidateManagementService.findCandidateById(Mockito.any())).thenReturn(candidate);
        Mockito.when(candidateManagementService.deleteCandidateById(Mockito.any())).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 10).accept(MediaType.
        		APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

    }


    /**
     * Convert Object into Json String by using Jackson ObjectMapper
     * @param candidate
     * @return
     * @throws JsonProcessingException
     */
    private String converttoJson(Object candidate) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(candidate);
    }

}




































































































/* @Test
public void testUpdateCandidate() throws Exception{

    String URI = "/managecandidate/updateCandidatebyId/candidate/{candidateId}";
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
   String jsonInput = this.converttoJson(candidate2);

    Mockito.when(candidateManagementService.updateCandidateById(Mockito.any())).thenReturn(candidate2);
    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,99).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
            .andReturn();
    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
    String jsonOutput = mockHttpServletResponse.getContentAsString();

    assertThat(jsonInput).isEqualTo(jsonOutput);
}
*/
