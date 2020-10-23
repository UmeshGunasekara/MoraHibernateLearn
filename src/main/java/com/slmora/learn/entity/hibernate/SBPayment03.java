/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/23/2020 8:11 PM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/23/2020 8:11 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/23/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_PAYMENT_03")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SBPayment03 implements Cloneable
{
    final static Logger LOGGER = LogManager.getLogger(SBPayment03.class);

    @Id
    @Column(name = "payment_03_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] payment03Id;

    @Column (name = "payment_03_number")
    private String payment03Number;

    @Column (name = "payment_03_amount")
    private Double payment03Amount;

    @Column (name = "payment_03_date_time")
    private Timestamp payment03DateTime;

    @Column (name = "payment_03_description")
    private String payment03Description;

    @Column (name = "payment_03_method")
    private String payment03Method;

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

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            return SBPayment03.of(
                    this.payment03Id,
                    this.payment03Number,
                    this.payment03Amount,
                    this.payment03DateTime,
                    this.payment03Description,
                    this.payment03Method,
                    this.rawLastUpdateDateTime,
                    this.rawLastUpdateLogId,
                    this.updateUserAccountId,
                    this.rawShowStatus,
                    this.rawUpdateStatus,
                    this.rawDeleteStatus,
                    this.rawActiveStatus,
                    this.extra01,
                    this.extra02,
                    this.extra03);
        }
    }
}
