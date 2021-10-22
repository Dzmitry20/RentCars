package com.mycompany.domain;

import com.mycompany.domain.status.OrderStatus;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;


@Data
public class Order {

    private Long id;

    private Date receivedDate;

    private Date returnData;

    private OrderStatus orderStatus = OrderStatus.NOT_CONFIRMED;

    private User client;

    private Car car;


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
