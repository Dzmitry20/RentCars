package com.mycompany.domain;

import com.mycompany.domain.status.ContractStatus;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;
import java.util.Date;


@Data
public class Contract {

    private String id;

    private Long numberContract;

    private LocalDateTime paymentDate;

    private Double totalPrice;

    private Order order;

    private ContractStatus contractStatus = ContractStatus.AWAITING_PAYMENT;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
