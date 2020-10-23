/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/21/2020 7:54 PM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/21/2020 7:54 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/21/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Embeddable
public class SBCustomerOrder
{
    final static Logger LOGGER = LogManager.getLogger(SBCustomerOrder.class);

    @Column (name = "customer_order_invoice_number")
    private String customerOrderInvoiceNumber;

    @Column (name = "customer_order_date_time")
    private Timestamp customerOrderDateTime;

    @Column (name = "customer_order_total")
    private Double customerOrderTotal;

}
