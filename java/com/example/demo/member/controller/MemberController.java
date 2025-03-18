package com.example.demo.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;
    
    @PostMapping
    public ResponseEntity<MemberDto> save(@RequestBody MemberDto memberDto){
        return ResponseEntity.ok(memberService.save(memberDto));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMember(@PathVariable("id") Long id) {
        return ResponseEntity.ok(memberService.findById(id));
    }
    
    @GetMapping
    public ResponseEntity<List<MemberDto>> getMember(@RequestParam String name) {
        return ResponseEntity.ok(memberService.findByName(name));
    }
}
