/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/18/2020 10:01 PM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/18/2020 10:01 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/18/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_ITEM_06")
public class SBItem06
{
    final static Logger LOGGER = LogManager.getLogger(SBItem06.class);

    @Id
    @Column(name = "item_06_id")
    @GeneratedValue
    private int item06Id;

    @Column (name = "item_06_id_name")
    private String item06IdName;

    @Column (name = "item_06_name")
    private String item06Name;

    @Column (name = "item_06_description")
    private String item06Description;

    @Column (name = "item_06_qty_on_hand")
    private Integer item06QtyOnHand;

    @Column (name = "item_06_measure_unit")
    private String item06MeasureUnit;

    @Column (name = "item_06_unit_price")
    private Double item06UnitPrice;

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

    @Column (name = "item_06_category")
    private String item06Category;
}
