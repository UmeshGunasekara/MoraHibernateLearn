/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/18/2020 5:12 PM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/18/2020 5:12 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/18/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table (name = "SB_ITEM_03")
public class SBItem03
{
    final static Logger LOGGER = LogManager.getLogger(SBItem03.class);

    @Id
    @Column(name = "item_03_id")
    private UUID item03Id;

    @Column (name = "item_03_id_name")
    private String item03IdName;

    @Column (name = "item_03_name")
    private String item03Name;

    @Column (name = "item_03_description")
    @Basic
    private String item03Description;

    @Column (name = "item_03_qty_on_hand")
    private Integer item03QtyOnHand;

    @Column (name = "item_03_measure_unit")
    private String item03MeasureUnit;

    @Column (name = "item_03_unit_price")
    private Double item03UnitPrice;

    @Column (name = "raw_last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rawLastUpdateDateTime;

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
    @Lob
    private String extra02;

    @Column (name = "extra_03")
    @Transient
    private String extra03;

    @Column (name = "item_03_category")
    private String item03Category;
}
