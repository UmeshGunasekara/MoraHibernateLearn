/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/23/2020 12:46 AM
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
 * @DateTime: 10/23/2020 12:46 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/23/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_CUSTOMER_12")
public class SBCustomer12
{
    @Id
    @Column(name = "customer_12_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] customer12Id;

    @OneToMany(mappedBy = "sbCustomer12")
    private Collection<SBCustomerOrder08> customer12Orders = new ArrayList();

    @Column (name = "customer_12_email")
    private String customer12Email;

    @Column (name = "customer_12_sex")
    private String customer12Sex;

    @Column (name = "customer_12_first_name")
    private String customer12FirstName;

    @Column (name = "customer_12_last_name")
    private String customer12LastName;

    @Column (name = "customer_12_nic")
    private String customer12Nic;

    @Column (name = "customer_12_mobile")
    private String customer12Mobile;

    @Column (name = "customer_12_birthday")
    @Temporal(TemporalType.DATE)
    private Date customer12Birthday;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "addressStreet",
                    column = @Column(name = "customer_12_address_street")),
            @AttributeOverride(
                    name = "addressVillage",
                    column = @Column(name = "customer_12_address_village")),
            @AttributeOverride(
                    name = "addressCity",
                    column = @Column(name = "customer_12_address_city")),
            @AttributeOverride(
                    name = "addressCountry",
                    column = @Column(name = "customer_12_address_country")),
            @AttributeOverride(
                    name = "addressZip",
                    column = @Column(name = "customer_12_address_zip"))
    })
    private SBAddressVal01 customer12Address;

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
