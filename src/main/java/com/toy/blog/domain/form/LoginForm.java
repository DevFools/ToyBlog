package com.toy.blog.domain.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginForm {

    @NotEmpty
    private String uid;

    @NotEmpty
    private String password;
}
