package com.toy.blog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
public class Comment {

    //기본 컬럼//

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;  //댓글 작성자

    private LocalDateTime time;

    private String text;

    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parent; //부모가 null인 경우 최상위 댓글

    //추가 연관관계//

    @OneToMany(mappedBy = "parent")
    private List<Comment> children;

}