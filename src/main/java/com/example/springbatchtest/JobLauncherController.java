package com.example.springbatchtest;

import com.example.springbatchtest.entity.Member;
import com.example.springbatchtest.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class JobLauncherController {

    private final MemberService memberService;
    private final JobLauncher jobLauncher;

    @Autowired
    Job job;

//    @GetMapping("/test")
//    public String handle() throws Exception{
//        jobLauncher.run(job, new JobParameters());
//
//        return "test";
//    }

    @GetMapping("/save")
    public String saveMember(){
        memberService.saveMember();
        return "정상";
    }

    @GetMapping("/find")
    public String findMember(){
        log.info("값 = {}", memberService.findMember());
        return "정상";
    }


}