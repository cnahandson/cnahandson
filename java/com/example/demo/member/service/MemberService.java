package com.example.demo.member.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    
    public MemberDto save(MemberDto memberDto) {
        return MemberDto.toDto(memberRepository.save(memberDto.toEntity()));
    }
    
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
    
    public MemberDto findById(Long id) {
        return MemberDto.toDto(memberRepository.findById(id).get());
    }
    
    public List<MemberDto> findByName(String name) {
        List<Member> members = memberRepository.findByName(name);
        return members.stream()
                .map(m -> MemberDto.toDto(m))
                .collect(Collectors.toList());
    }
}
