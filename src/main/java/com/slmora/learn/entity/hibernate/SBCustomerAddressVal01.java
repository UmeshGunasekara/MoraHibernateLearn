/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/20/2020 11:51 PM
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
 * @DateTime: 10/20/2020 11:51 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/20/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Embeddable
public class SBCustomerAddressVal01
{
    final static Logger LOGGER = LogManager.getLogger(SBCustomerAddressVal01.class);

    @Column(name = "customer_02_address_street")
    private String customer02AddressStreet;

    @Column (name = "customer_02_address_village")
    private String customer02AddressVillage;

    @Column (name = "customer_02_address_city")
    private String customer02AddressCity;

    @Column (name = "customer_02_address_country")
    private String customer02AddressCountry;

    @Column (name = "customer_02_address_zip")
    private String customer02AddressZip;

}
