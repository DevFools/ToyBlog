package com.toy.blog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter @Setter
public class PostCategory {

    //기본 컬럼//

    @Id @GeneratedValue
    private Long id;

    private String category;

    //추가 연관관계//

    @OneToMany(mappedBy = "postCategory")
    private List<Post> posts;



}
