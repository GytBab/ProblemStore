package com.Babaitis.Project.ProblemStore.employee.pojo;

import com.Babaitis.Project.ProblemStore.laser_data.Laser_data;
import com.Babaitis.Project.ProblemStore.position.Position;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID employeeUuid;
    private String name;
    private String surname;
    private String email;
    private String password;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Authority> authorities;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position positionId;
    @OneToMany(mappedBy = "team_lead")
    private List<Laser_data> laserDataList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return name + ' ' + surname;
    }
}
