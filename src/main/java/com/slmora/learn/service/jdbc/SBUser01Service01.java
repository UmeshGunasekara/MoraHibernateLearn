/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/17/2020 5:31 PM
 */
package com.slmora.learn.service.jdbc;

import com.slmora.learn.dto.jdbc.SBUser01Dto;
import com.slmora.learn.entity.jdbc.SBUser01;

import java.util.List;
import java.util.UUID;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/17/2020 5:31 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/17/2020      SLMORA                Initial Code
 */
public interface SBUser01Service01
{
    public UUID addSBUser01(SBUser01 sbUser01);

    public SBUser01 getSBUser01ById(UUID sbUser01Id);

    public void deleteSBUser01(SBUser01 sbUser01);

    public List<SBUser01> getAllSBUser01();

    public UUID addSBUser01FromSBUser01Dto(SBUser01Dto sbUser01Dto);
}
