package com.cssru.webapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "people")
public class Person {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String surname;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String lastname;

    @Column (nullable = false)
    private Integer age;

    public String getFullname() {
        return new StringBuilder(surname).append(" ").append(name).append(" ").append(lastname).toString();
    }
}
