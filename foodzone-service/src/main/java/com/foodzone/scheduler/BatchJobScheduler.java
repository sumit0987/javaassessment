package com.foodzone.scheduler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class BatchJobScheduler {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	
	@Autowired
	Job job;
	
	
	@Scheduled(fixedRate = 100000)
	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		Map<String, JobParameter> parameters=new HashMap<>();
		parameters.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters=new JobParameters(parameters);
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		System.out.println("JobExecution:  "+jobExecution.getStatus());
		if(jobExecution.isRunning()) {
			System.out.println("running-----------------");
		}
		

	return jobExecution.getStatus();
	}
	
	
}
