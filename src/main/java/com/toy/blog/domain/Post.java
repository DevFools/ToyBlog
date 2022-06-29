package com.toy.blog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
public class Post {

    //기본 컬럼//

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    private String article;

    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "postCategory_id")
    private PostCategory postCategory;

    private Long view;

    //추가 연관관계//

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
