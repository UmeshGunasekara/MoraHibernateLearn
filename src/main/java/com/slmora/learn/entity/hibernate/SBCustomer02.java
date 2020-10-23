/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/20/2020 11:50 PM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/20/2020 11:50 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/20/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_CUSTOMER_02")
public class SBCustomer02
{
    final static Logger LOGGER = LogManager.getLogger(SBCustomer02.class);

    @Id
    @Column(name = "customer_02_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] customer02Id;

    @Column (name = "customer_02_email")
    private String customer02Email;

    @Column (name = "customer_02_sex")
    private String customer02Sex;

    @Column (name = "customer_02_first_name")
    private String customer02FirstName;

    @Column (name = "customer_02_last_name")
    private String customer02LastName;

    @Column (name = "customer_02_nic")
    private String customer02Nic;

    @Column (name = "customer_02_mobile")
    private String customer02Mobile;

    @Column (name = "customer_02_birthday")
    @Temporal(TemporalType.DATE)
    private Date customer02Birthday;

    @Embedded
    private SBCustomerAddressVal01 customer02Address;

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
