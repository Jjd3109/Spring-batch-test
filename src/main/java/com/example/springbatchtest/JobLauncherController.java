package com.example.springbatchtest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class JobLauncherController {


    private final JobLauncher jobLauncher;
    private final Job job;

    @Scheduled(cron = "0/10 * * * * *")
    public void handle() throws Exception{
        jobLauncher.run(job, new JobParameters());
    }




}