/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/17/2020 8:04 PM
 */
package com.slmora.learn.service.jdbc.impl;

import com.slmora.learn.dao.jdbc.SBUser01Dao;
import com.slmora.learn.dao.jdbc.impl.SBUser01DaoImpl;
import com.slmora.learn.dto.jdbc.SBUser01Dto;
import com.slmora.learn.entity.jdbc.SBUser01;
import com.slmora.learn.service.jdbc.SBUser01Service01;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/17/2020 8:04 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/17/2020      SLMORA                Initial Code
 */
public class SBUser01Service01Impl implements SBUser01Service01
{
    private SBUser01Dao sbUser01Dao;

    public SBUser01Service01Impl(){
        this.sbUser01Dao = new SBUser01DaoImpl();
    }

    @Override
    public UUID addSBUser01(SBUser01 sbUser01)
    {
        return sbUser01Dao.addSBUser01(sbUser01);
    }

    @Override
    public SBUser01 getSBUser01ById(UUID sbUser01Id)
    {
        return sbUser01Dao.getSBUser01ById(sbUser01Id);
    }

    @Override
    public void deleteSBUser01(SBUser01 sbUser01)
    {
        sbUser01Dao.deleteSBUser01(sbUser01);
    }

    @Override
    public List<SBUser01> getAllSBUser01()
    {
        return sbUser01Dao.getAllSBUser01();
    }

    @Override
    public UUID addSBUser01FromSBUser01Dto(SBUser01Dto sbUser01Dto){

        UUID uuid = UUID.randomUUID();

        SBUser01 sbUser01 = SBUser01.of(
                uuid,
                uuid.toString(),
                sbUser01Dto.getUser01FirstName(),
                sbUser01Dto.getUser01LastName(),
                sbUser01Dto.getUser01FullName(),
                sbUser01Dto.getUser01UserName(),
                sbUser01Dto.getUser01Email(),
                sbUser01Dto.getUser01Address(),
                sbUser01Dto.getUser01Country(),
                sbUser01Dto.getUser01State(),
                sbUser01Dto.getUser01Zip(),
                new Timestamp(new java.util.Date().getTime()),
                1,
                1,
                1,
                1,
                1,
                1,
                null,
                null,
                null);

        return addSBUser01(sbUser01);
    }
}
