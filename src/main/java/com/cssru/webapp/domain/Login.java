package com.cssru.webapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table (name = "logins")
public class Login {
    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column (nullable = false, unique = true, length = 30)
    private String login;

    @Column (nullable = false, length = 255)
    private String password;

    @Column (nullable = false)
    private Boolean locked;

    @Column (nullable = false)
    private Boolean expired;

    @Column (nullable = false)
    private Boolean enabled;
}
