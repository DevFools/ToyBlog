package com.toy.blog.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@Rollback(false)
public class domainTest {

    @Autowired
    private EntityManager em;

    @Test
    public void 엔티티테스트() {
        //회원가입
        Member m1 = new Member();
        m1.setUid("account1");
        m1.setPassword("1234");
        m1.setNickname("계정1");
        m1.setBlogName("계정1의 블로그");
        em.persist(m1);
        Member found = em.find(Member.class, m1.getId());
        Assert.assertEquals(found, m1);

        //글쓰기
        Post post = new Post();
        post.setMember(m1);
        post.setTitle("본문입니다.");
        post.setArticle("제목입니다");
        post.setTime(LocalDateTime.now());
        em.persist(post);
        Post foundPost = em.find(Post.class, post.getId());
        Assert.assertEquals(foundPost, post);

        //댓글쓰기
        Comment comment = new Comment();
        comment.setMember(m1);
        comment.setPost(post);
        comment.setText("댓글입니다");
        comment.setTime(LocalDateTime.now());
        em.persist(comment);
        Comment foundComment = em.find(Comment.class, comment.getId());
        Assert.assertEquals(foundComment, comment);
    }

}