/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/23/2020 8:44 PM
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
 * @DateTime: 10/23/2020 8:44 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/23/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
public class SBChequePayment04 extends SBPayment04
{
    final static Logger LOGGER = LogManager.getLogger(SBChequePayment04.class);

    @Column(name = "payment_04_cheque_number")
    private String payment04chequeNumber;
}