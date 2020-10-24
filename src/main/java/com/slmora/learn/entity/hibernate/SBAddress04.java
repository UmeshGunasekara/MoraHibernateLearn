/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/24/2020 8:50 PM
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

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/24/2020 8:50 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/24/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@NamedQuery(name = "SBAddress04.getFromZip", query = "from SBAddress04 where address04Zip = ?1")
@NamedNativeQuery(name = "SBAddress04.getFromStreetNative", query = "SELECT * FROM SB_ADDRESS_04 WHERE address_04_street = ?1", resultClass = SBAddress04.class)
@Table(name = "SB_ADDRESS_04")
public class SBAddress04
{
    final static Logger LOGGER = LogManager.getLogger(SBAddress04.class);

    @Id
    @Column(name = "address_04_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] address04Id;

    @Column(name = "address_04_street")
    private String address04Street;

    @Column (name = "address_04_village")
    private String address04Village;

    @Column (name = "address_04_city")
    private String address04City;

    @Column (name = "address_04_country")
    private String address04Country;

    @Column (name = "address_04_zip")
    private String address04Zip;

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
