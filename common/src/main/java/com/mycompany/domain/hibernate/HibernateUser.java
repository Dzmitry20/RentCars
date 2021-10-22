package com.mycompany.domain.hibernate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mycompany.domain.status.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import springfox.documentation.annotations.Cacheable;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Setter
@Entity
@Table(name = "users")
@EqualsAndHashCode(exclude = {
        "orders", "roles", "photos"
})
public class HibernateUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Long phone;

    @Column(name = "passport_series" )
    private String passportSeries;

    @Column(name = "passport_number" )
    private Integer passportNumber;

    @Column
    private String email;

    @Column(name = "link_photo")
    private String linkPhoto;

    @Column(name = "driver_license_number" )
    private Integer driverLicenseNumber;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "login", column = @Column(name = "login")),
//            @AttributeOverride(name = "password", column = @Column(name = "password"))
//    })
//    private HibernateUserCredentials hibernateUserCredentials;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.NOT_SELECTED;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<HibernateOrder> orders = new HashSet<>();

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JsonIgnoreProperties("users")
    private Set<HibernateRole> roles = Collections.emptySet();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<UserPhoto> photos = Collections.emptySet();


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }



}
