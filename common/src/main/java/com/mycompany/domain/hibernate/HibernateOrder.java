package com.mycompany.domain.hibernate;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mycompany.domain.Car;
import com.mycompany.domain.User;
import com.mycompany.domain.status.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
@EqualsAndHashCode(exclude = {
        "contract"
})

public class HibernateOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "received_date" )
    private Timestamp receivedDate;

    @Column(name = "return_date" )
    private Timestamp returnData;

    @Column(name = "order_status" )
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.NOT_CONFIRMED;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private HibernateUser user;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private HibernateContract contract;


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
