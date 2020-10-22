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
import java.util.Set;
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

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 04 and SB Order 01")
    public void testHibernateSaveCustomer04AndOrder01(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder  order01 = SBCustomerOrder.of(
                "IN0000001",
                new Timestamp(new java.util.Date().getTime()),
                2024.50
        );

        SBCustomerOrder  order02 = SBCustomerOrder.of(
                "IN0000002",
                new Timestamp(new java.util.Date().getTime()),
                1024.50
        );

        SBCustomerOrder  order03 = SBCustomerOrder.of(
                "IN0000003",
                new Timestamp(new java.util.Date().getTime()),
                3024.50
        );

        SBCustomerOrder  order04 = SBCustomerOrder.of(
                "IN0000004",
                new Timestamp(new java.util.Date().getTime()),
                5024.50
        );

        SBCustomer04 sbCustomer04 = new SBCustomer04();

        sbCustomer04.getCustomer04Orders().add(order01);
        sbCustomer04.getCustomer04Orders().add(order02);
        sbCustomer04.getCustomer04Orders().add(order03);
        sbCustomer04.getCustomer04Orders().add(order04);

        sbCustomer04.setCustomer04Email("umesh@slmora.com");
        sbCustomer04.setCustomer04Sex("Male");
        sbCustomer04.setCustomer04FirstName("Umesh");
        sbCustomer04.setCustomer04LastName("Gunasekara");
        sbCustomer04.setCustomer04Nic("901521344V");
        sbCustomer04.setCustomer04Mobile("0711233000");
        try {
            sbCustomer04.setCustomer04Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer04.setCustomer04Address(addressVal01);
        sbCustomer04.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer04.setRawLastUpdateLogId(1);
        sbCustomer04.setUpdateUserAccountId(1);
        sbCustomer04.setRawActiveStatus(1);
        sbCustomer04.setRawDeleteStatus(1);
        sbCustomer04.setRawShowStatus(1);
        sbCustomer04.setRawUpdateStatus(1);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbCustomer04);
            transaction.commit();
            System.out.println("Added Customer 03: "+ sbCustomer04.getCustomer04FirstName());
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
    @DisplayName("Test Insert SB Customer 05 and SB Order 01")
    public void testHibernateSaveCustomer05AndOrder01(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder  order01 = SBCustomerOrder.of(
                "IN0000001",
                new Timestamp(new java.util.Date().getTime()),
                2024.50
        );

        SBCustomerOrder  order02 = SBCustomerOrder.of(
                "IN0000002",
                new Timestamp(new java.util.Date().getTime()),
                1024.50
        );

        SBCustomerOrder  order03 = SBCustomerOrder.of(
                "IN0000003",
                new Timestamp(new java.util.Date().getTime()),
                3024.50
        );

        SBCustomerOrder  order04 = SBCustomerOrder.of(
                "IN0000004",
                new Timestamp(new java.util.Date().getTime()),
                5024.50
        );

        SBCustomer05 sbCustomer05 = new SBCustomer05();

        sbCustomer05.getCustomer05Orders().add(order01);
        sbCustomer05.getCustomer05Orders().add(order02);
        sbCustomer05.getCustomer05Orders().add(order03);
        sbCustomer05.getCustomer05Orders().add(order04);

        sbCustomer05.setCustomer05Email("umesh@slmora.com");
        sbCustomer05.setCustomer05Sex("Male");
        sbCustomer05.setCustomer05FirstName("Umesh");
        sbCustomer05.setCustomer05LastName("Gunasekara");
        sbCustomer05.setCustomer05Nic("901521344V");
        sbCustomer05.setCustomer05Mobile("0711233000");
        try {
            sbCustomer05.setCustomer05Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer05.setCustomer05Address(addressVal01);
        sbCustomer05.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer05.setRawLastUpdateLogId(1);
        sbCustomer05.setUpdateUserAccountId(1);
        sbCustomer05.setRawActiveStatus(1);
        sbCustomer05.setRawDeleteStatus(1);
        sbCustomer05.setRawShowStatus(1);
        sbCustomer05.setRawUpdateStatus(1);



        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbCustomer05);
            transaction.commit();
            System.out.println("Added Customer 03: "+ sbCustomer05.getCustomer05FirstName());
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
    @DisplayName("Test Hibernate Lazy Loading in Default")
    public void testHibernateDefaultLazyLoading(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder  order01 = SBCustomerOrder.of(
                "IN0000001",
                new Timestamp(new java.util.Date().getTime()),
                2024.50
        );

        SBCustomerOrder  order02 = SBCustomerOrder.of(
                "IN0000002",
                new Timestamp(new java.util.Date().getTime()),
                1024.50
        );

        SBCustomerOrder  order03 = SBCustomerOrder.of(
                "IN0000003",
                new Timestamp(new java.util.Date().getTime()),
                3024.50
        );

        SBCustomerOrder  order04 = SBCustomerOrder.of(
                "IN0000004",
                new Timestamp(new java.util.Date().getTime()),
                5024.50
        );

        SBCustomer05 sbCustomer05 = new SBCustomer05();

        sbCustomer05.getCustomer05Orders().add(order01);
        sbCustomer05.getCustomer05Orders().add(order02);
        sbCustomer05.getCustomer05Orders().add(order03);
        sbCustomer05.getCustomer05Orders().add(order04);

        sbCustomer05.setCustomer05Email("umesh@slmora.com");
        sbCustomer05.setCustomer05Sex("Male");
        sbCustomer05.setCustomer05FirstName("Umesh");
        sbCustomer05.setCustomer05LastName("Gunasekara");
        sbCustomer05.setCustomer05Nic("901521344V");
        sbCustomer05.setCustomer05Mobile("0711233000");
        try {
            sbCustomer05.setCustomer05Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer05.setCustomer05Address(addressVal01);
        sbCustomer05.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer05.setRawLastUpdateLogId(1);
        sbCustomer05.setUpdateUserAccountId(1);
        sbCustomer05.setRawActiveStatus(1);
        sbCustomer05.setRawDeleteStatus(1);
        sbCustomer05.setRawShowStatus(1);
        sbCustomer05.setRawUpdateStatus(1);



        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbCustomer05);
            transaction.commit();
            System.out.println("Added Customer 03: "+ sbCustomer05.getCustomer05FirstName());
        } catch (Throwable throwable) {
            if(transaction !=null){
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        //********************************************
        //The first session has benn closed with end of try catch
        //*******************************************

        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            SBCustomer05 customer = session.get(SBCustomer05.class, sbCustomer05.getCustomer05Id());
            transaction.commit();
            System.out.println("Get Customer 05: "+ customer.getCustomer05FirstName());
            System.out.println("Get Customer 05 Orders ");
            customer.getCustomer05Orders().forEach(
                    order ->
                    {
                        System.out.println("Order Invoice Number :"+order.getCustomerOrderInvoiceNumber());
                        System.out.println("\tDate & Time :"+order.getCustomerOrderDateTime());
                        System.out.println("\tTotal Amount:"+order.getCustomerOrderTotal());
                    });
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
    @DisplayName("Test Hibernate Lazy Loading in Default with Session Close")
    public void testHibernateDefaultLazyLoadingWithSessionClose(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder  order01 = SBCustomerOrder.of(
                "IN0000001",
                new Timestamp(new java.util.Date().getTime()),
                2024.50
        );

        SBCustomerOrder  order02 = SBCustomerOrder.of(
                "IN0000002",
                new Timestamp(new java.util.Date().getTime()),
                1024.50
        );

        SBCustomerOrder  order03 = SBCustomerOrder.of(
                "IN0000003",
                new Timestamp(new java.util.Date().getTime()),
                3024.50
        );

        SBCustomerOrder  order04 = SBCustomerOrder.of(
                "IN0000004",
                new Timestamp(new java.util.Date().getTime()),
                5024.50
        );

        SBCustomer05 sbCustomer05 = new SBCustomer05();

        sbCustomer05.getCustomer05Orders().add(order01);
        sbCustomer05.getCustomer05Orders().add(order02);
        sbCustomer05.getCustomer05Orders().add(order03);
        sbCustomer05.getCustomer05Orders().add(order04);

        sbCustomer05.setCustomer05Email("umesh@slmora.com");
        sbCustomer05.setCustomer05Sex("Male");
        sbCustomer05.setCustomer05FirstName("Umesh");
        sbCustomer05.setCustomer05LastName("Gunasekara");
        sbCustomer05.setCustomer05Nic("901521344V");
        sbCustomer05.setCustomer05Mobile("0711233000");
        try {
            sbCustomer05.setCustomer05Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer05.setCustomer05Address(addressVal01);
        sbCustomer05.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer05.setRawLastUpdateLogId(1);
        sbCustomer05.setUpdateUserAccountId(1);
        sbCustomer05.setRawActiveStatus(1);
        sbCustomer05.setRawDeleteStatus(1);
        sbCustomer05.setRawShowStatus(1);
        sbCustomer05.setRawUpdateStatus(1);



        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbCustomer05);
            transaction.commit();
            System.out.println("Added Customer 03: "+ sbCustomer05.getCustomer05FirstName());
        } catch (Throwable throwable) {
            if(transaction !=null){
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        //********************************************
        //The first session has benn closed with end of try catch
        //*******************************************

        SBCustomer05 customer = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            customer = session.get(SBCustomer05.class, sbCustomer05.getCustomer05Id());
            transaction.commit();
        } catch (Throwable throwable) {
            if(transaction !=null){
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Get Customer 05: "+ customer.getCustomer05FirstName());
        System.out.println("Get Customer 05 Orders ");
        customer.getCustomer05Orders().forEach(
                order ->
                {
                    System.out.println("Order Invoice Number :"+order.getCustomerOrderInvoiceNumber());
                    System.out.println("\tDate & Time :"+order.getCustomerOrderDateTime());
                    System.out.println("\tTotal Amount:"+order.getCustomerOrderTotal());
                });

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
    @DisplayName("Test Hibernate Eager Loading in Default with Session Close")
    public void testHibernateEagerLoadingWithSessionClose(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder  order01 = SBCustomerOrder.of(
                "IN0000001",
                new Timestamp(new java.util.Date().getTime()),
                2024.50
        );

        SBCustomerOrder  order02 = SBCustomerOrder.of(
                "IN0000002",
                new Timestamp(new java.util.Date().getTime()),
                1024.50
        );

        SBCustomerOrder  order03 = SBCustomerOrder.of(
                "IN0000003",
                new Timestamp(new java.util.Date().getTime()),
                3024.50
        );

        SBCustomerOrder  order04 = SBCustomerOrder.of(
                "IN0000004",
                new Timestamp(new java.util.Date().getTime()),
                5024.50
        );

        SBCustomer06 sbCustomer06 = new SBCustomer06();

        sbCustomer06.getCustomer06Orders().add(order01);
        sbCustomer06.getCustomer06Orders().add(order02);
        sbCustomer06.getCustomer06Orders().add(order03);
        sbCustomer06.getCustomer06Orders().add(order04);

        sbCustomer06.setCustomer06Email("umesh@slmora.com");
        sbCustomer06.setCustomer06Sex("Male");
        sbCustomer06.setCustomer06FirstName("Umesh");
        sbCustomer06.setCustomer06LastName("Gunasekara");
        sbCustomer06.setCustomer06Nic("901521344V");
        sbCustomer06.setCustomer06Mobile("0711233000");
        try {
            sbCustomer06.setCustomer06Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer06.setCustomer06Address(addressVal01);
        sbCustomer06.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer06.setRawLastUpdateLogId(1);
        sbCustomer06.setUpdateUserAccountId(1);
        sbCustomer06.setRawActiveStatus(1);
        sbCustomer06.setRawDeleteStatus(1);
        sbCustomer06.setRawShowStatus(1);
        sbCustomer06.setRawUpdateStatus(1);



        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbCustomer06);
            transaction.commit();
            System.out.println("Added Customer 03: "+ sbCustomer06.getCustomer06FirstName());
        } catch (Throwable throwable) {
            if(transaction !=null){
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        //********************************************
        //The first session has benn closed with end of try catch
        //*******************************************

        SBCustomer06 customer = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            customer = session.get(SBCustomer06.class, sbCustomer06.getCustomer06Id());
            transaction.commit();
        } catch (Throwable throwable) {
            if(transaction !=null){
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Get Customer 05: "+ customer.getCustomer06FirstName());
        System.out.println("Get Customer 05 Orders ");
        customer.getCustomer06Orders().forEach(
                order ->
                {
                    System.out.println("Order Invoice Number :"+order.getCustomerOrderInvoiceNumber());
                    System.out.println("\tDate & Time :"+order.getCustomerOrderDateTime());
                    System.out.println("\tTotal Amount:"+order.getCustomerOrderTotal());
                });

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
    @DisplayName("Test Insert SB Supplier 02 and Address 01")
    public void testHibernateSaveSupplier02AndAddress01(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddress01 sbAddress01 = new SBAddress01();
        sbAddress01.setAddress01Street("Kusumarama Road");
        sbAddress01.setAddress01Village("Seenigama");
        sbAddress01.setAddress01City("Hikkaduwa");
        sbAddress01.setAddress01Country("Sri Lanka");
        sbAddress01.setAddress01Zip("292000");
        sbAddress01.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbAddress01.setRawLastUpdateLogId(1);
        sbAddress01.setUpdateUserAccountId(1);
        sbAddress01.setRawActiveStatus(1);
        sbAddress01.setRawDeleteStatus(1);
        sbAddress01.setRawShowStatus(1);
        sbAddress01.setRawUpdateStatus(1);

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBSupplier02 sbSupplier02 = new SBSupplier02();
        sbSupplier02.setSupplier02Email("umesh@slmora.com");
        sbSupplier02.setSupplier02OwnerSex("Male");
        sbSupplier02.setSupplier02OwnerName("Umesh");
        sbSupplier02.setSupplier02OwnerMobile("0711233000");
        try {
            sbSupplier02.setSupplier02OwnerBirthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbSupplier02.setSupplier02OwnerAddress(sbAddress01);
        sbSupplier02.setSupplier02BusinessName("SL MORA");
        sbSupplier02.setSupplier02Brn("90152");
        sbSupplier02.setSupplier02BusinessMobile("0761233000");
        sbSupplier02.setSupplier02BusinessAddress(addressVal01);
        sbSupplier02.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbSupplier02.setRawLastUpdateLogId(1);
        sbSupplier02.setUpdateUserAccountId(1);
        sbSupplier02.setRawActiveStatus(1);
        sbSupplier02.setRawDeleteStatus(1);
        sbSupplier02.setRawShowStatus(1);
        sbSupplier02.setRawUpdateStatus(1);


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbAddress01);
            session.save(sbSupplier02);
            transaction.commit();
            System.out.println("Added Address 01: "+ sbAddress01.getAddress01Street());
            System.out.println("Added Supplier 02: "+ sbSupplier02.getSupplier02BusinessName());
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
    @DisplayName("Test Insert SB Supplier 03 and Address 02")
    public void testHibernateSaveSupplier03AndAddress02(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddress02 sbAddress02 = new SBAddress02();
        sbAddress02.setAddress02Street("Kusumarama Road");
        sbAddress02.setAddress02Village("Seenigama");
        sbAddress02.setAddress02City("Hikkaduwa");
        sbAddress02.setAddress02Country("Sri Lanka");
        sbAddress02.setAddress02Zip("292000");
        sbAddress02.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbAddress02.setRawLastUpdateLogId(1);
        sbAddress02.setUpdateUserAccountId(1);
        sbAddress02.setRawActiveStatus(1);
        sbAddress02.setRawDeleteStatus(1);
        sbAddress02.setRawShowStatus(1);
        sbAddress02.setRawUpdateStatus(1);

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBSupplier03 sbSupplier03 = new SBSupplier03();
        sbSupplier03.setSupplier03Email("umesh@slmora.com");
        sbSupplier03.setSupplier03OwnerSex("Male");
        sbSupplier03.setSupplier03OwnerName("Umesh");
        sbSupplier03.setSupplier03OwnerMobile("0711233000");
        try {
            sbSupplier03.setSupplier03OwnerBirthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbSupplier03.setSupplier03OwnerAddress(sbAddress02);
        sbSupplier03.setSupplier03BusinessName("SL MORA");
        sbSupplier03.setSupplier03Brn("90152");
        sbSupplier03.setSupplier03BusinessMobile("0761233000");
        sbSupplier03.setSupplier03BusinessAddress(addressVal01);
        sbSupplier03.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbSupplier03.setRawLastUpdateLogId(1);
        sbSupplier03.setUpdateUserAccountId(1);
        sbSupplier03.setRawActiveStatus(1);
        sbSupplier03.setRawDeleteStatus(1);
        sbSupplier03.setRawShowStatus(1);
        sbSupplier03.setRawUpdateStatus(1);


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbAddress02);
            session.save(sbSupplier03);
            transaction.commit();
            System.out.println("Added Address 01: "+ sbAddress02.getAddress02Street());
            System.out.println("Added Supplier 02: "+ sbSupplier03.getSupplier03BusinessName());
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
    @DisplayName("Test Insert SB Customer 07 and SB Order 04")
    public void testHibernateSaveCustomer07AndOrder04(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder04  order01 = new SBCustomerOrder04();
        order01.setCustomerOrder04InvoiceNumber("IN0000001");
        order01.setCustomerOrder04DateTime(new Timestamp(new java.util.Date().getTime()));
        order01.setCustomerOrder04Total(2024.50);
        order01.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order01.setRawLastUpdateLogId(1);
        order01.setUpdateUserAccountId(1);
        order01.setRawActiveStatus(1);
        order01.setRawDeleteStatus(1);
        order01.setRawShowStatus(1);
        order01.setRawUpdateStatus(1);

        SBCustomerOrder04  order02 = new SBCustomerOrder04();
        order02.setCustomerOrder04InvoiceNumber("IN0000002");
        order02.setCustomerOrder04DateTime(new Timestamp(new java.util.Date().getTime()));
        order02.setCustomerOrder04Total(1024.50);
        order02.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order02.setRawLastUpdateLogId(1);
        order02.setUpdateUserAccountId(1);
        order02.setRawActiveStatus(1);
        order02.setRawDeleteStatus(1);
        order02.setRawShowStatus(1);
        order02.setRawUpdateStatus(1);

        SBCustomerOrder04  order03 = new SBCustomerOrder04();
        order03.setCustomerOrder04InvoiceNumber("IN0000003");
        order03.setCustomerOrder04DateTime(new Timestamp(new java.util.Date().getTime()));
        order03.setCustomerOrder04Total(3024.50);
        order03.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order03.setRawLastUpdateLogId(1);
        order03.setUpdateUserAccountId(1);
        order03.setRawActiveStatus(1);
        order03.setRawDeleteStatus(1);
        order03.setRawShowStatus(1);
        order03.setRawUpdateStatus(1);

        SBCustomerOrder04  order04 = new SBCustomerOrder04();
        order04.setCustomerOrder04InvoiceNumber("IN0000004");
        order04.setCustomerOrder04DateTime(new Timestamp(new java.util.Date().getTime()));
        order04.setCustomerOrder04Total(5024.50);
        order04.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order04.setRawLastUpdateLogId(1);
        order04.setUpdateUserAccountId(1);
        order04.setRawActiveStatus(1);
        order04.setRawDeleteStatus(1);
        order04.setRawShowStatus(1);
        order04.setRawUpdateStatus(1);

        SBCustomer07 sbCustomer07 = new SBCustomer07();

        sbCustomer07.getCustomer07Orders().add(order01);
        sbCustomer07.getCustomer07Orders().add(order02);
        sbCustomer07.getCustomer07Orders().add(order03);
        sbCustomer07.getCustomer07Orders().add(order04);

        sbCustomer07.setCustomer07Email("umesh@slmora.com");
        sbCustomer07.setCustomer07Sex("Male");
        sbCustomer07.setCustomer07FirstName("Umesh");
        sbCustomer07.setCustomer07LastName("Gunasekara");
        sbCustomer07.setCustomer07Nic("901521344V");
        sbCustomer07.setCustomer07Mobile("0711233000");
        try {
            sbCustomer07.setCustomer07Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer07.setCustomer07Address(addressVal01);
        sbCustomer07.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer07.setRawLastUpdateLogId(1);
        sbCustomer07.setUpdateUserAccountId(1);
        sbCustomer07.setRawActiveStatus(1);
        sbCustomer07.setRawDeleteStatus(1);
        sbCustomer07.setRawShowStatus(1);
        sbCustomer07.setRawUpdateStatus(1);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbCustomer07);
            session.save(order01);
            session.save(order02);
            session.save(order03);
            session.save(order04);
            transaction.commit();
            System.out.println("Added Customer 03: "+ sbCustomer07.getCustomer07FirstName());
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
    @DisplayName("Test Insert SB Customer 08 and SB Order 05")
    public void testHibernateSaveCustomer08AndOrder05(){
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder05  order01 = new SBCustomerOrder05();
        order01.setCustomerOrder05InvoiceNumber("IN0000001");
        order01.setCustomerOrder05DateTime(new Timestamp(new java.util.Date().getTime()));
        order01.setCustomerOrder05Total(2024.50);
        order01.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order01.setRawLastUpdateLogId(1);
        order01.setUpdateUserAccountId(1);
        order01.setRawActiveStatus(1);
        order01.setRawDeleteStatus(1);
        order01.setRawShowStatus(1);
        order01.setRawUpdateStatus(1);

        SBCustomerOrder05  order02 = new SBCustomerOrder05();
        order02.setCustomerOrder05InvoiceNumber("IN0000002");
        order02.setCustomerOrder05DateTime(new Timestamp(new java.util.Date().getTime()));
        order02.setCustomerOrder05Total(1024.50);
        order02.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order02.setRawLastUpdateLogId(1);
        order02.setUpdateUserAccountId(1);
        order02.setRawActiveStatus(1);
        order02.setRawDeleteStatus(1);
        order02.setRawShowStatus(1);
        order02.setRawUpdateStatus(1);

        SBCustomerOrder05  order03 = new SBCustomerOrder05();
        order03.setCustomerOrder05InvoiceNumber("IN0000003");
        order03.setCustomerOrder05DateTime(new Timestamp(new java.util.Date().getTime()));
        order03.setCustomerOrder05Total(3024.50);
        order03.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order03.setRawLastUpdateLogId(1);
        order03.setUpdateUserAccountId(1);
        order03.setRawActiveStatus(1);
        order03.setRawDeleteStatus(1);
        order03.setRawShowStatus(1);
        order03.setRawUpdateStatus(1);

        SBCustomerOrder05  order04 = new SBCustomerOrder05();
        order04.setCustomerOrder05InvoiceNumber("IN0000004");
        order04.setCustomerOrder05DateTime(new Timestamp(new java.util.Date().getTime()));
        order04.setCustomerOrder05Total(5024.50);
        order04.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order04.setRawLastUpdateLogId(1);
        order04.setUpdateUserAccountId(1);
        order04.setRawActiveStatus(1);
        order04.setRawDeleteStatus(1);
        order04.setRawShowStatus(1);
        order04.setRawUpdateStatus(1);

        SBCustomer08 sbCustomer08 = new SBCustomer08();

        sbCustomer08.getCustomer08Orders().add(order01);
        sbCustomer08.getCustomer08Orders().add(order02);
        sbCustomer08.getCustomer08Orders().add(order03);
        sbCustomer08.getCustomer08Orders().add(order04);

        sbCustomer08.setCustomer08Email("umesh@slmora.com");
        sbCustomer08.setCustomer08Sex("Male");
        sbCustomer08.setCustomer08FirstName("Umesh");
        sbCustomer08.setCustomer08LastName("Gunasekara");
        sbCustomer08.setCustomer08Nic("901521344V");
        sbCustomer08.setCustomer08Mobile("0711233000");
        try {
            sbCustomer08.setCustomer08Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer08.setCustomer08Address(addressVal01);
        sbCustomer08.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer08.setRawLastUpdateLogId(1);
        sbCustomer08.setUpdateUserAccountId(1);
        sbCustomer08.setRawActiveStatus(1);
        sbCustomer08.setRawDeleteStatus(1);
        sbCustomer08.setRawShowStatus(1);
        sbCustomer08.setRawUpdateStatus(1);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction=session.beginTransaction();
            session.save(sbCustomer08);
            session.save(order01);
            session.save(order02);
            session.save(order03);
            session.save(order04);
            transaction.commit();
            System.out.println("Added Customer 03: "+ sbCustomer08.getCustomer08FirstName());
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
