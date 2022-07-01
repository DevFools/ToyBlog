package com.toy.blog.service;

import com.toy.blog.domain.Member;

import java.util.List;


public interface MemberService {

    Long Join(Member member);

    Member findMember(Long id);

    List<Member> findMembers(String keyword);

    void updateMemberInfo(Long id, String nickname, String password, String blogName);
}
