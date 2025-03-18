package com.example.demo.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

    List<Member> findByName(String name);
}
