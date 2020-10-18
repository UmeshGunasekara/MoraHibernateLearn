/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 9/12/2020 12:40 PM
 */
package com.slmora.learn.model;

import lombok.Data;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 9/12/2020 12:40 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          9/12/2020      SLMORA                Initial Code
 */
@Data
public class User2
{
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String address;
    private String country;
    private String state;
    private String zip;
    private String sameAddress;
    private String saveInfo;
    private String paymentMethod;
    private String ccname;
    private String ccnumber;
    private String ccexpiration;
    private String cccvv;
}
