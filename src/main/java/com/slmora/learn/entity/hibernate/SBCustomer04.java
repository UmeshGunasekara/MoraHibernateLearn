/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/21/2020 9:10 PM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/21/2020 9:10 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/21/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_CUSTOMER_04")
public class SBCustomer04
{
    @Id
    @Column(name = "customer_04_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] customer04Id;

    @ElementCollection
    @CollectionTable(name = "SB_CUSTOMER_ORDER_01", joinColumns = @JoinColumn(name = "customer_04_id"))
    private Set <SBCustomerOrder> customer04Orders = new HashSet();

    @Column (name = "customer_04_email")
    private String customer04Email;

    @Column (name = "customer_04_sex")
    private String customer04Sex;

    @Column (name = "customer_04_first_name")
    private String customer04FirstName;

    @Column (name = "customer_04_last_name")
    private String customer04LastName;

    @Column (name = "customer_04_nic")
    private String customer04Nic;

    @Column (name = "customer_04_mobile")
    private String customer04Mobile;

    @Column (name = "customer_04_birthday")
    @Temporal(TemporalType.DATE)
    private Date customer04Birthday;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "addressStreet",
                    column = @Column(name = "customer_04_address_street")),
            @AttributeOverride(
                    name = "addressVillage",
                    column = @Column(name = "customer_04_address_village")),
            @AttributeOverride(
                    name = "addressCity",
                    column = @Column(name = "customer_04_address_city")),
            @AttributeOverride(
                    name = "addressCountry",
                    column = @Column(name = "customer_04_address_country")),
            @AttributeOverride(
                    name = "addressZip",
                    column = @Column(name = "customer_04_address_zip"))
    })
    private SBAddressVal01 customer04Address;

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
