package org.surikov.first_project.entities.accounts;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.surikov.first_project.entities.data.Comment;
import org.surikov.first_project.entities.data.Role;
import org.surikov.first_project.entities.projects.Project;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="user_accounts")
public class UserAccount implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(length = 30)
    private String name;

    @Column(length = 30)
    private String surname;

    @Column(length = 12)
    private String number;

    private String email;

    @OneToMany(mappedBy = "id")
    private Set<Comment> commentSet;

    @OneToMany(mappedBy = "id")
    private Set<Project> projectSet;

    @ManyToOne
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(getRole().getRole()));
    }

    @Override
    public String getUsername() {
        return getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
