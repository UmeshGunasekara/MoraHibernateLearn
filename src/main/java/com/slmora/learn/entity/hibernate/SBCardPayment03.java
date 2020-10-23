/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/23/2020 8:13 PM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/23/2020 8:13 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/23/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
public class SBCardPayment03  extends SBPayment03
{
    final static Logger LOGGER = LogManager.getLogger(SBCardPayment03.class);

    @Column(name = "payment_03_card_number")
    private String payment03CardNumber;
}
