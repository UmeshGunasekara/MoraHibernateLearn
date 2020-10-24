/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/25/2020 3:22 AM
 */
package com.slmora.learn.dao.hibernate.impl;

import com.slmora.learn.common.dao.impl.GenericDaoImpl;
import com.slmora.learn.dao.hibernate.SBAddress04Dao;
import com.slmora.learn.entity.hibernate.SBAddress04;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/25/2020 3:22 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/25/2020      SLMORA                Initial Code
 */
public class SBAddress04DaoImpl extends GenericDaoImpl<byte[], SBAddress04> implements SBAddress04Dao
{
    final static Logger LOGGER = LogManager.getLogger(SBAddress04DaoImpl.class);

    @Override
    public byte[] addSBAddress04(SBAddress04 sbAddress04)
    {
        return add(sbAddress04);
    }

    @Override
    public SBAddress04 getSBAddress04ById(byte[] sbAddress04Id)
    {
        return getByKey(sbAddress04Id);
    }

    @Override
    public void deleteSBAddress04(SBAddress04 sbAddress04)
    {
        delete(sbAddress04);
    }

    @Override
    public List<SBAddress04> getAllSBAddress04s()
    {
        return getAll();
    }
}
