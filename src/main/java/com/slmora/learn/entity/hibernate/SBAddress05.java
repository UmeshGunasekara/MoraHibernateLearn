/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/25/2020 1:35 AM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/25/2020 1:35 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/25/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "SB_ADDRESS_05")
public class SBAddress05
{
    final static Logger LOGGER = LogManager.getLogger(SBAddress05.class);

    @Id
    @Column(name = "address_05_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] address05Id;

    @Column(name = "address_05_street")
    private String address05Street;

    @Column(name = "address_05_village")
    private String address05Village;

    @Column(name = "address_05_city")
    private String address05City;

    @Column(name = "address_05_country")
    private String address05Country;

    @Column(name = "address_05_zip")
    private String address05Zip;

    @Column(name = "raw_last_update_date_time")
    private Timestamp rawLastUpdateDateTime;

    @Column(name = "raw_last_update_log_id")
    private Integer rawLastUpdateLogId;

    @Column(name = "update_user_account_id")
    private Integer updateUserAccountId;

    @Column(name = "raw_show_status")
    private Integer rawShowStatus;

    @Column(name = "raw_update_status")
    private Integer rawUpdateStatus;

    @Column(name = "raw_delete_status")
    private Integer rawDeleteStatus;

    @Column(name = "raw_active_status")
    private Integer rawActiveStatus;

    @Column(name = "extra_01")
    private String extra01;

    @Column(name = "extra_02")
    private String extra02;

    @Column(name = "extra_03")
    private String extra03;
}
