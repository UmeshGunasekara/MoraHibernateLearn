/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/20/2020 11:04 PM
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
 * @DateTime: 10/20/2020 11:04 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/20/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_CUSTOMER_01")
public class SBCustomer01
{
    final static Logger LOGGER = LogManager.getLogger(SBCustomer01.class);

    @Id
    @Column(name = "customer_01_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] customer01Id;

    @Column (name = "customer_01_email")
    private String customer01Email;

    @Column (name = "customer_01_sex")
    private String customer01Sex;

    @Column (name = "customer_01_first_name")
    private String customer01FirstName;

    @Column (name = "customer_01_last_name")
    private String customer01LastName;

    @Column (name = "customer_01_nic")
    private String customer01Nic;

    @Column (name = "customer_01_mobile")
    private String customer01Mobile;

    @Column (name = "customer_01_birthday")
    @Temporal(TemporalType.DATE)
    private Date customer01Birthday;

    @Column (name = "customer_01_address")
    private String customer01Address;

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
