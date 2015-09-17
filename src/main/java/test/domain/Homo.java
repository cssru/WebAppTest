package test.domain;


import javax.persistence.*;

/**
 * Created by css on 14.09.15.
 */
@Entity
@Table(name="people")
public class Homo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column (name="surname")
    private String surname;

    @Column (name="name")
    private String name;

    @Column (name="lastname")
    private String lastName;

    @Column (name="age")
    private Integer age;

    public Homo() {}

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringBuilder(surname).append(" ").append(name).append(" ").append(lastName)
                .append(", ").append(age).append(getSuffix(age)).append(" ").toString();
    }

    private String getSuffix(int num) {
        int lastCypher = num % 10;
        if (lastCypher == 1) return "год";
        if (lastCypher > 1 && lastCypher < 5) return "года";
        return "лет";
    }
}
