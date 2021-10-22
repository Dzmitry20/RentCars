package com.mycompany.domain.hibernate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mycompany.domain.Order;
import com.mycompany.domain.status.ContractStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "contracts")

public class HibernateContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_contract")
    private Long numberContract;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "contract_status")
    @Enumerated(EnumType.STRING)
    private ContractStatus contractStatus = ContractStatus.AWAITING_PAYMENT;

    @OneToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private HibernateOrder order;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}


