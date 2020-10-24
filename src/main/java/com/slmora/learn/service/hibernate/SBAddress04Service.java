/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/25/2020 3:27 AM
 */
package com.slmora.learn.service.hibernate;

import com.slmora.learn.common.service.GenericService;
import com.slmora.learn.entity.hibernate.SBAddress04;

import java.util.List;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/25/2020 3:27 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/25/2020      SLMORA                Initial Code
 */
public interface SBAddress04Service extends GenericService<byte[], SBAddress04>
{
    public byte[] addSBAddress04(SBAddress04 sbAddress04);

    public SBAddress04 getSBAddress04ById(byte[] sbAddress04Id);

    public void deleteSBAddress04(SBAddress04 sbAddress04);

    public List<SBAddress04> getAllSBAddress04s();
}
