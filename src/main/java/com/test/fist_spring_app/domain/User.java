package com.test.fist_spring_app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//lombok para nao precisar fazer os getter setter e construtores

public class User {
    private String name;
    private String email;
}
