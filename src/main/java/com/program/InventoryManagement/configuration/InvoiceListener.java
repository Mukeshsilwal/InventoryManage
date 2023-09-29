package com.program.InventoryManagement.configuration;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class InvoiceListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Job Start at "+jobExecution.getStartTime());
        System.out.println("Job Status "+jobExecution.getStatus());


    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("Job End at "+jobExecution.getEndTime());
        System.out.println("Status of the job "+jobExecution.getStatus());

    }
}
