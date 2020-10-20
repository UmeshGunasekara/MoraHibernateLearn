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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        SBItem06 sbItem06A = new SBItem06();
        sbItem06A.setItem06Name("Anchor Frsh Milk 1L");

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

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Item 07")
    public void testHibernateSaveItem07(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBItem07 sbItem07A = new SBItem07();
        sbItem07A.setItem07Name("Anchor Frsh Milk 1L");

        SBItem07 sbItem07B = new SBItem07();
        sbItem07B.setItem07Name("MORA Frsh Milk 2L");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbItem07A);
            session.save(sbItem07B);
            transaction.commit();
            System.out.println("Added Item 06 A : "+ sbItem07A.getItem07Name());
            System.out.println("Added Item 05 B : "+ sbItem07B.getItem07Name());
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
    @DisplayName("Test Insert SB Item 08")
    public void testHibernateSaveItem08(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBItem08 sbItem08A = new SBItem08();
        sbItem08A.setItem08Name("Anchor Frsh Milk 1L");

        SBItem08 sbItem08B = new SBItem08();
        sbItem08B.setItem08Name("MORA Frsh Milk 2L");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbItem08A);
            session.save(sbItem08B);
            transaction.commit();
            System.out.println("Added Item 06 A : "+ sbItem08A.getItem08Name());
            System.out.println("Added Item 05 B : "+ sbItem08B.getItem08Name());
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
    @DisplayName("Test Insert SB Item 09")
    public void testHibernateSaveItem09(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBItem09 sbItem09A = new SBItem09();
        sbItem09A.setItem09Name("Anchor Frsh Milk 1L");

        SBItem09 sbItem09B = new SBItem09();
        sbItem09B.setItem09Name("MORA Frsh Milk 2L");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbItem09A);
            session.save(sbItem09B);
            transaction.commit();
            System.out.println("Added Item 06 A : "+ sbItem09A.getItem09Name());
            System.out.println("Added Item 05 B : "+ sbItem09B.getItem09Name());
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
    @DisplayName("Test Insert SB Customer 01")
    public void testHibernateSaveCustomer01(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBCustomer01 sbCustomer01 = new SBCustomer01();
        sbCustomer01.setCustomer01Email("umesh@slmora.com");
        sbCustomer01.setCustomer01Sex("Male");
        sbCustomer01.setCustomer01FirstName("Umesh");
        sbCustomer01.setCustomer01LastName("Gunasekara");
        sbCustomer01.setCustomer01Nic("901521344V");
        sbCustomer01.setCustomer01Mobile("0711233000");
        try {
            sbCustomer01.setCustomer01Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer01.setCustomer01Address("Kusumarama Road, Seenigama, Hikkaduwa, Sri Lanka, 292000");
        sbCustomer01.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer01.setRawLastUpdateLogId(1);
        sbCustomer01.setUpdateUserAccountId(1);
        sbCustomer01.setRawActiveStatus(1);
        sbCustomer01.setRawDeleteStatus(1);
        sbCustomer01.setRawShowStatus(1);
        sbCustomer01.setRawUpdateStatus(1);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbCustomer01);
            transaction.commit();
            System.out.println("Added Customer: "+ sbCustomer01.getCustomer01FirstName());
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
    @DisplayName("Test Insert SB Customer 02")
    public void testHibernateSaveCustomer02(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBCustomerAddressVal01 addressVal01 = SBCustomerAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomer02 sbCustomer02 = new SBCustomer02();
        sbCustomer02.setCustomer02Email("umesh@slmora.com");
        sbCustomer02.setCustomer02Sex("Male");
        sbCustomer02.setCustomer02FirstName("Umesh");
        sbCustomer02.setCustomer02LastName("Gunasekara");
        sbCustomer02.setCustomer02Nic("901521344V");
        sbCustomer02.setCustomer02Mobile("0711233000");
        try {
            sbCustomer02.setCustomer02Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer02.setCustomer02Address(addressVal01);
        sbCustomer02.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer02.setRawLastUpdateLogId(1);
        sbCustomer02.setUpdateUserAccountId(1);
        sbCustomer02.setRawActiveStatus(1);
        sbCustomer02.setRawDeleteStatus(1);
        sbCustomer02.setRawShowStatus(1);
        sbCustomer02.setRawUpdateStatus(1);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbCustomer02);
            transaction.commit();
            System.out.println("Added Customer: "+ sbCustomer02.getCustomer02FirstName());
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
    @DisplayName("Test Insert SB Customer 03 and SB Supplier 01")
    public void testHibernateSaveCustomer03AndSupplier01(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomer03 sbCustomer03 = new SBCustomer03();
        sbCustomer03.setCustomer03Email("umesh@slmora.com");
        sbCustomer03.setCustomer03Sex("Male");
        sbCustomer03.setCustomer03FirstName("Umesh");
        sbCustomer03.setCustomer03LastName("Gunasekara");
        sbCustomer03.setCustomer03Nic("901521344V");
        sbCustomer03.setCustomer03Mobile("0711233000");
        try {
            sbCustomer03.setCustomer03Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer03.setCustomer03Address(addressVal01);
        sbCustomer03.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer03.setRawLastUpdateLogId(1);
        sbCustomer03.setUpdateUserAccountId(1);
        sbCustomer03.setRawActiveStatus(1);
        sbCustomer03.setRawDeleteStatus(1);
        sbCustomer03.setRawShowStatus(1);
        sbCustomer03.setRawUpdateStatus(1);

        SBSupplier01 sbSupplier01 = new SBSupplier01();
        sbSupplier01.setSupplier01Email("umesh@slmora.com");
        sbSupplier01.setSupplier01OwnerSex("Male");
        sbSupplier01.setSupplier01OwnerName("Umesh");
        sbSupplier01.setSupplier01OwnerMobile("0711233000");
        try {
            sbSupplier01.setSupplier01OwnerBirthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbSupplier01.setSupplier01OwnerAddress(addressVal01);
        sbSupplier01.setSupplier01BusinessName("SL MORA");
        sbSupplier01.setSupplier01Brn("90152");
        sbSupplier01.setSupplier01BusinessMobile("0761233000");
        sbSupplier01.setSupplier01BusinessAddress(addressVal01);
        sbSupplier01.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbSupplier01.setRawLastUpdateLogId(1);
        sbSupplier01.setUpdateUserAccountId(1);
        sbSupplier01.setRawActiveStatus(1);
        sbSupplier01.setRawDeleteStatus(1);
        sbSupplier01.setRawShowStatus(1);
        sbSupplier01.setRawUpdateStatus(1);


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbCustomer03);
            session.save(sbSupplier01);
            transaction.commit();
            System.out.println("Added Customer 03: "+ sbCustomer03.getCustomer03FirstName());
            System.out.println("Added Supplier 01: "+ sbSupplier01.getSupplier01BusinessName());
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
