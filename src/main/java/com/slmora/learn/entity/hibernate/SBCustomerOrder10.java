/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/23/2020 2:18 AM
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
 * @DateTime: 10/23/2020 2:18 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/23/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_CUSTOMER_ORDER_10")
public class SBCustomerOrder10
{
    @Id
    @Column(name = "customer_order_10_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] customerOrder10Id;

    @ManyToOne
    @JoinColumn(name = "customer_14_id")
    private SBCustomer14 sbCustomer14;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "SB_CUSTOMER_ORDER_10_ITEM_11",
            joinColumns = @JoinColumn(name = "customer_order_10_id"),
            inverseJoinColumns = @JoinColumn(name = "item_12_id")
    )
    private Collection<SBItem12> customerOrder10Items = new ArrayList();

    @Column(name = "customer_order_10_invoice_number")
    private String customerOrder10InvoiceNumber;

    @Column (name = "customer_order_10_date_time")
    private Timestamp customerOrder10DateTime;

    @Column (name = "customer_order_10_total")
    private Double customerOrder10Total;

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
