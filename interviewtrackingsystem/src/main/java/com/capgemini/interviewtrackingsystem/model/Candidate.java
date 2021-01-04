package com.capgemini.interviewtrackingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//this class is used to create database tables and has all the getters and setters
@Entity
@Table(name = "candidate")
public class Candidate {

    @Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ",primarySkill=" + primarySkill + 
				 ", secondarySkill=" + secondarySkill + ", experience=" + experience + ", qualification=" + qualification + ", designation=" + designation + ", noticePeriod=" + noticePeriod +", location=" + location +"]";
	}

	@Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "candidate_id")
    private Integer candidateId;
    @Column(name ="candidate_name", nullable = false)
    private String candidateName;
    @Column(name = "primary_skill", nullable = false)
    private String primarySkill;
    @Column(name = "secondary_skill", nullable = false)
    private String secondarySkill;
    @Column(name = "experience", nullable = false)
    private String experience;
    @Column(name = "qualification", nullable = false)
    private String qualification;
    @Column(name = "designation", nullable = false)
    private String designation;
    @Column(name = "notice_period", nullable = false)
    private String noticePeriod;
    @Column(name = "location", nullable = false)
    private String location;
	public Integer getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getPrimarySkill() {
		return primarySkill;
	}
	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}
	public String getSecondarySkill() {
		return secondarySkill;
	}
	public void setSecondarySkill(String secondarySkill) {
		this.secondarySkill = secondarySkill;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
    

}