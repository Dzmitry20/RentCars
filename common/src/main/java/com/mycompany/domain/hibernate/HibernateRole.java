package com.mycompany.domain.hibernate;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "roles")
@EqualsAndHashCode(exclude = {
        "users"
})
public class HibernateRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id")
    )
    @JsonIgnoreProperties("roles")
    private Set<HibernateUser> users = Collections.emptySet();

}
