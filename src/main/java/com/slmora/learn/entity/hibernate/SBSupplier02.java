/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/22/2020 1:09 AM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/22/2020 1:09 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/22/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "SB_SUPPLIER_02")
public class SBSupplier02
{
    @Id
    @Column(name = "supplier_02_id", columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "mora-uuid-generator")
    @GenericGenerator(name = "mora-uuid-generator",
            strategy = "com.slmora.learn.common.hibernate.MoraUUIDGenerator")
    private byte[] supplier02Id;

    @Column (name = "supplier_02_email")
    private String supplier02Email;

    @Column (name = "supplier_02_owner_sex")
    private String supplier02OwnerSex;

    @Column (name = "supplier_02_owner_name")
    private String supplier02OwnerName;

    @Column (name = "supplier_02_owner_birthday")
    @Temporal(TemporalType.DATE)
    private Date supplier02OwnerBirthday;

    @Column (name = "supplier_02_owner_mobile")
    private String supplier02OwnerMobile;

    @OneToOne
    private SBAddress01 supplier02OwnerAddress;

    @Column (name = "supplier_02_business_name")
    private String supplier02BusinessName;

    @Column (name = "supplier_02_brn")
    private String supplier02Brn;

    @Column (name = "supplier_02_business_mobile")
    private String supplier02BusinessMobile;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "addressStreet",
                    column = @Column(name = "supplier_02_business_address_street")),
            @AttributeOverride(
                    name = "addressVillage",
                    column = @Column(name = "supplier_02_business_address_village")),
            @AttributeOverride(
                    name = "addressCity",
                    column = @Column(name = "supplier_02_business_address_city")),
            @AttributeOverride(
                    name = "addressCountry",
                    column = @Column(name = "supplier_02_business_address_country")),
            @AttributeOverride(
                    name = "addressZip",
                    column = @Column(name = "supplier_02_business_address_zip"))
    })
    private SBAddressVal01 supplier02BusinessAddress;

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
