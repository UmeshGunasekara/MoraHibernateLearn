/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/21/2020 9:50 PM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/21/2020 9:50 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/21/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_CUSTOMER_05")
public class SBCustomer05
{
    @Id
    @Column(name = "customer_05_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] customer05Id;

    @ElementCollection
    @CollectionTable(name = "SB_CUSTOMER_ORDER_02", joinColumns = @JoinColumn(name = "customer_05_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "customerOrder01InvoiceNumber", column = @Column(name = "customer_order_02_invoice_number")),
            @AttributeOverride(name = "customerOrder01DateTime", column = @Column(name = "customer_order_02_date_time")),
            @AttributeOverride(name = "customerOrder01Total", column = @Column(name = "customer_order_02_total"))
    })
    @GenericGenerator(name = "mora-uuid-generator",
            strategy="increment")
    @CollectionId(
            columns = {@Column(name = "customer_order_02_id")},
            generator = "mora-uuid-generator",
            type = @Type(type = "long")
    )
    private Collection<SBCustomerOrder> customer05Orders = new ArrayList();

//    @ElementCollection
//    @CollectionTable(name = "SB_CUSTOMER_ORDER_02", joinColumns = @JoinColumn(name = "customer_05_id"))
//    @AttributeOverrides({
//            @AttributeOverride(name = "customerOrder01InvoiceNumber", column = @Column(name = "customer_order_02_invoice_number")),
//            @AttributeOverride(name = "customerOrder01DateTime", column = @Column(name = "customer_order_02_date_time")),
//            @AttributeOverride(name = "customerOrder01Total", column = @Column(name = "customer_order_02_total"))
//    })
//    @GenericGenerator(name = "mora-uuid-generator",
//            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
//    @CollectionId(
//            columns = {@Column(name = "customer_order_02_id")},
//            generator = "mora-uuid-generator",
//            type = @Type(type = "binary")
//    )
//    private Collection<SBCustomerOrder01> customer05Orders = new ArrayList();

//    @ElementCollection
//    @JoinTable (
//            name = "SB_CUSTOMER_ORDER_02",
//            joinColumns = @JoinColumn(name = "customer_05_id")
//    )
//    @GenericGenerator(name="sequence-gen",strategy="sequence")
//    @CollectionId(
//            columns = {@Column(name = "customer_order_02_id")},
//            generator = "sequence-gen",
//            type = @Type(type = "long")
//    )
//    private Collection<SBCustomerOrder01> customer05Orders = new ArrayList();

    @Column (name = "customer_05_email")
    private String customer05Email;

    @Column (name = "customer_05_sex")
    private String customer05Sex;

    @Column (name = "customer_05_first_name")
    private String customer05FirstName;

    @Column (name = "customer_05_last_name")
    private String customer05LastName;

    @Column (name = "customer_05_nic")
    private String customer05Nic;

    @Column (name = "customer_05_mobile")
    private String customer05Mobile;

    @Column (name = "customer_05_birthday")
    @Temporal(TemporalType.DATE)
    private Date customer05Birthday;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "addressStreet",
                    column = @Column(name = "customer_05_address_street")),
            @AttributeOverride(
                    name = "addressVillage",
                    column = @Column(name = "customer_05_address_village")),
            @AttributeOverride(
                    name = "addressCity",
                    column = @Column(name = "customer_05_address_city")),
            @AttributeOverride(
                    name = "addressCountry",
                    column = @Column(name = "customer_05_address_country")),
            @AttributeOverride(
                    name = "addressZip",
                    column = @Column(name = "customer_05_address_zip"))
    })
    private SBAddressVal01 customer05Address;

    @Column (name = "raw_last_update_date_time")
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
