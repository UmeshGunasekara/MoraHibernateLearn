/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/23/2020 11:07 PM
 */
package com.slmora.learn;

import com.slmora.learn.common.hibernate.HibernateEntityManagerUtil;
import com.slmora.learn.entity.hibernate.SBCardPayment04;
import com.slmora.learn.entity.hibernate.SBChequePayment04;
import com.slmora.learn.entity.hibernate.SBPayment04;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Transaction;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Timestamp;
import java.util.Date;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/23/2020 11:07 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/23/2020      SLMORA                Initial Code
 */
@DisplayName("Testing Hibernate Entity Manager Samples")
public class UnitTestHibernateEntityManagerSampleApp
{
    TestInfo testInfo;
    TestReporter testReporter;
    long ELAPSED_TIME;
    final static Logger LOGGER = LogManager.getLogger(UnitTestHibernateEntityManagerSampleApp.class);

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
    @DisplayName("Test Insert SB Payment 04 and SB Card Payment 04 and SB Cheque Payment 04")
    public void testHibernateEntityManagerSavePayment04CardPayment04ChequePayment04(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBPayment04 payment = new SBPayment04();
        payment.setPayment04Number("PY000001");
        payment.setPayment04Method("Cash");
        payment.setPayment04Amount(350.00);
        payment.setPayment04DateTime(new Timestamp(new Date().getTime()));
        payment.setPayment04Description("Cash payment");
        payment.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
        payment.setRawLastUpdateLogId(1);
        payment.setUpdateUserAccountId(1);
        payment.setRawActiveStatus(1);
        payment.setRawDeleteStatus(1);
        payment.setRawShowStatus(1);
        payment.setRawUpdateStatus(1);

        SBCardPayment04 cardPayment = new SBCardPayment04();
        cardPayment.setPayment04Number("PY000002");
        cardPayment.setPayment04Method("Card");
        cardPayment.setPayment04Amount(240.00);
        cardPayment.setPayment04DateTime(new Timestamp(new Date().getTime()));
        cardPayment.setPayment04Description("Card payment");
        cardPayment.setPayment04CardNumber("9765-1237-8239-9381");
        cardPayment.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
        cardPayment.setRawLastUpdateLogId(1);
        cardPayment.setUpdateUserAccountId(1);
        cardPayment.setRawActiveStatus(1);
        cardPayment.setRawDeleteStatus(1);
        cardPayment.setRawShowStatus(1);
        cardPayment.setRawUpdateStatus(1);

        SBChequePayment04 chequePayment = new SBChequePayment04();
        chequePayment.setPayment04Number("PY000003");
        chequePayment.setPayment04Method("Cheque");
        chequePayment.setPayment04Amount(10825.00);
        chequePayment.setPayment04DateTime(new Timestamp(new Date().getTime()));
        chequePayment.setPayment04Description("Cheque payment");
        chequePayment.setPayment04chequeNumber("976-234567-234-234567-12");
        chequePayment.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
        chequePayment.setRawLastUpdateLogId(1);
        chequePayment.setUpdateUserAccountId(1);
        chequePayment.setRawActiveStatus(1);
        chequePayment.setRawDeleteStatus(1);
        chequePayment.setRawShowStatus(1);
        chequePayment.setRawUpdateStatus(1);

        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = HibernateEntityManagerUtil.getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(payment);
            entityManager.persist(cardPayment);
            entityManager.persist(chequePayment);

            entityManager.getTransaction().commit();

            System.out.println("Added Payment: "+ payment.getPayment04Number());
            System.out.println("Added Card Payment: "+ cardPayment.getPayment04Number());
            System.out.println("Added Cheque Payment: "+ chequePayment.getPayment04Number());

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
