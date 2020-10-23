/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/23/2020 8:43 PM
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
 * @DateTime: 10/23/2020 8:43 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/23/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_PAYMENT_04")
@Inheritance(strategy = InheritanceType.JOINED)
public class SBPayment04 implements Cloneable
{
    final static Logger LOGGER = LogManager.getLogger(SBPayment04.class);

    @Id
    @Column(name = "payment_04_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] payment04Id;

    @Column (name = "payment_04_number")
    private String payment04Number;

    @Column (name = "payment_04_amount")
    private Double payment04Amount;

    @Column (name = "payment_04_date_time")
    private Timestamp payment04DateTime;

    @Column (name = "payment_04_description")
    private String payment04Description;

    @Column (name = "payment_04_method")
    private String payment04Method;

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
            return SBPayment04.of(
                    this.payment04Id,
                    this.payment04Number,
                    this.payment04Amount,
                    this.payment04DateTime,
                    this.payment04Description,
                    this.payment04Method,
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
