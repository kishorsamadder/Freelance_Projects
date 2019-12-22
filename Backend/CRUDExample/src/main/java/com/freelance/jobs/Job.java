/**
 * 
 */
package com.freelance.jobs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Kishor Samadder
 * @description This is a entity class for Status table. 
 *
 */

@Entity
@Table(name = "jobs")
@JsonIgnoreProperties(value="true")
public class Job {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String jobId; 
	private String jobTitle;
	private String jobDescription;
	private String jobCategory;
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobCategory() {
		return jobCategory;
	}
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription
				+ ", jobCategory=" + jobCategory + "]";
	}
}
