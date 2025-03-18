package com.example.demo.member.dto;

import com.example.demo.member.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {

    private Long id;
    
    private String name;
    
    private String team;
    
    private String type;
    
    public static MemberDto toDto(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .team(member.getTeam())
                .type(member.getType())
                .build();
    }
    
    public Member toEntity() {
        return Member.builder()
                .id(this.id)
                .name(this.name)
                .team(this.team)
                .type(this.type)
                .build();
    }
}
