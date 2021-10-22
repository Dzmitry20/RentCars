package com.mycompany.domain.hibernate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_photos")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {
        "user"
})
public class UserPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String link;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private HibernateUser user;

    public UserPhoto(String link) {
        this.link = link;
    }
}
