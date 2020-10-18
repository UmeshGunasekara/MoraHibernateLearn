/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/17/2020 1:17 AM
 */
package com.slmora.learn.entity.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/17/2020 1:17 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/17/2020      SLMORA                Initial Code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SBUser01
{
    private UUID user01Id;
    private String user01IdName;
    private String user01FirstName;
    private String user01LastName;
    private String user01FullName;
    private String user01UserName;
    private String user01Email;
    private String user01Address;
    private String user01Country;
    private String user01State;
    private String user01Zip;
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

}
