package com.example.springbatchtest.repository;

import com.example.springbatchtest.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Member, Long> {
}
