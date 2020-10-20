/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/21/2020 12:20 AM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/21/2020 12:20 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/21/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_CUSTOMER_03")
public class SBCustomer03
{
    @Id
    @Column(name = "customer_03_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] customer03Id;

    @Column (name = "customer_03_email")
    private String customer03Email;

    @Column (name = "customer_03_sex")
    private String customer03Sex;

    @Column (name = "customer_03_first_name")
    private String customer03FirstName;

    @Column (name = "customer_03_last_name")
    private String customer03LastName;

    @Column (name = "customer_03_nic")
    private String customer03Nic;

    @Column (name = "customer_03_mobile")
    private String customer03Mobile;

    @Column (name = "customer_03_birthday")
    @Temporal(TemporalType.DATE)
    private Date customer03Birthday;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "addressStreet",
                    column = @Column(name = "customer_03_address_street")),
            @AttributeOverride(
                    name = "addressVillage",
                    column = @Column(name = "customer_03_address_village")),
            @AttributeOverride(
                    name = "addressCity",
                    column = @Column(name = "customer_03_address_city")),
            @AttributeOverride(
                    name = "addressCountry",
                    column = @Column(name = "customer_03_address_country")),
            @AttributeOverride(
                    name = "addressZip",
                    column = @Column(name = "customer_03_address_zip"))
    })
    private SBAddressVal01 customer03Address;

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
