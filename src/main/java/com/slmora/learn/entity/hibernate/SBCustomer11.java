/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/23/2020 12:00 AM
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
import java.util.Date;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/23/2020 12:00 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/23/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_CUSTOMER_11")
public class SBCustomer11
{
    @Id
    @Column(name = "customer_11_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] customer11Id;

    @OneToMany(mappedBy = "sbCustomer11")
    private Collection<SBCustomerOrder07> customer11Orders = new ArrayList();

    @Column (name = "customer_11_email")
    private String customer11Email;

    @Column (name = "customer_11_sex")
    private String customer11Sex;

    @Column (name = "customer_11_first_name")
    private String customer11FirstName;

    @Column (name = "customer_11_last_name")
    private String customer11LastName;

    @Column (name = "customer_11_nic")
    private String customer11Nic;

    @Column (name = "customer_11_mobile")
    private String customer11Mobile;

    @Column (name = "customer_11_birthday")
    @Temporal(TemporalType.DATE)
    private Date customer11Birthday;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "addressStreet",
                    column = @Column(name = "customer_11_address_street")),
            @AttributeOverride(
                    name = "addressVillage",
                    column = @Column(name = "customer_11_address_village")),
            @AttributeOverride(
                    name = "addressCity",
                    column = @Column(name = "customer_11_address_city")),
            @AttributeOverride(
                    name = "addressCountry",
                    column = @Column(name = "customer_11_address_country")),
            @AttributeOverride(
                    name = "addressZip",
                    column = @Column(name = "customer_11_address_zip"))
    })
    private SBAddressVal01 customer11Address;

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
