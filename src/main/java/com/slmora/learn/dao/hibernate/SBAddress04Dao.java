/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/25/2020 3:20 AM
 */
package com.slmora.learn.dao.hibernate;

import com.slmora.learn.common.dao.GenericDao;
import com.slmora.learn.entity.hibernate.SBAddress04;

import java.util.List;

/**
 * This Interface created for
 *
 * @Author: SLMORA
 * @DateTime: 10/25/2020 3:20 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/25/2020      SLMORA                Initial Code
 */
public interface SBAddress04Dao extends GenericDao<byte[], SBAddress04>
{
    public byte[] addSBAddress04(SBAddress04 sbAddress04);

    public SBAddress04 getSBAddress04ById(byte[] sbAddress04Id);

    public void deleteSBAddress04(SBAddress04 sbAddress04);

    public List<SBAddress04> getAllSBAddress04s();
}
