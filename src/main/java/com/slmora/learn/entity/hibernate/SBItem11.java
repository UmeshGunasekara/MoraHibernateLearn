/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/23/2020 12:49 AM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/23/2020 12:49 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/23/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_ITEM_11")
public class SBItem11
{
    @Id
    @Column(name = "item_11_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] item11Id;

    @ManyToMany(mappedBy = "customerOrder08Items")
    private Collection<SBCustomerOrder08> item11Orders = new ArrayList();

    @Column (name = "item_11_name")
    private String item11Name;

    @Column (name = "item_11_description")
    private String item11Description;

    @Column (name = "item_11_qty_on_hand")
    private Integer item11QtyOnHand;

    @Column (name = "item_11_measure_unit")
    private String item11MeasureUnit;

    @Column (name = "item_11_unit_price")
    private Double item11UnitPrice;

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
