/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/17/2020 8:05 PM
 */
package com.slmora.learn.dto.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/17/2020 8:05 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/17/2020      SLMORA                Initial Code
 */
@Data
@AllArgsConstructor(staticName = "of")
public class SBUser01Dto
{
    private String user01FirstName;
    private String user01LastName;
    private String user01FullName;
    private String user01UserName;
    private String user01Email;
    private String user01Address;
    private String user01Country;
    private String user01State;
    private String user01Zip;
}
