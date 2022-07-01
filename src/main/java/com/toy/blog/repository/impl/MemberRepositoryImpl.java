package com.toy.blog.repository.impl;

import com.toy.blog.domain.Member;
import com.toy.blog.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final EntityManager em;

    //회원 저장
    public void save(Member member) {
        em.persist(member);
    }

    //단일 회원 조회
    public Member findId(Long id) {
        return em.find(Member.class, id);
    }

    //키워드를 통한 회원 조회
    public List<Member> findMemberByKeyword(String keyword) {
        String jpql = "select m from Member m where m.uid like %:keyword% or m.nickname like %:keyword% or m.blogName like %:keyword%";
        return em.createQuery(jpql, Member.class)
                .setParameter("keyword", keyword)
                .getResultList();
    }


}
