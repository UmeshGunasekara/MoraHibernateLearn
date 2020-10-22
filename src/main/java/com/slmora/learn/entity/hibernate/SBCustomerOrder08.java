/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/23/2020 12:47 AM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/23/2020 12:47 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/23/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_CUSTOMER_ORDER_08")
public class SBCustomerOrder08
{
    @Id
    @Column(name = "customer_order_08_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] customerOrder08Id;

    @ManyToOne
    @JoinColumn(name = "customer_12_id")
    private SBCustomer12 sbCustomer12;

    @ManyToMany
    @JoinTable(
            name = "SB_CUSTOMER_ORDER_08_ITEM_11",
            joinColumns = @JoinColumn(name = "customer_order_08_id"),
            inverseJoinColumns = @JoinColumn(name = "item_11_id")
    )
    private Collection<SBItem11> customerOrder08Items = new ArrayList();

    @Column(name = "customer_order_08_invoice_number")
    private String customerOrder08InvoiceNumber;

    @Column (name = "customer_order_08_date_time")
    private Timestamp customerOrder08DateTime;

    @Column (name = "customer_order_08_total")
    private Double customerOrder08Total;

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
