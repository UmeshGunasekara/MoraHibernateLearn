/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/18/2020 11:48 AM
 */
package com.slmora.learn.entity.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/18/2020 11:48 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/18/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
public class SBItem01
{
    final static Logger LOGGER = LogManager.getLogger(SBItem01.class);

    @Id
    private UUID item01Id;
    private String item01IdName;
    private String item01Name;
    private String item01Description;
    private Integer item01QtyOnHand;
    private String item01MeasureUnit;
    private Double item01UnitPrice;
    private Timestamp rawLastUpdateDateTime;
    private Integer rawLastUpdateLogId;
    private Integer updateUserAccountId;
    private Integer rawShowStatus;
    private Integer rawUpdateStatus;
    private Integer rawDeleteStatus;
    private Integer rawActiveStatus;
    private String extra01;
    private String extra02;
    private String extra03;
    private String item01Category;
}
