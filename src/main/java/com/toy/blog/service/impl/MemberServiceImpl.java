package com.toy.blog.service.impl;

import com.toy.blog.domain.Member;
import com.toy.blog.repository.impl.MemberRepositoryImpl;
import com.toy.blog.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepositoryImpl memberRepository;

    //회원가입
    public Long Join(Member member) {
        //Form객체의 내용 -> Member 엔티티
        memberRepository.save(member);
        return member.getId();
    }

    //단일 회원
    public Member findMember(Long id) {
        return memberRepository.findId(id);
    }

    //keyword 조회
    public List<Member> findMembers(String keyword) {
        return memberRepository.findMemberByKeyword(keyword);
    }

    //회원정보 수정
    @Transactional
    public void updateMemberInfo(Long id, String nickname, String password, String blogName) {
        Member findMember = memberRepository.findId(id);
        findMember.setNickname(nickname);
        findMember.setPassword(password);
        findMember.setBlogName(blogName);
    }
}
