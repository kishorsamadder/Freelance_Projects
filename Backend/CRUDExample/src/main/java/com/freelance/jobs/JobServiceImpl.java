package com.freelance.jobs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelance.common.RecordNotFoundException;

/**
 * @author Kishor Samadder
 * @description This is implementation class for Job
 *
 */
@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobRepository jobRepository;

	@Override
	public Job saveJob(Job job) {
		return jobRepository.save(job);
	}

	@Override
	public List<Job> getAllJob() {
		return jobRepository.findAll();
	}

	@Override
	public Job getJobById(String jobId) {
		return jobRepository.findByjobId(jobId)
				.orElseThrow(() -> new RecordNotFoundException("Job", "id", jobId));
	}

	@Override
	public Job updateJob(Job job, String jobId) {
		Job updateJob = jobRepository.findByjobId(jobId)
				.orElseThrow(() -> new RecordNotFoundException("Job", "id", jobId));
		updateJob.setJobCategory(job.getJobCategory());
		updateJob.setJobDescription(job.getJobDescription());
		updateJob.setJobTitle(job.getJobTitle());
		return jobRepository.save(updateJob);
	}

	@Override
	public Boolean deleteJob(String jobId) {
		jobRepository.deleteById(jobId);
        return true;
	}

	@Override
	public Job patchJob(Job job, String jobId) {
		Job updateJob = jobRepository.findByjobId(jobId)
				.orElseThrow(() -> new RecordNotFoundException("Job", "id", jobId));
		if (null != job.getJobCategory()) {
			updateJob.setJobCategory(job.getJobCategory());
		}
		if (null != job.getJobTitle()) {
			updateJob.setJobTitle(job.getJobTitle());
		}
		if (null != job.getJobDescription()) {
			updateJob.setJobDescription(job.getJobDescription());
		}
		return jobRepository.save(updateJob);
	}
}
