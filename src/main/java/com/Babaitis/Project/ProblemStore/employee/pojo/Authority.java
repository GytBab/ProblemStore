package com.Babaitis.Project.ProblemStore.employee.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Authority implements GrantedAuthority {

    @Serial
    private static final long serialVersionUID = -2759184906241814492L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String name;
    private String description;

    @Override
    public String getAuthority() {
        return "ROLE_" + name;
    }
}
