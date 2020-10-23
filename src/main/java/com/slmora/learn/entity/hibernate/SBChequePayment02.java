/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/23/2020 7:35 PM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/23/2020 7:35 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/23/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@DiscriminatorValue("CHEQUE")
public class SBChequePayment02
        extends SBPayment02
{
    final static Logger LOGGER = LogManager.getLogger(SBChequePayment02.class);

    @Column(name = "payment_02_cheque_number")
    private String payment02chequeNumber;

}
