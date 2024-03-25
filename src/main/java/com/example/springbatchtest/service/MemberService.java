package com.example.springbatchtest.service;

import com.example.springbatchtest.entity.Member;
import com.example.springbatchtest.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final LoginRepository loginRepository;

    //아이디 생성
    public Member saveMember(){
        Member member = Member.builder().
                email("email").
                password("1234").
                build();


        return loginRepository.save(member);

    }

    //아이디 조회
    public Member findMember(){
        return loginRepository.findById(1L).get();

    }


}
