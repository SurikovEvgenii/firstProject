package org.surikov.first_project.entities.accounts;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.surikov.first_project.entities.data.Comment;
import org.surikov.first_project.entities.data.ProfilePicture;
import org.surikov.first_project.entities.data.Role;
import org.surikov.first_project.entities.projects.Project;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name="designers")
public class DesignerAccount implements UserDetails {

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

    @Column
    private String number;

    private String email;

    private String telegram;

    private String whatsapp;

    private Long countFollowers;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Project> projectSet;

    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    private Set<Comment> commentSet;

    @ManyToOne
    private Role role;

    @OneToOne
    private ProfilePicture profilePicture;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DesignerAccount that = (DesignerAccount) o;
        return Objects.equals(id, that.id) && Objects.equals(login, that.login) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }

    @Override
    public String toString() {
        return "DesignerAccount{" +
                "role=" + role +
                ", commentSet=" + commentSet +
                ", projectSet=" + projectSet +
                ", countFollowers=" + countFollowers +
                ", whatsapp='" + whatsapp + '\'' +
                ", telegram='" + telegram + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", id=" + id +
                '}';
    }

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
