/**
 * 
 */
package com.freelance.jobs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.common.Response;
import com.freelance.common.ResponseEnum;

/**
 * @author Kishor Samadder
 * @description: This is RestController for Job
 * @Endpoints: Post api/v1/job = "Insert Job in DB" GET
 *             GET  api/v1/job = "Get all job from DB" GET
 *             GET  api/v1/job/{jobId} = "Get job by id from DB"
 *             PUT  api/v1/job/{jobId} = "Update job by id in DB"
 *          DELETE	api/v1/job/{jobId} = "Delete job by id in DB"
 *           PATCH  api/v1/job/{jobId} = "Patch update job by id in DB"
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/job") 
public class JobController {
	Logger logger = LoggerFactory.getLogger(JobController.class);

	@Autowired
	JobService jobService;
	
	/**
	 * @author Kishor Samadder
	 * @description: "Insert Job in DB"
	 * @param: job
	 * @return: ResponseEntity<Response>
	 * @URI: localhost:8080/api/v1/job
	 * @Sample_Input: {
					    "jobTitle": "Software Developer",
					    "jobDescription": "Developement",
					    "jobCategory": "A11"
					}
	 *
	 */
	@PostMapping()
	public ResponseEntity<Response> createJob(@RequestBody Job job) {
		logger.info("inside job controller Post method:::::::::::::::::::");
		Job saveJob = jobService.saveJob(job);
		Response response = new Response(ResponseEnum.SUCCESS.toString(), null, saveJob);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	/**
	 * @author Kishor Samadder
	 * @description: "Get all Job from DB"
	 * @return: ResponseEntity<Response>
	 * @URI: localhost:8080/api/v1/job
	 *
	 */
	@GetMapping()
	public ResponseEntity<Response> getAllJob() {
		logger.info("inside job controller Get all method:::::::::::::::::::");
		Response response = new Response(ResponseEnum.SUCCESS.toString(), null, jobService.getAllJob());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * @author Kishor Samadder
	 * @description: "Get Job by id from DB"
	 * @param: jobId
	 * @return: ResponseEntity<Response>
	 * @URI: localhost:8080/api/v1/job/{jobId}
	 *
	 */
	@GetMapping("/{jobId}")
	public ResponseEntity<Response> getJobById(@PathVariable(value = "jobId") String jobId) {
		logger.info("inside job controller Get method:::::::::::::::::::");
		Response response = new Response(ResponseEnum.SUCCESS.toString(), null, jobService.getJobById(jobId));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * @author Kishor Samadder
	 * @description: "Update Job by id in DB"
	 * @param: Job,  jobId
	 * @return: ResponseEntity<Response>
	 * @URI: localhost:8080/api/v1/job/{jobId}
	 * @Sample_Input: {
					    "jobTitle": "Software Developer",
					    "jobDescription": "Developement",
					    "jobCategory": "A11"
					}
	 *
	 */
	@PutMapping("/{jobId}")
	public ResponseEntity<Response> updateJob(@RequestBody Job job, @PathVariable(value = "jobId") String jobId) {
		logger.info("inside job controller Put method:::::::::::::::::::");
		Response response = new Response(ResponseEnum.SUCCESS.toString(), null, jobService.updateJob(job, jobId));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * @author Kishor Samadder
	 * @description: "Update Job by id in DB"
	 * @param: Job,  jobId
	 * @return: ResponseEntity<Response>
	 * @URI: localhost:8080/api/v1/job/{jobId}
	 * @Sample_Input: {
					    "jobTitle": "Software Developer",
					    "jobDescription": "Developement",
					    "jobCategory": "A11"
					}
	 *
	 */
	@PatchMapping("/{jobId}")
	public ResponseEntity<Response> patchJob(@RequestBody Job job, @PathVariable(value = "jobId") String jobId) {
		logger.info("inside job controller Put method:::::::::::::::::::");
		Response response = new Response(ResponseEnum.SUCCESS.toString(), null, jobService.patchJob(job, jobId));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * @author Kishor Samadder
	 * @description: "Delete Job by id in DB"
	 * @param: jobId
	 * @return: ResponseEntity<Response>
	 * @URI: localhost:8080/api/v1/job/{jobId}
	 */
	@DeleteMapping("/{jobId}")
	public ResponseEntity<Response> deleteJob(@PathVariable(value = "jobId") String jobId) {
		logger.info("inside job controller Delete method:::::::::::::::::::");
		Response response = new Response(ResponseEnum.SUCCESS.toString(), null, jobService.deleteJob(jobId));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
