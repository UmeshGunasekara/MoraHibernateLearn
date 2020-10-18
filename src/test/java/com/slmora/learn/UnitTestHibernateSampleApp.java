/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/18/2020 12:29 PM
 */
package com.slmora.learn;

import com.slmora.learn.common.hibernate.HibernateUtil;
import com.slmora.learn.entity.hibernate.SBItem01;
import com.slmora.learn.entity.hibernate.SBItem02;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.*;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/18/2020 12:29 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/18/2020      SLMORA                Initial Code
 */
@DisplayName("Testing Hibernate Samples")
public class UnitTestHibernateSampleApp
{
    TestInfo testInfo;
    TestReporter testReporter;
    long ELAPSED_TIME;
    final static Logger LOGGER = LogManager.getLogger(UnitTestHibernateSampleApp.class);

    /**
     * Runs this method before initialize this test class
     * */
    @BeforeAll
    public static void beforeAllInit()
    {
        System.out.println("Before all initialized .......");
    }

    /**
     * Runs this method before each test execution
     * @param testInfo, testReporter to inject reporting information
     * */
    @BeforeEach
    public void beforeEachInit(TestInfo testInfo, TestReporter testReporter)
    {
        this.testInfo =  testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + "with tags " + testInfo.getTags() + "\n");

    }

    /**
     * Runs this method after each test execution
     * */
    @AfterEach
    private void afterEachEnd()
    {
        System.out.println("Test Completed "+testInfo.getDisplayName());
        System.out.println("After Each Clean Test........");
        System.out.println("Elapsed TIme : " + ELAPSED_TIME + " ns");
        LOGGER.info("Elapsed TIme for "+testInfo.getDisplayName()+" : " +ELAPSED_TIME);
    }

    /**
     * This method runs After all Test Cases execution
     * This must be static because of this will execute after instance destroyed
     * */
    @AfterAll
    public static void AfterAllInit()
    {
        System.out.println("After All Initiated........");
    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Basic Thread")
    public void testHibernateSaveItem01UsingHibernateUtil(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();
        UUID uuid = UUID.randomUUID();

        SBItem01 sbItem01 = SBItem01.of(
                uuid,
                uuid.toString(),
                "Anchor Frsh Milk 1L",
                "Frsh Milk",
                150,
                "Litter",
                568.50,
                new Timestamp(new java.util.Date().getTime()),
                1,
                1,
                1,
                1,
                1,
                1,
                null,
                null,
                null,
                UUID.fromString("e2dcf2f7-f6a8-48ec-a314-bb941aa1bcb1"));

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbItem01);
            transaction.commit();
            System.out.println("Added Item 01 : "+ sbItem01.getItem01Name());
        } catch (Throwable throwable) {
            if(transaction !=null){
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }
        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Item 02")
    public void testHibernateSaveItem02(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();
        UUID uuid = UUID.randomUUID();

        SBItem02 sbItem02 = SBItem02.of(
                uuid,
                uuid.toString(),
                "Anchor Frsh Milk 1L",
                "Frsh Milk",
                150,
                "Litter",
                568.50,
                new Timestamp(new java.util.Date().getTime()),
                1,
                1,
                1,
                1,
                1,
                1,
                null,
                null,
                null,
                UUID.fromString("e2dcf2f7-f6a8-48ec-a314-bb941aa1bcb1"));

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbItem02);
            transaction.commit();
            System.out.println("Added Item 01 : "+ sbItem02.getItem02Name());
        } catch (Throwable throwable) {
            if(transaction !=null){
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }
        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

}
