/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/21/2020 12:24 AM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/21/2020 12:24 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/21/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Embeddable
public class SBAddressVal01
{
    final static Logger LOGGER = LogManager.getLogger(SBAddressVal01.class);

    @Column(name = "address_street")
    private String addressStreet;

    @Column (name = "address_village")
    private String addressVillage;

    @Column (name = "address_city")
    private String addressCity;

    @Column (name = "address_country")
    private String addressCountry;

    @Column (name = "address_zip")
    private String addressZip;
}
