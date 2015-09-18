package test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "people")
public class Homo {
    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column (nullable=false)
    private String surname;

    @Column (nullable=false)
    private String name;

    @Column (nullable=false)
    private String lastname;

    @Column (nullable=false)
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFullname() {
        return new StringBuilder(surname).append(" ").append(name).append(" ").append(lastname).toString();
    }

}
