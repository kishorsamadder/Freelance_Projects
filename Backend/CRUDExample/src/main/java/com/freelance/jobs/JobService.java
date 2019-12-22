/**
 * 
 */
package com.freelance.jobs;

import java.util.List;

/**
 * @author Kishor Samadder
 *
 */
public interface JobService {

	Job saveJob(Job job);

	List<Job> getAllJob();

	Job getJobById(String jobId);

	Job updateJob(Job job, String jobId);

	Boolean deleteJob(String jobId);

	Job patchJob(Job job, String jobId);

}
