/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/24/2020 12:56 PM
 */
package com.slmora.learn;

import com.slmora.learn.common.hibernate.HibernateAnoUtil;
import com.slmora.learn.common.hibernate.HibernateUtil;
import com.slmora.learn.common.util.UuidUtilities;
import com.slmora.learn.entity.hibernate.SBAddress02;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.*;

import java.util.List;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/24/2020 12:56 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/24/2020      SLMORA                Initial Code
 */
@DisplayName("Testing Hibernate Anno Samples")
public class UnitTestHibernateAnoSampleApp
{
    TestInfo testInfo;
    TestReporter testReporter;
    long ELAPSED_TIME;
    final static Logger LOGGER = LogManager.getLogger(UnitTestHibernateAnoSampleApp.class);

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
     *
     * to add data to table get execute testCRUDCreateWithAddress02
     * */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test HQL Query for Where with Address 02")
    public void testHQLQueryForWhereWithAddress02(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        UuidUtilities utilities = new UuidUtilities();
        List<SBAddress02> addresses = null;


        Transaction transaction = null;
        try (Session session = HibernateAnoUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();

            Query query = session.createQuery("from SBAddress02 where address02Zip like '%1%'");
            addresses = query.list();

            transaction.commit();

            addresses.forEach(address -> System.out.println("Added Address : "+ address.getAddress02Street()));

        } catch (Throwable throwable) {
            if(transaction !=null){
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address : "+ addresses.size());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }
}
