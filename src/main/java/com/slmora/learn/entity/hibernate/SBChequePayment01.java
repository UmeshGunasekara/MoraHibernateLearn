/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/23/2020 6:04 PM
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
 * @DateTime: 10/23/2020 6:04 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/23/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
public class SBChequePayment01
        extends SBPayment01
{
    final static Logger LOGGER = LogManager.getLogger(SBChequePayment01.class);

    @Column(name = "payment_01_cheque_number")
    private String payment01chequeNumber;
}
