package test.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column (nullable = false)
    private String login;

    @Column (nullable = false)
    private String password;

    @Column
    private Boolean locked;

    @Column
    private Boolean expired;

    @Column
    private Boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
