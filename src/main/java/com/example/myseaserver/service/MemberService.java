package com.example.myseaserver.service;


import com.example.myseaserver.dto.MemberDTO;
import com.example.myseaserver.entity.MemberEntity;
import com.example.myseaserver.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public MemberDTO login(MemberDTO memberDTO) {
        Optional<MemberEntity> byMemberId = memberRepository.findByMemberId(memberDTO.getMemberId());
        if (byMemberId.isPresent()) {
            MemberEntity memberEntity = byMemberId.get();
            if (memberEntity.getMemberPw().equals(memberDTO.getMemberPw())) {
                return MemberDTO.toMemberDTO(memberEntity);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
