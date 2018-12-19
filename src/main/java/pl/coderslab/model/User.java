package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.HashSet;
import java.util.Set;

@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotNull
    private Boolean enabled;

    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Tweet> tweets = new HashSet<Tweet>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(Set<Tweet> tweets) {
        this.tweets = tweets;
    }
}