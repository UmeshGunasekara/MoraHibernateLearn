/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/22/2020 10:09 PM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/22/2020 10:09 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/22/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_CUSTOMER_ORDER_06")
public class SBCustomerOrder06
{
    @Id
    @Column(name = "customer_order_06_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] customerOrder06Id;

    @ManyToOne
    @JoinColumn(name = "customer_10_id")
    private SBCustomer10 sbCustomer10;

    @Column(name = "customer_order_06_invoice_number")
    private String customerOrder06InvoiceNumber;

    @Column (name = "customer_order_06_date_time")
    private Timestamp customerOrder06DateTime;

    @Column (name = "customer_order_06_total")
    private Double customerOrder06Total;

    @Column (name = "raw_last_update_04_date_time")
    private Timestamp rawLastUpdateDateTime;

    @Column (name = "raw_last_update_log_id")
    private Integer rawLastUpdateLogId;

    @Column (name = "update_user_account_id")
    private Integer updateUserAccountId;

    @Column (name = "raw_show_status")
    private Integer rawShowStatus;

    @Column (name = "raw_update_status")
    private Integer rawUpdateStatus;

    @Column (name = "raw_delete_status")
    private Integer rawDeleteStatus;

    @Column (name = "raw_active_status")
    private Integer rawActiveStatus;

    @Column (name = "extra_01")
    private String extra01;

    @Column (name = "extra_02")
    private String extra02;

    @Column (name = "extra_03")
    private String extra03;
}
