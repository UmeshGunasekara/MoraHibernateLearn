/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/17/2020 8:25 PM
 */
package com.slmora.learn.dao.jdbc.impl;

import com.slmora.learn.common.db.connection.pool.ApacheCommonsDBCPDataSource;
import com.slmora.learn.common.db.connection.pool.C3poDataSource;
import com.slmora.learn.common.db.connection.pool.HikariCPDataSource;
import com.slmora.learn.common.util.HexUtils;
import com.slmora.learn.common.util.UuidUtilities;
import com.slmora.learn.dao.jdbc.SBUser01Dao;
import com.slmora.learn.entity.jdbc.SBUser01;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.UUID;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/17/2020 8:25 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/17/2020      SLMORA                Initial Code
 */
public class SBUser01DaoImpl implements SBUser01Dao
{
    final static Logger LOGGER = LogManager.getLogger(SBUser01DaoImpl.class);

    UuidUtilities uuidUtilities = new UuidUtilities();

    @Override
    public UUID addSBUser01(SBUser01 sbUser01)
    {
        long startTime = System.nanoTime();
        UUID retunID = null;
//        byte[] byteUserId = hexUtils.convertStringToUnHexByteArrayWithApacheCommons(uuidUtilities.getOrderedUUIDString(sbUser01.getUser01Id()));
        byte[] byteUserId = uuidUtilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(sbUser01.getUser01Id());
        String query = "INSERT INTO SB_USER_01 " +
                "(user_01_id, " +
                "user_01_first_name, " +
                "user_01_last_name, " +
                "user_01_full_name, " +
                "user_01_user_name, " +
                "user_01_email, " +
                "user_01_address, " +
                "user_01_country, " +
                "user_01_state, " +
                "user_01_zip, " +
                "raw_last_update_date_time, " +
                "raw_last_update_log_id, " +
                "update_user_account_id, " +
                "raw_show_status, " +
                "raw_update_status, " +
                "raw_delete_status, " +
                "raw_active_status, " +
                "extra_01, " +
                "extra_02, " +
                "extra_03," +
                "user_01_id_name)" +
                "VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = HikariCPDataSource.getConnection()){
            connection.setAutoCommit(false);
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setBytes(1,byteUserId);
                preparedStatement.setString(2,sbUser01.getUser01FirstName());
                preparedStatement.setString(3,sbUser01.getUser01LastName());
                preparedStatement.setString(4,sbUser01.getUser01FullName());
                preparedStatement.setString(5,sbUser01.getUser01UserName());
                preparedStatement.setString(6,sbUser01.getUser01Email());
                preparedStatement.setString(7,sbUser01.getUser01Address());
                preparedStatement.setString(8,sbUser01.getUser01Country());
                preparedStatement.setString(9,sbUser01.getUser01State());
                preparedStatement.setString(10,sbUser01.getUser01Zip());
                preparedStatement.setTimestamp(11,sbUser01.getRawLastUpdateDateTime());
                preparedStatement.setInt(12,sbUser01.getRawLastUpdateLogId());
                preparedStatement.setInt(13,sbUser01.getUpdateUserAccountId());
                preparedStatement.setInt(14,sbUser01.getRawShowStatus());
                preparedStatement.setInt(15,sbUser01.getRawUpdateStatus());
                preparedStatement.setInt(16,sbUser01.getRawDeleteStatus());
                preparedStatement.setInt(17,sbUser01.getRawActiveStatus());
                preparedStatement.setString(18,sbUser01.getExtra01());
                preparedStatement.setString(19,sbUser01.getExtra02());
                preparedStatement.setString(20,sbUser01.getExtra03());
                preparedStatement.setString(21,sbUser01.getUser01Id().toString());
                int i = preparedStatement.executeUpdate();
                connection.commit();
                retunID = (i > 0) ? sbUser01.getUser01Id() : retunID;
            } catch (SQLException throwables) {
                try{
                    connection.rollback();
                } catch (SQLException ex1) {
                    LOGGER.error(ExceptionUtils.getFullStackTrace(ex1));
                    ex1.printStackTrace();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(throwables));
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwables));
            throwables.printStackTrace();
        }
        long endTime = System.nanoTime();
        LOGGER.info("addSBUser01 for user ID "+ retunID + " ELAPSED_TIME "+ (endTime - startTime));
        return retunID;
    }

    @Override
    public SBUser01 getSBUser01ById(UUID sbUser01Id)
    {
        long startTime = System.nanoTime();
        byte[] byteUserId = uuidUtilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(sbUser01Id);
        SBUser01 sbUser01 = new SBUser01();
        String query = "SELECT * FROM SB_USER_01 WHERE user_01_id = ?";
        ResultSet resultSet = null;
        try (Connection connection = HikariCPDataSource.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setBytes(1,byteUserId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    sbUser01.setUser01Id(uuidUtilities.getUUIDFromOrderedUUIDByteArrayWithApacheCommons(resultSet.getBytes("user_01_id")));
                    sbUser01.setUser01FirstName(resultSet.getString("user_01_first_name"));
                    sbUser01.setUser01IdName(resultSet.getString("user_01_id_name"));
                    sbUser01.setUser01LastName(resultSet.getString("user_01_last_name"));
                    sbUser01.setUser01FullName(resultSet.getString("user_01_full_name"));
                    sbUser01.setUser01UserName(resultSet.getString("user_01_user_name"));
                    sbUser01.setUser01Email(resultSet.getString("user_01_email"));
                    sbUser01.setUser01Address(resultSet.getString("user_01_address"));
                    sbUser01.setUser01Country(resultSet.getString("user_01_country"));
                    sbUser01.setUser01State(resultSet.getString("user_01_state"));
                    sbUser01.setUser01Zip(resultSet.getString("user_01_zip"));
                    sbUser01.setRawLastUpdateDateTime(resultSet.getTimestamp("raw_last_update_date_time"));
                    sbUser01.setRawLastUpdateLogId(resultSet.getInt("raw_last_update_log_id"));
                    sbUser01.setUpdateUserAccountId(resultSet.getInt("update_user_account_id"));
                    sbUser01.setRawShowStatus(resultSet.getInt("raw_show_status"));
                    sbUser01.setRawUpdateStatus(resultSet.getInt("raw_update_status"));
                    sbUser01.setRawDeleteStatus(resultSet.getInt("raw_delete_status"));
                    sbUser01.setRawActiveStatus(resultSet.getInt("raw_active_status"));
                    sbUser01.setExtra01(resultSet.getString("extra_01"));
                    sbUser01.setExtra02(resultSet.getString("extra_02"));
                    sbUser01.setExtra03(resultSet.getString("extra_03"));
                }
            }
        } catch (SQLException throwables) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwables));
            throwables.printStackTrace();
        }finally {
            try {
                if(resultSet!=null){
                    resultSet.close();
                }
            } catch (SQLException throwables) {
                LOGGER.error(ExceptionUtils.getFullStackTrace(throwables));
                throwables.printStackTrace();
            }
        }
        long endTime = System.nanoTime();
        LOGGER.info("getSBUser01ById for user ID "+ sbUser01.getUser01Id() + " ELAPSED_TIME "+ (endTime - startTime));
        return sbUser01;
    }

    @Override
    public void deleteSBUser01(SBUser01 sbUser01)
    {

    }

    @Override
    public List<SBUser01> getAllSBUser01()
    {
        return null;
    }
}
