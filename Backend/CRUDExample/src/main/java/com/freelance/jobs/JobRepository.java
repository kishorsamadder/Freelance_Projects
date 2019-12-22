/**
 * 
 */
package com.freelance.jobs;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kishor Samadder
 * @description This is Repository for 
 *
 */
@Repository
public interface JobRepository extends JpaRepository<Job, String> {

	Optional<Job> findByjobId(String jobId);

}
