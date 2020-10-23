/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/24/2020 2:13 AM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/24/2020 2:13 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/24/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@SelectBeforeUpdate
@Table(name = "SB_ADDRESS_03")
public class SBAddress03
{
    final static Logger LOGGER = LogManager.getLogger(SBAddress03.class);

    @Id
    @Column(name = "address_03_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] address03Id;

    @Column(name = "address_03_street")
    private String address03Street;

    @Column (name = "address_03_village")
    private String address03Village;

    @Column (name = "address_03_city")
    private String address03City;

    @Column (name = "address_03_country")
    private String address03Country;

    @Column (name = "address_03_zip")
    private String address03Zip;

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
