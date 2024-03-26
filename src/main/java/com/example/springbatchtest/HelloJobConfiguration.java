package com.example.springbatchtest;

import com.example.springbatchtest.entity.Member;
import com.example.springbatchtest.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class HelloJobConfiguration { // Job 정의


    @Bean
    public Job simpleJob(JobRepository jobRepository, Step simpleStep1, Step simpleStep2) {
        return new JobBuilder("simpleJob4", jobRepository)
                .start(simpleStep1)
                .next(simpleStep2)
                .build();
    }

    @Bean
    public Step simpleStep1(JobRepository jobRepository, Tasklet testTasklet, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("simpleStep3", jobRepository)
                .allowStartIfComplete(true)
                .tasklet(testTasklet, platformTransactionManager).build();
    }

    @Bean
    public Step simpleStep2(JobRepository jobRepository, Tasklet testTasklet, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("simpleStep4", jobRepository)
                .allowStartIfComplete(true)
                .tasklet(testTasklet, platformTransactionManager).build();
    }

    @Bean
    public Tasklet testTasklet() {
        return ((contribution, chunkContext) -> {
            log.info(">>>>> This is Step1");
            return RepeatStatus.FINISHED;
        });
    }



}
