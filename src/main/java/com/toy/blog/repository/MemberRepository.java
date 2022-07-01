package com.toy.blog.repository;

import com.toy.blog.domain.Member;

import java.util.List;

public interface MemberRepository {

    void save(Member member);

    Member findId(Long id);

    List<Member> findMemberByKeyword(String keyword);
}
