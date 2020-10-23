/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/18/2020 7:49 PM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/18/2020 7:49 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/18/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table (name = "SB_ITEM_04")
public class SBItem04
{
    final static Logger LOGGER = LogManager.getLogger(SBItem04.class);

    @Id
    @Column(name = "item_04_id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID item04Id;

    @Column (name = "item_04_id_name")
    private String item04IdName;

    @Column (name = "item_04_name")
    private String item04Name;

    @Column (name = "item_04_description")
    private String item04Description;

    @Column (name = "item_04_qty_on_hand")
    private Integer item04QtyOnHand;

    @Column (name = "item_04_measure_unit")
    private String item04MeasureUnit;

    @Column (name = "item_04_unit_price")
    private Double item04UnitPrice;

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

    @Column (name = "item_04_category")
    private String item04Category;
}
