/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/18/2020 12:29 PM
 */
package com.slmora.learn;

import com.slmora.learn.common.hibernate.HibernateUtil;
import com.slmora.learn.common.util.UuidUtilities;
import com.slmora.learn.entity.hibernate.*;
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
                "Milk");

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
                "Milk");

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

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Item 03")
    public void testHibernateSaveItem03(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();
        UUID uuid = UUID.randomUUID();

        SBItem03 sbItem03 = SBItem03.of(
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
                "Milk");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbItem03);
            transaction.commit();
            System.out.println("Added Item 01 : "+ sbItem03.getItem03Name());
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
    @DisplayName("Test Insert SB Item 04")
    public void testHibernateSaveItem04(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();
        UUID uuid = UUID.randomUUID();

        SBItem04 sbItem04 = SBItem04.of(
                uuid,
                uuid.toString(),
                "Newdail Frsh Milk 1L",
                "Frsh Milk",
                50,
                "Litter",
                668.50,
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
                "Milk");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbItem04);
            transaction.commit();
            System.out.println("Added Item 04 : "+ sbItem04.getItem04Name());
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
    @DisplayName("Test Get SB Item 04")
    public void testHibernateGetItem04(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();
        SBItem04 sbItem04 = null;

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            sbItem04 = session.get(SBItem04.class,UUID.fromString("95f2e1b9-50ee-4063-a503-838d92011cc0"));
            transaction.commit();
            System.out.println("Get Item 04 : "+ sbItem04.getItem04Name());
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
    @DisplayName("Test Insert SB Item 05")
    public void testHibernateSaveItem05(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();
        UuidUtilities uuidUtilities = new UuidUtilities();
        UUID uuid = UUID.randomUUID();

        SBItem05 sbItem05 = SBItem05.of(
                uuidUtilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(uuid),
                uuid.toString(),
                "Newdail Frsh Milk 1L",
                "Frsh Milk",
                50,
                "Litter",
                668.50,
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
                "Milk");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbItem05);
            transaction.commit();
            System.out.println("Added Item 05 : "+ sbItem05.getItem05Name());
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
    @DisplayName("Test Get SB Item 05")
    public void testHibernateGetItem05(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();
        UuidUtilities uuidUtilities = new UuidUtilities();
        SBItem05 sbItem05 = null;

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            sbItem05 = session.get(SBItem05.class, uuidUtilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString("eeb877e5-91f8-481e-87c2-8eccc276a8ba")));
            transaction.commit();
            System.out.println("Get Item 05 : "+ sbItem05.getItem05Name());
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
    @DisplayName("Test Insert SB Item 06")
    public void testHibernateSaveItem06(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();
        UuidUtilities uuidUtilities = new UuidUtilities();
        UUID uuid = UUID.randomUUID();

        SBItem06 sbItem06A = new SBItem06();
        sbItem06A.setItem06Name("MORA Frsh Milk 1L");

        SBItem06 sbItem06B = new SBItem06();
        sbItem06B.setItem06Name("MORA Frsh Milk 2L");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbItem06A);
            session.save(sbItem06B);
            transaction.commit();
            System.out.println("Added Item 06 A : "+ sbItem06A.getItem06Name());
            System.out.println("Added Item 05 B : "+ sbItem06B.getItem06Name());
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
