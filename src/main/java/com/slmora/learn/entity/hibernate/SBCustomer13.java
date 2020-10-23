/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/23/2020 1:20 AM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/23/2020 1:20 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/23/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_CUSTOMER_13")
public class SBCustomer13
{
    final static Logger LOGGER = LogManager.getLogger(SBCustomer13.class);

    @Id
    @Column(name = "customer_13_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] customer13Id;

    @OneToMany(mappedBy = "sbCustomer13")
    private Collection<SBCustomerOrder09> customer13Orders = new ArrayList();

    @Column (name = "customer_13_email")
    private String customer13Email;

    @Column (name = "customer_13_sex")
    private String customer13Sex;

    @Column (name = "customer_13_first_name")
    private String customer13FirstName;

    @Column (name = "customer_13_last_name")
    private String customer13LastName;

    @Column (name = "customer_13_nic")
    private String customer13Nic;

    @Column (name = "customer_13_mobile")
    private String customer13Mobile;

    @Column (name = "customer_13_birthday")
    @Temporal(TemporalType.DATE)
    private Date customer13Birthday;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "addressStreet",
                    column = @Column(name = "customer_13_address_street")),
            @AttributeOverride(
                    name = "addressVillage",
                    column = @Column(name = "customer_13_address_village")),
            @AttributeOverride(
                    name = "addressCity",
                    column = @Column(name = "customer_13_address_city")),
            @AttributeOverride(
                    name = "addressCountry",
                    column = @Column(name = "customer_13_address_country")),
            @AttributeOverride(
                    name = "addressZip",
                    column = @Column(name = "customer_13_address_zip"))
    })
    private SBAddressVal01 customer13Address;

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
