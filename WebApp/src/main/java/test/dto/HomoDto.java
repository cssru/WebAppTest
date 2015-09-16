package test.dto;

import test.validation.NotEmpty;
import test.validation.Positive;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;

/**
 * Created by css on 14.09.15.
 */

@GroupSequence({
        HomoDto.class,
        HomoDto.FirstGroup.class,
        HomoDto.SecondGroup.class})

public class HomoDto {
    @NotNull (groups = FirstGroup.class)
    @NotEmpty (groups = SecondGroup.class)
    private String surname;

    @NotNull (groups = FirstGroup.class)
    @NotEmpty (groups = SecondGroup.class)
    private String name;

    @NotNull (groups = FirstGroup.class)
    @NotEmpty (groups = SecondGroup.class)
    private String lastName;

    @NotNull (groups = FirstGroup.class)
    @Positive (groups = SecondGroup.class)
    private Integer age;

    public HomoDto() {}

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

    public interface FirstGroup {
    }

    public interface SecondGroup {
    }

}
