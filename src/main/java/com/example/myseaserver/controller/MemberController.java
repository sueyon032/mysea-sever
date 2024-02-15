package com.example.myseaserver.controller;

import com.example.myseaserver.dto.MemberDTO;
import com.example.myseaserver.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
//@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/join-save")  // 회원가입
    public ResponseEntity<String> saveMember(@RequestBody MemberDTO memberDTO) {
        try {
            System.out.println("Received MemberDTO: " + memberDTO); // 값 전달 확인용

            memberService.save(memberDTO); // Member 저장

            return ResponseEntity.ok("회원가입 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입 실패");
        }
    }

}