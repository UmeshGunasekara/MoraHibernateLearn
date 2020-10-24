/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/25/2020 3:28 AM
 */
package com.slmora.learn.service.hibernate.impl;

import com.slmora.learn.common.dao.GenericDao;
import com.slmora.learn.common.service.impl.GenericServiceImpl;
import com.slmora.learn.dao.hibernate.SBAddress04Dao;
import com.slmora.learn.dao.hibernate.impl.SBAddress04DaoImpl;
import com.slmora.learn.entity.hibernate.SBAddress04;
import com.slmora.learn.service.hibernate.SBAddress04Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/25/2020 3:28 AM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/25/2020      SLMORA                Initial Code
 */
public class SBAddress04ServiceImpl extends GenericServiceImpl<byte[], SBAddress04> implements SBAddress04Service
{
    final static Logger LOGGER = LogManager.getLogger(SBAddress04ServiceImpl.class);

    private SBAddress04Dao sbAddress04Dao;

    public SBAddress04ServiceImpl() {
    }

    public SBAddress04ServiceImpl(GenericDao<byte[], SBAddress04> sbAddress04GenericDao){
        super(sbAddress04GenericDao);
        sbAddress04Dao = (SBAddress04Dao) sbAddress04GenericDao;
    }

    @Override
    public byte[] addSBAddress04(SBAddress04 sbAddress04)
    {
        return sbAddress04Dao.add(sbAddress04);
    }

    @Override
    public SBAddress04 getSBAddress04ById(byte[] sbAddress04Id)
    {
        return sbAddress04Dao.getSBAddress04ById(sbAddress04Id);
    }

    @Override
    public void deleteSBAddress04(SBAddress04 sbAddress04)
    {
        sbAddress04Dao.deleteSBAddress04(sbAddress04);
    }

    @Override
    public List<SBAddress04> getAllSBAddress04s()
    {
        return sbAddress04Dao.getAllSBAddress04s();
    }
}
