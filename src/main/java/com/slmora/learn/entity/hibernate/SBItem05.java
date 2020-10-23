/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/18/2020 9:02 PM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/18/2020 9:02 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/18/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_ITEM_05")
public class SBItem05
{
    final static Logger LOGGER = LogManager.getLogger(SBItem05.class);

    @Id
    @Column(name = "item_05_id", columnDefinition = "BINARY(16)")
    private byte[] item05Id;

    @Column (name = "item_05_id_name")
    private String item05IdName;

    @Column (name = "item_05_name")
    private String item05Name;

    @Column (name = "item_05_description")
    private String item05Description;

    @Column (name = "item_05_qty_on_hand")
    private Integer item05QtyOnHand;

    @Column (name = "item_05_measure_unit")
    private String item05MeasureUnit;

    @Column (name = "item_05_unit_price")
    private Double item05UnitPrice;

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

    @Column (name = "item_05_category")
    private String item05Category;
}
