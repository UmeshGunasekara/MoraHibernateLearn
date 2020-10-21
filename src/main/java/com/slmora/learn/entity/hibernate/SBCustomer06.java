/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/22/2020 12:26 AM
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/22/2020 12:26 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/22/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_CUSTOMER_06")
public class SBCustomer06
{
    @Id
    @Column(name = "customer_06_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] customer06Id;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "SB_customer_order_03", joinColumns = @JoinColumn(name = "customer_06_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "customerOrder01InvoiceNumber", column = @Column(name = "customer_order_03_invoice_number")),
            @AttributeOverride(name = "customerOrder01DateTime", column = @Column(name = "customer_order_03_date_time")),
            @AttributeOverride(name = "customerOrder01Total", column = @Column(name = "customer_order_03_total"))
    })
    @GenericGenerator(name = "mora-uuid-generator",
            strategy="increment")
    @CollectionId(
            columns = {@Column(name = "customer_order_03_id")},
            generator = "mora-uuid-generator",
            type = @Type(type = "long")
    )
    private Collection<SBCustomerOrder> customer06Orders = new ArrayList();

    @Column (name = "customer_06_email")
    private String customer06Email;

    @Column (name = "customer_06_sex")
    private String customer06Sex;

    @Column (name = "customer_06_first_name")
    private String customer06FirstName;

    @Column (name = "customer_06_last_name")
    private String customer06LastName;

    @Column (name = "customer_06_nic")
    private String customer06Nic;

    @Column (name = "customer_06_mobile")
    private String customer06Mobile;

    @Column (name = "customer_06_birthday")
    @Temporal(TemporalType.DATE)
    private Date customer06Birthday;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "addressStreet",
                    column = @Column(name = "customer_06_address_street")),
            @AttributeOverride(
                    name = "addressVillage",
                    column = @Column(name = "customer_06_address_village")),
            @AttributeOverride(
                    name = "addressCity",
                    column = @Column(name = "customer_06_address_city")),
            @AttributeOverride(
                    name = "addressCountry",
                    column = @Column(name = "customer_06_address_country")),
            @AttributeOverride(
                    name = "addressZip",
                    column = @Column(name = "customer_06_address_zip"))
    })
    private SBAddressVal01 customer06Address;

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
