/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/18/2020 12:29 PM
 */
package com.slmora.learn;

import com.slmora.learn.common.hibernate.HibernateUtil;
import com.slmora.learn.common.util.MoraAccessProperties;
import com.slmora.learn.common.util.UuidUtilities;
import com.slmora.learn.entity.hibernate.*;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.query.Query;
import org.junit.jupiter.api.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
     */
    @BeforeAll
    public static void beforeAllInit()
    {
        System.out.println("Before all initialized .......");
    }

    /**
     * Runs this method before each test execution
     *
     * @param testInfo, testReporter to inject reporting information
     */
    @BeforeEach
    public void beforeEachInit(TestInfo testInfo, TestReporter testReporter)
    {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + "with tags " + testInfo.getTags() + "\n");

    }

    /**
     * Runs this method after each test execution
     */
    @AfterEach
    private void afterEachEnd()
    {
        System.out.println("Test Completed " + testInfo.getDisplayName());
        System.out.println("After Each Clean Test........");
        System.out.println("Elapsed TIme : " + ELAPSED_TIME + " ns");
        LOGGER.info("Elapsed TIme for " + testInfo.getDisplayName() + " : " + ELAPSED_TIME);
    }

    /**
     * This method runs After all Test Cases execution
     * This must be static because of this will execute after instance destroyed
     */
    @AfterAll
    public static void AfterAllInit()
    {
        System.out.println("After All Initiated........");
    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Basic Thread")
    public void testHibernateSaveItem01UsingHibernateUtil()
    {
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

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                session.save(sbItem01);
                transaction.commit();
                System.out.println("Added Item 01 : " + sbItem01.getItem01Name());
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }
        } catch (Throwable throwable) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Item 02")
    public void testHibernateSaveItem02()
    {
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

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                session.save(sbItem02);
                transaction.commit();
                System.out.println("Added Item 01 : " + sbItem02.getItem02Name());
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }
        } catch (Throwable throwable) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Item 03")
    public void testHibernateSaveItem03()
    {
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


        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                session.save(sbItem03);
                transaction.commit();
                System.out.println("Added Item 01 : " + sbItem03.getItem03Name());
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }
        } catch (Throwable throwable) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Item 04")
    public void testHibernateSaveItem04()
    {
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


        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                session.save(sbItem04);
                transaction.commit();
                System.out.println("Added Item 04 : " + sbItem04.getItem04Name());
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }
        } catch (Throwable throwable) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Get SB Item 04")
    public void testHibernateGetItem04()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();
        SBItem04 sbItem04 = null;


        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                sbItem04 = session.get(SBItem04.class, UUID.fromString("95f2e1b9-50ee-4063-a503-838d92011cc0"));
                transaction.commit();
                System.out.println("Get Item 04 : " + sbItem04.getItem04Name());
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }
        } catch (Throwable throwable) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Item 05")
    public void testHibernateSaveItem05()
    {
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

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                session.save(sbItem05);
                transaction.commit();
                System.out.println("Added Item 05 : " + sbItem05.getItem05Name());
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }
        } catch (Throwable throwable) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Get SB Item 05")
    public void testHibernateGetItem05()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();
        UuidUtilities uuidUtilities = new UuidUtilities();
        SBItem05 sbItem05 = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                sbItem05 = session.get(SBItem05.class,
                        uuidUtilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString(
                                "eeb877e5-91f8-481e-87c2-8eccc276a8ba")));
                transaction.commit();
                System.out.println("Get Item 05 : " + sbItem05.getItem05Name());
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }
        } catch (Throwable throwable) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Item 06")
    public void testHibernateSaveItem06()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBItem06 sbItem06A = new SBItem06();
        sbItem06A.setItem06Name("Anchor Frsh Milk 1L");

        SBItem06 sbItem06B = new SBItem06();
        sbItem06B.setItem06Name("MORA Frsh Milk 2L");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbItem06A);
            session.save(sbItem06B);
            transaction.commit();
            System.out.println("Added Item 06 A : " + sbItem06A.getItem06Name());
            System.out.println("Added Item 05 B : " + sbItem06B.getItem06Name());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Item 07")
    public void testHibernateSaveItem07()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBItem07 sbItem07A = new SBItem07();
        sbItem07A.setItem07Name("Anchor Frsh Milk 1L");

        SBItem07 sbItem07B = new SBItem07();
        sbItem07B.setItem07Name("MORA Frsh Milk 2L");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbItem07A);
            session.save(sbItem07B);
            transaction.commit();
            System.out.println("Added Item 06 A : " + sbItem07A.getItem07Name());
            System.out.println("Added Item 05 B : " + sbItem07B.getItem07Name());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Item 08")
    public void testHibernateSaveItem08()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBItem08 sbItem08A = new SBItem08();
        sbItem08A.setItem08Name("Anchor Frsh Milk 1L");

        SBItem08 sbItem08B = new SBItem08();
        sbItem08B.setItem08Name("MORA Frsh Milk 2L");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbItem08A);
            session.save(sbItem08B);
            transaction.commit();
            System.out.println("Added Item 06 A : " + sbItem08A.getItem08Name());
            System.out.println("Added Item 05 B : " + sbItem08B.getItem08Name());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Item 09")
    public void testHibernateSaveItem09()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBItem09 sbItem09A = new SBItem09();
        sbItem09A.setItem09Name("Anchor Frsh Milk 1L");

        SBItem09 sbItem09B = new SBItem09();
        sbItem09B.setItem09Name("MORA Frsh Milk 2L");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbItem09A);
            session.save(sbItem09B);
            transaction.commit();
            System.out.println("Added Item 06 A : " + sbItem09A.getItem09Name());
            System.out.println("Added Item 05 B : " + sbItem09B.getItem09Name());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 01")
    public void testHibernateSaveCustomer01()
    {
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
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer01);
            transaction.commit();
            System.out.println("Added Customer: " + sbCustomer01.getCustomer01FirstName());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 02")
    public void testHibernateSaveCustomer02()
    {
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
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer02);
            transaction.commit();
            System.out.println("Added Customer: " + sbCustomer02.getCustomer02FirstName());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 03 and SB Supplier 01")
    public void testHibernateSaveCustomer03AndSupplier01()
    {
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
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer03);
            session.save(sbSupplier01);
            transaction.commit();
            System.out.println("Added Customer 03: " + sbCustomer03.getCustomer03FirstName());
            System.out.println("Added Supplier 01: " + sbSupplier01.getSupplier01BusinessName());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 04 and SB Order 01")
    public void testHibernateSaveCustomer04AndOrder01()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder order01 = SBCustomerOrder.of(
                "IN0000001",
                new Timestamp(new java.util.Date().getTime()),
                2024.50
        );

        SBCustomerOrder order02 = SBCustomerOrder.of(
                "IN0000002",
                new Timestamp(new java.util.Date().getTime()),
                1024.50
        );

        SBCustomerOrder order03 = SBCustomerOrder.of(
                "IN0000003",
                new Timestamp(new java.util.Date().getTime()),
                3024.50
        );

        SBCustomerOrder order04 = SBCustomerOrder.of(
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
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer04);
            transaction.commit();
            System.out.println("Added Customer 03: " + sbCustomer04.getCustomer04FirstName());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 05 and SB Order 01")
    public void testHibernateSaveCustomer05AndOrder01()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder order01 = SBCustomerOrder.of(
                "IN0000001",
                new Timestamp(new java.util.Date().getTime()),
                2024.50
        );

        SBCustomerOrder order02 = SBCustomerOrder.of(
                "IN0000002",
                new Timestamp(new java.util.Date().getTime()),
                1024.50
        );

        SBCustomerOrder order03 = SBCustomerOrder.of(
                "IN0000003",
                new Timestamp(new java.util.Date().getTime()),
                3024.50
        );

        SBCustomerOrder order04 = SBCustomerOrder.of(
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
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer05);
            transaction.commit();
            System.out.println("Added Customer 03: " + sbCustomer05.getCustomer05FirstName());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Hibernate Lazy Loading in Default")
    public void testHibernateDefaultLazyLoading()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder order01 = SBCustomerOrder.of(
                "IN0000001",
                new Timestamp(new java.util.Date().getTime()),
                2024.50
        );

        SBCustomerOrder order02 = SBCustomerOrder.of(
                "IN0000002",
                new Timestamp(new java.util.Date().getTime()),
                1024.50
        );

        SBCustomerOrder order03 = SBCustomerOrder.of(
                "IN0000003",
                new Timestamp(new java.util.Date().getTime()),
                3024.50
        );

        SBCustomerOrder order04 = SBCustomerOrder.of(
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
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer05);
            transaction.commit();
            System.out.println("Added Customer 03: " + sbCustomer05.getCustomer05FirstName());
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        //********************************************
        //The first session has benn closed with end of try catch
        //*******************************************

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            SBCustomer05 customer = session.get(SBCustomer05.class, sbCustomer05.getCustomer05Id());
            transaction.commit();
            System.out.println("Get Customer 05: " + customer.getCustomer05FirstName());
            System.out.println("Get Customer 05 Orders ");
            customer.getCustomer05Orders().forEach(
                    order ->
                    {
                        System.out.println("Order Invoice Number :" + order.getCustomerOrderInvoiceNumber());
                        System.out.println("\tDate & Time :" + order.getCustomerOrderDateTime());
                        System.out.println("\tTotal Amount:" + order.getCustomerOrderTotal());
                    });
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Hibernate Lazy Loading in Default with Session Close")
    public void testHibernateDefaultLazyLoadingWithSessionClose()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder order01 = SBCustomerOrder.of(
                "IN0000001",
                new Timestamp(new java.util.Date().getTime()),
                2024.50
        );

        SBCustomerOrder order02 = SBCustomerOrder.of(
                "IN0000002",
                new Timestamp(new java.util.Date().getTime()),
                1024.50
        );

        SBCustomerOrder order03 = SBCustomerOrder.of(
                "IN0000003",
                new Timestamp(new java.util.Date().getTime()),
                3024.50
        );

        SBCustomerOrder order04 = SBCustomerOrder.of(
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
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer05);
            transaction.commit();
            System.out.println("Added Customer 03: " + sbCustomer05.getCustomer05FirstName());
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        //********************************************
        //The first session has benn closed with end of try catch
        //*******************************************

        SBCustomer05 customer = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            customer = session.get(SBCustomer05.class, sbCustomer05.getCustomer05Id());
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Get Customer 05: " + customer.getCustomer05FirstName());
        System.out.println("Get Customer 05 Orders ");
        customer.getCustomer05Orders().forEach(
                order ->
                {
                    System.out.println("Order Invoice Number :" + order.getCustomerOrderInvoiceNumber());
                    System.out.println("\tDate & Time :" + order.getCustomerOrderDateTime());
                    System.out.println("\tTotal Amount:" + order.getCustomerOrderTotal());
                });

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Hibernate Eager Loading in Default with Session Close")
    public void testHibernateEagerLoadingWithSessionClose()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder order01 = SBCustomerOrder.of(
                "IN0000001",
                new Timestamp(new java.util.Date().getTime()),
                2024.50
        );

        SBCustomerOrder order02 = SBCustomerOrder.of(
                "IN0000002",
                new Timestamp(new java.util.Date().getTime()),
                1024.50
        );

        SBCustomerOrder order03 = SBCustomerOrder.of(
                "IN0000003",
                new Timestamp(new java.util.Date().getTime()),
                3024.50
        );

        SBCustomerOrder order04 = SBCustomerOrder.of(
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
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer06);
            transaction.commit();
            System.out.println("Added Customer 03: " + sbCustomer06.getCustomer06FirstName());
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        //********************************************
        //The first session has benn closed with end of try catch
        //*******************************************

        SBCustomer06 customer = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            customer = session.get(SBCustomer06.class, sbCustomer06.getCustomer06Id());
            transaction.commit();
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Get Customer 05: " + customer.getCustomer06FirstName());
        System.out.println("Get Customer 05 Orders ");
        customer.getCustomer06Orders().forEach(
                order ->
                {
                    System.out.println("Order Invoice Number :" + order.getCustomerOrderInvoiceNumber());
                    System.out.println("\tDate & Time :" + order.getCustomerOrderDateTime());
                    System.out.println("\tTotal Amount:" + order.getCustomerOrderTotal());
                });

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Supplier 02 and Address 01")
    public void testHibernateSaveSupplier02AndAddress01()
    {
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
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbAddress01);
            session.save(sbSupplier02);
            transaction.commit();
            System.out.println("Added Address 01: " + sbAddress01.getAddress01Street());
            System.out.println("Added Supplier 02: " + sbSupplier02.getSupplier02BusinessName());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Supplier 03 and Address 02")
    public void testHibernateSaveSupplier03AndAddress02()
    {
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
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbAddress02);
            session.save(sbSupplier03);
            transaction.commit();
            System.out.println("Added Address 01: " + sbAddress02.getAddress02Street());
            System.out.println("Added Supplier 02: " + sbSupplier03.getSupplier03BusinessName());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 07 and SB Order 04")
    public void testHibernateSaveCustomer07AndOrder04()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder04 order01 = new SBCustomerOrder04();
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

        SBCustomerOrder04 order02 = new SBCustomerOrder04();
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

        SBCustomerOrder04 order03 = new SBCustomerOrder04();
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

        SBCustomerOrder04 order04 = new SBCustomerOrder04();
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
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer07);
            session.save(order01);
            session.save(order02);
            session.save(order03);
            session.save(order04);
            transaction.commit();
            System.out.println("Added Customer 03: " + sbCustomer07.getCustomer07FirstName());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 08 and SB Order 04")
    public void testHibernateSaveCustomer08AndOrder04()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder04 order01 = new SBCustomerOrder04();
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

        SBCustomerOrder04 order02 = new SBCustomerOrder04();
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

        SBCustomerOrder04 order03 = new SBCustomerOrder04();
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

        SBCustomerOrder04 order04 = new SBCustomerOrder04();
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
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer08);
            session.save(order01);
            session.save(order02);
            session.save(order03);
            session.save(order04);
            transaction.commit();
            System.out.println("Added Customer 03: " + sbCustomer08.getCustomer08FirstName());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 09 and SB Order 05")
    public void testHibernateSaveCustomer09AndOrder05()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder05 order01 = new SBCustomerOrder05();
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

        SBCustomerOrder05 order02 = new SBCustomerOrder05();
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

        SBCustomerOrder05 order03 = new SBCustomerOrder05();
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

        SBCustomerOrder05 order04 = new SBCustomerOrder05();
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

        SBCustomer09 sbCustomer09 = new SBCustomer09();

        sbCustomer09.getCustomer09Orders().add(order01);
        sbCustomer09.getCustomer09Orders().add(order02);
        sbCustomer09.getCustomer09Orders().add(order03);
        sbCustomer09.getCustomer09Orders().add(order04);

        sbCustomer09.setCustomer09Email("umesh@slmora.com");
        sbCustomer09.setCustomer09Sex("Male");
        sbCustomer09.setCustomer09FirstName("Umesh");
        sbCustomer09.setCustomer09LastName("Gunasekara");
        sbCustomer09.setCustomer09Nic("901521344V");
        sbCustomer09.setCustomer09Mobile("0711233000");
        try {
            sbCustomer09.setCustomer09Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer09.setCustomer09Address(addressVal01);
        sbCustomer09.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer09.setRawLastUpdateLogId(1);
        sbCustomer09.setUpdateUserAccountId(1);
        sbCustomer09.setRawActiveStatus(1);
        sbCustomer09.setRawDeleteStatus(1);
        sbCustomer09.setRawShowStatus(1);
        sbCustomer09.setRawUpdateStatus(1);

        order01.setSbCustomer09(sbCustomer09);
        order02.setSbCustomer09(sbCustomer09);
        order03.setSbCustomer09(sbCustomer09);
        order04.setSbCustomer09(sbCustomer09);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer09);
            session.save(order01);
            session.save(order02);
            session.save(order03);
            session.save(order04);
            transaction.commit();
            System.out.println("Added Customer 03: " + sbCustomer09.getCustomer09FirstName());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 10 and SB Order 06")
    public void testHibernateSaveCustomer10AndOrder06()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder06 order01 = new SBCustomerOrder06();
        order01.setCustomerOrder06InvoiceNumber("IN0000001");
        order01.setCustomerOrder06DateTime(new Timestamp(new java.util.Date().getTime()));
        order01.setCustomerOrder06Total(2024.50);
        order01.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order01.setRawLastUpdateLogId(1);
        order01.setUpdateUserAccountId(1);
        order01.setRawActiveStatus(1);
        order01.setRawDeleteStatus(1);
        order01.setRawShowStatus(1);
        order01.setRawUpdateStatus(1);

        SBCustomerOrder06 order02 = new SBCustomerOrder06();
        order02.setCustomerOrder06InvoiceNumber("IN0000002");
        order02.setCustomerOrder06DateTime(new Timestamp(new java.util.Date().getTime()));
        order02.setCustomerOrder06Total(1024.50);
        order02.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order02.setRawLastUpdateLogId(1);
        order02.setUpdateUserAccountId(1);
        order02.setRawActiveStatus(1);
        order02.setRawDeleteStatus(1);
        order02.setRawShowStatus(1);
        order02.setRawUpdateStatus(1);

        SBCustomerOrder06 order03 = new SBCustomerOrder06();
        order03.setCustomerOrder06InvoiceNumber("IN0000003");
        order03.setCustomerOrder06DateTime(new Timestamp(new java.util.Date().getTime()));
        order03.setCustomerOrder06Total(3024.50);
        order03.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order03.setRawLastUpdateLogId(1);
        order03.setUpdateUserAccountId(1);
        order03.setRawActiveStatus(1);
        order03.setRawDeleteStatus(1);
        order03.setRawShowStatus(1);
        order03.setRawUpdateStatus(1);

        SBCustomerOrder06 order04 = new SBCustomerOrder06();
        order04.setCustomerOrder06InvoiceNumber("IN0000004");
        order04.setCustomerOrder06DateTime(new Timestamp(new java.util.Date().getTime()));
        order04.setCustomerOrder06Total(5024.50);
        order04.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order04.setRawLastUpdateLogId(1);
        order04.setUpdateUserAccountId(1);
        order04.setRawActiveStatus(1);
        order04.setRawDeleteStatus(1);
        order04.setRawShowStatus(1);
        order04.setRawUpdateStatus(1);

        SBCustomer10 sbCustomer10 = new SBCustomer10();

        sbCustomer10.getCustomer10Orders().add(order01);
        sbCustomer10.getCustomer10Orders().add(order02);
        sbCustomer10.getCustomer10Orders().add(order03);
        sbCustomer10.getCustomer10Orders().add(order04);

        sbCustomer10.setCustomer10Email("umesh@slmora.com");
        sbCustomer10.setCustomer10Sex("Male");
        sbCustomer10.setCustomer10FirstName("Umesh");
        sbCustomer10.setCustomer10LastName("Gunasekara");
        sbCustomer10.setCustomer10Nic("901521344V");
        sbCustomer10.setCustomer10Mobile("0711233000");
        try {
            sbCustomer10.setCustomer10Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer10.setCustomer10Address(addressVal01);
        sbCustomer10.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer10.setRawLastUpdateLogId(1);
        sbCustomer10.setUpdateUserAccountId(1);
        sbCustomer10.setRawActiveStatus(1);
        sbCustomer10.setRawDeleteStatus(1);
        sbCustomer10.setRawShowStatus(1);
        sbCustomer10.setRawUpdateStatus(1);

        order01.setSbCustomer10(sbCustomer10);
        order02.setSbCustomer10(sbCustomer10);
        order03.setSbCustomer10(sbCustomer10);
        order04.setSbCustomer10(sbCustomer10);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer10);
            session.save(order01);
            session.save(order02);
            session.save(order03);
            session.save(order04);
            transaction.commit();
            System.out.println("Added Customer 03: " + sbCustomer10.getCustomer10FirstName());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 11 and SB Order 07 and Item10")
    public void testHibernateSaveCustomer11ndOrder07AndItem10()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomer11 sbCustomer11 = new SBCustomer11();
        sbCustomer11.setCustomer11Email("umesh@slmora.com");
        sbCustomer11.setCustomer11Sex("Male");
        sbCustomer11.setCustomer11FirstName("Umesh");
        sbCustomer11.setCustomer11LastName("Gunasekara");
        sbCustomer11.setCustomer11Nic("901521344V");
        sbCustomer11.setCustomer11Mobile("0711233000");
        try {
            sbCustomer11.setCustomer11Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer11.setCustomer11Address(addressVal01);
        sbCustomer11.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer11.setRawLastUpdateLogId(1);
        sbCustomer11.setUpdateUserAccountId(1);
        sbCustomer11.setRawActiveStatus(1);
        sbCustomer11.setRawDeleteStatus(1);
        sbCustomer11.setRawShowStatus(1);
        sbCustomer11.setRawUpdateStatus(1);

        SBItem10 item01 = new SBItem10();
        item01.setItem10Name("Anchor Frsh Milk 1L");
        item01.setItem10Description("Frsh Milk");
        item01.setItem10QtyOnHand(150);
        item01.setItem10MeasureUnit("Unit");
        item01.setItem10UnitPrice(568.50);
        item01.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item01.setRawLastUpdateLogId(1);
        item01.setUpdateUserAccountId(1);
        item01.setRawActiveStatus(1);
        item01.setRawDeleteStatus(1);
        item01.setRawShowStatus(1);
        item01.setRawUpdateStatus(1);

        SBItem10 item02 = new SBItem10();
        item02.setItem10Name("Red Kakulu Rice");
        item02.setItem10Description("Rice");
        item02.setItem10QtyOnHand(200);
        item02.setItem10MeasureUnit("Kilogram");
        item02.setItem10UnitPrice(98.0);
        item02.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item02.setRawLastUpdateLogId(1);
        item02.setUpdateUserAccountId(1);
        item02.setRawActiveStatus(1);
        item02.setRawDeleteStatus(1);
        item02.setRawShowStatus(1);
        item02.setRawUpdateStatus(1);

        SBItem10 item03 = new SBItem10();
        item03.setItem10Name("Bread");
        item03.setItem10Description("Bread");
        item03.setItem10QtyOnHand(30);
        item03.setItem10MeasureUnit("Unit");
        item03.setItem10UnitPrice(55.0);
        item03.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item03.setRawLastUpdateLogId(1);
        item03.setUpdateUserAccountId(1);
        item03.setRawActiveStatus(1);
        item03.setRawDeleteStatus(1);
        item03.setRawShowStatus(1);
        item03.setRawUpdateStatus(1);

        SBItem10 item04 = new SBItem10();
        item04.setItem10Name("Cocacoola 1.5L");
        item04.setItem10Description("Cocacoola");
        item04.setItem10QtyOnHand(25);
        item04.setItem10MeasureUnit("Unit");
        item04.setItem10UnitPrice(230.0);
        item04.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item04.setRawLastUpdateLogId(1);
        item04.setUpdateUserAccountId(1);
        item04.setRawActiveStatus(1);
        item04.setRawDeleteStatus(1);
        item04.setRawShowStatus(1);
        item04.setRawUpdateStatus(1);

        SBItem10 item05 = new SBItem10();
        item05.setItem10Name("Coconut Oil");
        item05.setItem10Description("Oil");
        item05.setItem10QtyOnHand(180);
        item05.setItem10MeasureUnit("Litter");
        item05.setItem10UnitPrice(520.0);
        item05.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item05.setRawLastUpdateLogId(1);
        item05.setUpdateUserAccountId(1);
        item05.setRawActiveStatus(1);
        item05.setRawDeleteStatus(1);
        item05.setRawShowStatus(1);
        item05.setRawUpdateStatus(1);

        SBCustomerOrder07 order01 = new SBCustomerOrder07();
        order01.setCustomerOrder07InvoiceNumber("IN0000001");
        order01.setCustomerOrder07DateTime(new Timestamp(new java.util.Date().getTime()));
        order01.setCustomerOrder07Total(2024.50);
        order01.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order01.setRawLastUpdateLogId(1);
        order01.setUpdateUserAccountId(1);
        order01.setRawActiveStatus(1);
        order01.setRawDeleteStatus(1);
        order01.setRawShowStatus(1);
        order01.setRawUpdateStatus(1);

        order01.setSbCustomer11(sbCustomer11);

        sbCustomer11.getCustomer11Orders().add(order01);

        order01.getCustomerOrder07Items().add(item01);
        order01.getCustomerOrder07Items().add(item02);
        order01.getCustomerOrder07Items().add(item03);
        order01.getCustomerOrder07Items().add(item04);
        order01.getCustomerOrder07Items().add(item05);

        item01.getItem10Orders().add(order01);

        item02.getItem10Orders().add(order01);

        item03.getItem10Orders().add(order01);

        item04.getItem10Orders().add(order01);

        item05.getItem10Orders().add(order01);


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer11);
            session.save(order01);
            session.save(item01);
            session.save(item02);
            session.save(item03);
            session.save(item04);
            session.save(item05);

            transaction.commit();
            System.out.println("Added Customer 11: " + sbCustomer11.getCustomer11FirstName());
            System.out.println("Added Order 07: " + order01.getCustomerOrder07InvoiceNumber());
            System.out.println("Added Item 10 1: " + item01.getItem10Name());
            System.out.println("Added Item 10 2: " + item02.getItem10Name());
            System.out.println("Added Item 10 3: " + item03.getItem10Name());
            System.out.println("Added Item 10 4: " + item04.getItem10Name());
            System.out.println("Added Item 10 5: " + item05.getItem10Name());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 12 and SB Order 08 and Item11")
    public void testHibernateSaveCustomer12ndOrder08AndItem11()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomer12 sbCustomer12 = new SBCustomer12();
        sbCustomer12.setCustomer12Email("umesh@slmora.com");
        sbCustomer12.setCustomer12Sex("Male");
        sbCustomer12.setCustomer12FirstName("Umesh");
        sbCustomer12.setCustomer12LastName("Gunasekara");
        sbCustomer12.setCustomer12Nic("901521344V");
        sbCustomer12.setCustomer12Mobile("0711233000");
        try {
            sbCustomer12.setCustomer12Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer12.setCustomer12Address(addressVal01);
        sbCustomer12.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer12.setRawLastUpdateLogId(1);
        sbCustomer12.setUpdateUserAccountId(1);
        sbCustomer12.setRawActiveStatus(1);
        sbCustomer12.setRawDeleteStatus(1);
        sbCustomer12.setRawShowStatus(1);
        sbCustomer12.setRawUpdateStatus(1);

        SBItem11 item01 = new SBItem11();
        item01.setItem11Name("Anchor Frsh Milk 1L");
        item01.setItem11Description("Frsh Milk");
        item01.setItem11QtyOnHand(150);
        item01.setItem11MeasureUnit("Unit");
        item01.setItem11UnitPrice(568.50);
        item01.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item01.setRawLastUpdateLogId(1);
        item01.setUpdateUserAccountId(1);
        item01.setRawActiveStatus(1);
        item01.setRawDeleteStatus(1);
        item01.setRawShowStatus(1);
        item01.setRawUpdateStatus(1);

        SBItem11 item02 = new SBItem11();
        item02.setItem11Name("Red Kakulu Rice");
        item02.setItem11Description("Rice");
        item02.setItem11QtyOnHand(200);
        item02.setItem11MeasureUnit("Kilogram");
        item02.setItem11UnitPrice(98.0);
        item02.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item02.setRawLastUpdateLogId(1);
        item02.setUpdateUserAccountId(1);
        item02.setRawActiveStatus(1);
        item02.setRawDeleteStatus(1);
        item02.setRawShowStatus(1);
        item02.setRawUpdateStatus(1);

        SBItem11 item03 = new SBItem11();
        item03.setItem11Name("Bread");
        item03.setItem11Description("Bread");
        item03.setItem11QtyOnHand(30);
        item03.setItem11MeasureUnit("Unit");
        item03.setItem11UnitPrice(55.0);
        item03.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item03.setRawLastUpdateLogId(1);
        item03.setUpdateUserAccountId(1);
        item03.setRawActiveStatus(1);
        item03.setRawDeleteStatus(1);
        item03.setRawShowStatus(1);
        item03.setRawUpdateStatus(1);

        SBItem11 item04 = new SBItem11();
        item04.setItem11Name("Cocacoola 1.5L");
        item04.setItem11Description("Cocacoola");
        item04.setItem11QtyOnHand(25);
        item04.setItem11MeasureUnit("Unit");
        item04.setItem11UnitPrice(230.0);
        item04.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item04.setRawLastUpdateLogId(1);
        item04.setUpdateUserAccountId(1);
        item04.setRawActiveStatus(1);
        item04.setRawDeleteStatus(1);
        item04.setRawShowStatus(1);
        item04.setRawUpdateStatus(1);

        SBItem11 item05 = new SBItem11();
        item05.setItem11Name("Coconut Oil");
        item05.setItem11Description("Oil");
        item05.setItem11QtyOnHand(180);
        item05.setItem11MeasureUnit("Litter");
        item05.setItem11UnitPrice(520.0);
        item05.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item05.setRawLastUpdateLogId(1);
        item05.setUpdateUserAccountId(1);
        item05.setRawActiveStatus(1);
        item05.setRawDeleteStatus(1);
        item05.setRawShowStatus(1);
        item05.setRawUpdateStatus(1);

        SBCustomerOrder08 order01 = new SBCustomerOrder08();
        order01.setCustomerOrder08InvoiceNumber("IN0000001");
        order01.setCustomerOrder08DateTime(new Timestamp(new java.util.Date().getTime()));
        order01.setCustomerOrder08Total(2024.50);
        order01.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order01.setRawLastUpdateLogId(1);
        order01.setUpdateUserAccountId(1);
        order01.setRawActiveStatus(1);
        order01.setRawDeleteStatus(1);
        order01.setRawShowStatus(1);
        order01.setRawUpdateStatus(1);

        order01.setSbCustomer12(sbCustomer12);

        sbCustomer12.getCustomer12Orders().add(order01);

        order01.getCustomerOrder08Items().add(item01);
        order01.getCustomerOrder08Items().add(item02);
        order01.getCustomerOrder08Items().add(item03);
        order01.getCustomerOrder08Items().add(item04);
        order01.getCustomerOrder08Items().add(item05);

        item01.getItem11Orders().add(order01);

        item02.getItem11Orders().add(order01);

        item03.getItem11Orders().add(order01);

        item04.getItem11Orders().add(order01);

        item05.getItem11Orders().add(order01);


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer12);
            session.save(order01);
            session.save(item01);
            session.save(item02);
            session.save(item03);
            session.save(item04);
            session.save(item05);

            transaction.commit();
            System.out.println("Added Customer 11: " + sbCustomer12.getCustomer12FirstName());
            System.out.println("Added Order 07: " + order01.getCustomerOrder08InvoiceNumber());
            System.out.println("Added Item 10 1: " + item01.getItem11Name());
            System.out.println("Added Item 10 2: " + item02.getItem11Name());
            System.out.println("Added Item 10 3: " + item03.getItem11Name());
            System.out.println("Added Item 10 4: " + item04.getItem11Name());
            System.out.println("Added Item 10 5: " + item05.getItem11Name());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 13 and SB Order 09 Part 01")
    public void testHibernateNotFoundCustomer13AndOrder09Part01()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomerOrder09 order01 = new SBCustomerOrder09();
        order01.setCustomerOrder09InvoiceNumber("IN0000001");
        order01.setCustomerOrder09DateTime(new Timestamp(new java.util.Date().getTime()));
        order01.setCustomerOrder09Total(2024.50);
        order01.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order01.setRawLastUpdateLogId(1);
        order01.setUpdateUserAccountId(1);
        order01.setRawActiveStatus(1);
        order01.setRawDeleteStatus(1);
        order01.setRawShowStatus(1);
        order01.setRawUpdateStatus(1);

        SBCustomer13 sbCustomer13 = new SBCustomer13();
        sbCustomer13.getCustomer13Orders().add(order01);

        sbCustomer13.setCustomer13Email("umesh@slmora.com");
        sbCustomer13.setCustomer13Sex("Male");
        sbCustomer13.setCustomer13FirstName("Umesh");
        sbCustomer13.setCustomer13LastName("Gunasekara");
        sbCustomer13.setCustomer13Nic("901521344V");
        sbCustomer13.setCustomer13Mobile("0711233000");
        try {
            sbCustomer13.setCustomer13Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer13.setCustomer13Address(addressVal01);
        sbCustomer13.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer13.setRawLastUpdateLogId(1);
        sbCustomer13.setUpdateUserAccountId(1);
        sbCustomer13.setRawActiveStatus(1);
        sbCustomer13.setRawDeleteStatus(1);
        sbCustomer13.setRawShowStatus(1);
        sbCustomer13.setRawUpdateStatus(1);

        order01.setSbCustomer13(sbCustomer13);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(sbCustomer13);
            session.save(order01);
            transaction.commit();
            System.out.println("Added Customer Order 09: " + order01.getCustomerOrder09InvoiceNumber());
            System.out.println("Added Customer 13: " + sbCustomer13.getCustomer13FirstName());
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }
        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

        MoraAccessProperties accessProperties = new MoraAccessProperties();
        UuidUtilities utilities = new UuidUtilities();
        assertEquals(
                1,
                accessProperties.setPropertyFromPath(
                        "D:\\SLMORAWorkSpace\\IntelliJProjects\\MoraHibernateLearn004\\src\\main\\resources\\hibernatetestsupport.properties",
                        "MORA.HIBERNATE.TEST.HibernateNotFoundCustomer13AndOrder09.SBCustomer13ID",
                        utilities.getUUIDFromOrderedUUIDByteArrayWithApacheCommons(sbCustomer13.getCustomer13Id())
                                .toString(),
                        "Test Comment").intValue()
        );

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * Set hbm2ddl.auto > update
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 13 and SB Order 09 Part 02")
    public void testHibernateNotFoundCustomer13AndOrder09Part02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        MoraAccessProperties accessProperties = new MoraAccessProperties();
        UuidUtilities utilities = new UuidUtilities();

        byte[] customerOrder09Key = utilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(
                UUID.fromString(accessProperties.getPropertyFromPath(
                        "D:\\SLMORAWorkSpace\\IntelliJProjects\\MoraHibernateLearn004\\src\\main\\resources\\hibernatetestsupport.properties",
                        "MORA.HIBERNATE.TEST.HibernateNotFoundCustomer13AndOrder09.SBCustomer13ID"))
        );

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            SBCustomerOrder09 customerOrder09 = session.get(SBCustomerOrder09.class, customerOrder09Key);
            transaction.commit();
            System.out.println("Get Customer Order 09: " + customerOrder09.getCustomerOrder09InvoiceNumber());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Customer 14 and SB Order 10 and Item12")
    public void testHibernateSaveCustomer14ndOrder10AndItem12()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBAddressVal01 addressVal01 = SBAddressVal01.of(
                "Kusumarama Road",
                "Seenigama",
                "Hikkaduwa",
                "Sri Lanka",
                "292000"
        );

        SBCustomer14 sbCustomer14 = new SBCustomer14();
        sbCustomer14.setCustomer14Email("umesh@slmora.com");
        sbCustomer14.setCustomer14Sex("Male");
        sbCustomer14.setCustomer14FirstName("Umesh");
        sbCustomer14.setCustomer14LastName("Gunasekara");
        sbCustomer14.setCustomer14Nic("901521344V");
        sbCustomer14.setCustomer14Mobile("0711233000");
        try {
            sbCustomer14.setCustomer14Birthday(new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1990"));
        } catch (ParseException e) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(e));
            e.printStackTrace();
        }
        sbCustomer14.setCustomer14Address(addressVal01);
        sbCustomer14.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        sbCustomer14.setRawLastUpdateLogId(1);
        sbCustomer14.setUpdateUserAccountId(1);
        sbCustomer14.setRawActiveStatus(1);
        sbCustomer14.setRawDeleteStatus(1);
        sbCustomer14.setRawShowStatus(1);
        sbCustomer14.setRawUpdateStatus(1);

        SBItem12 item01 = new SBItem12();
        item01.setItem12Name("Anchor Frsh Milk 1L");
        item01.setItem12Description("Frsh Milk");
        item01.setItem12QtyOnHand(150);
        item01.setItem12MeasureUnit("Unit");
        item01.setItem12UnitPrice(568.50);
        item01.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item01.setRawLastUpdateLogId(1);
        item01.setUpdateUserAccountId(1);
        item01.setRawActiveStatus(1);
        item01.setRawDeleteStatus(1);
        item01.setRawShowStatus(1);
        item01.setRawUpdateStatus(1);

        SBItem12 item02 = new SBItem12();
        item02.setItem12Name("Red Kakulu Rice");
        item02.setItem12Description("Rice");
        item02.setItem12QtyOnHand(200);
        item02.setItem12MeasureUnit("Kilogram");
        item02.setItem12UnitPrice(98.0);
        item02.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item02.setRawLastUpdateLogId(1);
        item02.setUpdateUserAccountId(1);
        item02.setRawActiveStatus(1);
        item02.setRawDeleteStatus(1);
        item02.setRawShowStatus(1);
        item02.setRawUpdateStatus(1);

        SBItem12 item03 = new SBItem12();
        item03.setItem12Name("Bread");
        item03.setItem12Description("Bread");
        item03.setItem12QtyOnHand(30);
        item03.setItem12MeasureUnit("Unit");
        item03.setItem12UnitPrice(55.0);
        item03.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item03.setRawLastUpdateLogId(1);
        item03.setUpdateUserAccountId(1);
        item03.setRawActiveStatus(1);
        item03.setRawDeleteStatus(1);
        item03.setRawShowStatus(1);
        item03.setRawUpdateStatus(1);

        SBItem12 item04 = new SBItem12();
        item04.setItem12Name("Cocacoola 1.5L");
        item04.setItem12Description("Cocacoola");
        item04.setItem12QtyOnHand(25);
        item04.setItem12MeasureUnit("Unit");
        item04.setItem12UnitPrice(230.0);
        item04.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item04.setRawLastUpdateLogId(1);
        item04.setUpdateUserAccountId(1);
        item04.setRawActiveStatus(1);
        item04.setRawDeleteStatus(1);
        item04.setRawShowStatus(1);
        item04.setRawUpdateStatus(1);

        SBItem12 item05 = new SBItem12();
        item05.setItem12Name("Coconut Oil");
        item05.setItem12Description("Oil");
        item05.setItem12QtyOnHand(180);
        item05.setItem12MeasureUnit("Litter");
        item05.setItem12UnitPrice(520.0);
        item05.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        item05.setRawLastUpdateLogId(1);
        item05.setUpdateUserAccountId(1);
        item05.setRawActiveStatus(1);
        item05.setRawDeleteStatus(1);
        item05.setRawShowStatus(1);
        item05.setRawUpdateStatus(1);

        SBCustomerOrder10 order01 = new SBCustomerOrder10();
        order01.setCustomerOrder10InvoiceNumber("IN0000001");
        order01.setCustomerOrder10DateTime(new Timestamp(new java.util.Date().getTime()));
        order01.setCustomerOrder10Total(2024.50);
        order01.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
        order01.setRawLastUpdateLogId(1);
        order01.setUpdateUserAccountId(1);
        order01.setRawActiveStatus(1);
        order01.setRawDeleteStatus(1);
        order01.setRawShowStatus(1);
        order01.setRawUpdateStatus(1);

        order01.setSbCustomer14(sbCustomer14);

        sbCustomer14.getCustomer14Orders().add(order01);

        order01.getCustomerOrder10Items().add(item01);
        order01.getCustomerOrder10Items().add(item02);
        order01.getCustomerOrder10Items().add(item03);
        order01.getCustomerOrder10Items().add(item04);
        order01.getCustomerOrder10Items().add(item05);

        item01.getItem12Orders().add(order01);

        item02.getItem12Orders().add(order01);

        item03.getItem12Orders().add(order01);

        item04.getItem12Orders().add(order01);

        item05.getItem12Orders().add(order01);


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
//            session.save(sbCustomer14);
//            session.save(order01);
//            session.save(item01);
//            session.save(item02);
//            session.save(item03);
//            session.save(item04);
//            session.save(item05);

            session.persist(sbCustomer14);

            transaction.commit();
            System.out.println("Added Customer 11: " + sbCustomer14.getCustomer14FirstName());
            System.out.println("Added Order 07: " + order01.getCustomerOrder10InvoiceNumber());
            System.out.println("Added Item 10 1: " + item01.getItem12Name());
            System.out.println("Added Item 10 2: " + item02.getItem12Name());
            System.out.println("Added Item 10 3: " + item03.getItem12Name());
            System.out.println("Added Item 10 4: " + item04.getItem12Name());
            System.out.println("Added Item 10 5: " + item05.getItem12Name());
        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Payment 01 and SB Card Payment 01 and SB Cheque Payment 01 without Clone")
    public void testHibernateSavePayment01CardPayment01ChequePayment01WithoutClone()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBPayment01 payment01 = new SBCardPayment01();
        payment01.setPayment01Number("PY000001");
        payment01.setPayment01Method("Cash");
        payment01.setPayment01Amount(350.00);
        payment01.setPayment01DateTime(new Timestamp(new Date().getTime()));
        payment01.setPayment01Description("Cash payment");
        payment01.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
        payment01.setRawLastUpdateLogId(1);
        payment01.setUpdateUserAccountId(1);
        payment01.setRawActiveStatus(1);
        payment01.setRawDeleteStatus(1);
        payment01.setRawShowStatus(1);
        payment01.setRawUpdateStatus(1);

        SBCardPayment01 cardPayment01 = new SBCardPayment01();
        cardPayment01.setPayment01Number("PY000002");
        cardPayment01.setPayment01Method("Card");
        cardPayment01.setPayment01Amount(240.00);
        cardPayment01.setPayment01DateTime(new Timestamp(new Date().getTime()));
        cardPayment01.setPayment01Description("Card payment");
        cardPayment01.setPayment01CardNumber("9765-1237-8239-9381");
        cardPayment01.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
        cardPayment01.setRawLastUpdateLogId(1);
        cardPayment01.setUpdateUserAccountId(1);
        cardPayment01.setRawActiveStatus(1);
        cardPayment01.setRawDeleteStatus(1);
        cardPayment01.setRawShowStatus(1);
        cardPayment01.setRawUpdateStatus(1);

        SBChequePayment01 chequePayment01 = new SBChequePayment01();
        chequePayment01.setPayment01Number("PY000003");
        chequePayment01.setPayment01Method("Cheque");
        chequePayment01.setPayment01Amount(10825.00);
        chequePayment01.setPayment01DateTime(new Timestamp(new Date().getTime()));
        chequePayment01.setPayment01Description("Cheque payment");
        chequePayment01.setPayment01chequeNumber("976-234567-234-234567-12");
        chequePayment01.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
        chequePayment01.setRawLastUpdateLogId(1);
        chequePayment01.setUpdateUserAccountId(1);
        chequePayment01.setRawActiveStatus(1);
        chequePayment01.setRawDeleteStatus(1);
        chequePayment01.setRawShowStatus(1);
        chequePayment01.setRawUpdateStatus(1);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(payment01);
            session.save(cardPayment01);
            session.save(cardPayment01);
            session.save(chequePayment01);
            transaction.commit();
            System.out.println("Added Payment: " + payment01.getPayment01Number());
            System.out.println("Added Card Payment: " + cardPayment01.getPayment01Number());
            System.out.println("Added Cheque Payment: " + chequePayment01.getPayment01Number());

        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Payment 01 and SB Card Payment 01 and SB Cheque Payment 01 Cloned for Card Payment")
    public void testHibernateSavePayment01CardPayment01ChequePayment01()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBPayment01 payment01 = new SBCardPayment01();
        payment01.setPayment01Number("PY000001");
        payment01.setPayment01Method("Cash");
        payment01.setPayment01Amount(350.00);
        payment01.setPayment01DateTime(new Timestamp(new Date().getTime()));
        payment01.setPayment01Description("Cash payment");
        payment01.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
        payment01.setRawLastUpdateLogId(1);
        payment01.setUpdateUserAccountId(1);
        payment01.setRawActiveStatus(1);
        payment01.setRawDeleteStatus(1);
        payment01.setRawShowStatus(1);
        payment01.setRawUpdateStatus(1);

        SBPayment01 payment02 = (SBPayment01) (payment01.clone());

        SBCardPayment01 cardPayment01 = (SBCardPayment01) payment02;
        cardPayment01.setPayment01Number("PY000002");
        cardPayment01.setPayment01Method("Card");
        cardPayment01.setPayment01Amount(240.00);
//        cardPayment01.setPayment01DateTime(new Timestamp(new Date().getTime()));
        cardPayment01.setPayment01Description("Card payment");
        cardPayment01.setPayment01CardNumber("9765-1237-8239-9381");
//        cardPayment01.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
//        cardPayment01.setRawLastUpdateLogId(1);
//        cardPayment01.setUpdateUserAccountId(1);
//        cardPayment01.setRawActiveStatus(1);
//        cardPayment01.setRawDeleteStatus(1);
//        cardPayment01.setRawShowStatus(1);
//        cardPayment01.setRawUpdateStatus(1);

        SBChequePayment01 chequePayment01 = new SBChequePayment01();
        chequePayment01.setPayment01Number("PY000003");
        chequePayment01.setPayment01Method("Cheque");
        chequePayment01.setPayment01Amount(10825.00);
        chequePayment01.setPayment01DateTime(new Timestamp(new Date().getTime()));
        chequePayment01.setPayment01Description("Cheque payment");
        chequePayment01.setPayment01chequeNumber("976-234567-234-234567-12");
        chequePayment01.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
        chequePayment01.setRawLastUpdateLogId(1);
        chequePayment01.setUpdateUserAccountId(1);
        chequePayment01.setRawActiveStatus(1);
        chequePayment01.setRawDeleteStatus(1);
        chequePayment01.setRawShowStatus(1);
        chequePayment01.setRawUpdateStatus(1);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(payment01);
            session.save(cardPayment01);
            session.save(cardPayment01);
            session.save(chequePayment01);
            transaction.commit();
            System.out.println("Added Payment: " + payment01.getPayment01Number());
            System.out.println("Added Card Payment: " + cardPayment01.getPayment01Number());
            System.out.println("Added Cheque Payment: " + chequePayment01.getPayment01Number());

        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Payment 02 and SB Card Payment 02 and SB Cheque Payment 02")
    public void testHibernateSavePayment02CardPayment02ChequePayment02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBPayment02 payment = new SBPayment02();
        payment.setPayment02Number("PY000001");
        payment.setPayment02Method("Cash");
        payment.setPayment02Amount(350.00);
        payment.setPayment02DateTime(new Timestamp(new Date().getTime()));
        payment.setPayment02Description("Cash payment");
        payment.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
        payment.setRawLastUpdateLogId(1);
        payment.setUpdateUserAccountId(1);
        payment.setRawActiveStatus(1);
        payment.setRawDeleteStatus(1);
        payment.setRawShowStatus(1);
        payment.setRawUpdateStatus(1);

        SBCardPayment02 cardPayment = new SBCardPayment02();
        cardPayment.setPayment02Number("PY000002");
        cardPayment.setPayment02Method("Card");
        cardPayment.setPayment02Amount(240.00);
        cardPayment.setPayment02DateTime(new Timestamp(new Date().getTime()));
        cardPayment.setPayment02Description("Card payment");
        cardPayment.setPayment02CardNumber("9765-1237-8239-9381");
        cardPayment.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
        cardPayment.setRawLastUpdateLogId(1);
        cardPayment.setUpdateUserAccountId(1);
        cardPayment.setRawActiveStatus(1);
        cardPayment.setRawDeleteStatus(1);
        cardPayment.setRawShowStatus(1);
        cardPayment.setRawUpdateStatus(1);

        SBChequePayment02 chequePayment = new SBChequePayment02();
        chequePayment.setPayment02Number("PY000003");
        chequePayment.setPayment02Method("Cheque");
        chequePayment.setPayment02Amount(10825.00);
        chequePayment.setPayment02DateTime(new Timestamp(new Date().getTime()));
        chequePayment.setPayment02Description("Cheque payment");
        chequePayment.setPayment02chequeNumber("976-234567-234-234567-12");
        chequePayment.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
        chequePayment.setRawLastUpdateLogId(1);
        chequePayment.setUpdateUserAccountId(1);
        chequePayment.setRawActiveStatus(1);
        chequePayment.setRawDeleteStatus(1);
        chequePayment.setRawShowStatus(1);
        chequePayment.setRawUpdateStatus(1);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(payment);
            session.save(cardPayment);
            session.save(chequePayment);
            transaction.commit();
            System.out.println("Added Payment: " + payment.getPayment02Number());
            System.out.println("Added Card Payment: " + cardPayment.getPayment02Number());
            System.out.println("Added Cheque Payment: " + chequePayment.getPayment02Number());

        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Payment 03 and SB Card Payment 03 and SB Cheque Payment 03")
    public void testHibernateSavePayment03CardPayment03ChequePayment03()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        SBPayment03 payment = new SBPayment03();
        payment.setPayment03Number("PY000001");
        payment.setPayment03Method("Cash");
        payment.setPayment03Amount(350.00);
        payment.setPayment03DateTime(new Timestamp(new Date().getTime()));
        payment.setPayment03Description("Cash payment");
        payment.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
        payment.setRawLastUpdateLogId(1);
        payment.setUpdateUserAccountId(1);
        payment.setRawActiveStatus(1);
        payment.setRawDeleteStatus(1);
        payment.setRawShowStatus(1);
        payment.setRawUpdateStatus(1);

        SBCardPayment03 cardPayment = new SBCardPayment03();
        cardPayment.setPayment03Number("PY000002");
        cardPayment.setPayment03Method("Card");
        cardPayment.setPayment03Amount(240.00);
        cardPayment.setPayment03DateTime(new Timestamp(new Date().getTime()));
        cardPayment.setPayment03Description("Card payment");
        cardPayment.setPayment03CardNumber("9765-1237-8239-9381");
        cardPayment.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
        cardPayment.setRawLastUpdateLogId(1);
        cardPayment.setUpdateUserAccountId(1);
        cardPayment.setRawActiveStatus(1);
        cardPayment.setRawDeleteStatus(1);
        cardPayment.setRawShowStatus(1);
        cardPayment.setRawUpdateStatus(1);

        SBChequePayment03 chequePayment = new SBChequePayment03();
        chequePayment.setPayment03Number("PY000003");
        chequePayment.setPayment03Method("Cheque");
        chequePayment.setPayment03Amount(10825.00);
        chequePayment.setPayment03DateTime(new Timestamp(new Date().getTime()));
        chequePayment.setPayment03Description("Cheque payment");
        chequePayment.setPayment03chequeNumber("976-234567-234-234567-12");
        chequePayment.setRawLastUpdateDateTime(new Timestamp(new Date().getTime()));
        chequePayment.setRawLastUpdateLogId(1);
        chequePayment.setUpdateUserAccountId(1);
        chequePayment.setRawActiveStatus(1);
        chequePayment.setRawDeleteStatus(1);
        chequePayment.setRawShowStatus(1);
        chequePayment.setRawUpdateStatus(1);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(payment);
            session.save(cardPayment);
            session.save(chequePayment);
            transaction.commit();
            System.out.println("Added Payment: " + payment.getPayment03Number());
            System.out.println("Added Card Payment: " + cardPayment.getPayment03Number());
            System.out.println("Added Cheque Payment: " + chequePayment.getPayment03Number());

        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Insert SB Payment 04 and SB Card Payment 04 and SB Cheque Payment 04")
    public void testHibernateSavePayment04CardPayment04ChequePayment04()
    {
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

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.save(payment);
            session.save(cardPayment);
            session.save(chequePayment);
            transaction.commit();
            System.out.println("Added Payment: " + payment.getPayment04Number());
            System.out.println("Added Card Payment: " + cardPayment.getPayment04Number());
            System.out.println("Added Cheque Payment: " + chequePayment.getPayment04Number());

        } catch (Throwable throwable) {
            if (transaction != null) {
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
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test CRUD Create with Address 02")
    public void testCRUDCreateWithAddress02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        List<SBAddress02> address02s = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            SBAddress02 sbAddress02 = new SBAddress02();
            sbAddress02.setAddress02Street("KusumaramaStreet" + i);
            sbAddress02.setAddress02Village("Seenigama");
            sbAddress02.setAddress02City("Hikkaduwa");
            sbAddress02.setAddress02Country("Sri Lanka");
            sbAddress02.setAddress02Zip("29200" + i);
            sbAddress02.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
            sbAddress02.setRawLastUpdateLogId(1);
            sbAddress02.setUpdateUserAccountId(1);
            sbAddress02.setRawActiveStatus(1);
            sbAddress02.setRawDeleteStatus(1);
            sbAddress02.setRawShowStatus(1);
            sbAddress02.setRawUpdateStatus(1);

            address02s.add(sbAddress02);
        }

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            address02s.forEach(address -> session.save(address));
            transaction.commit();

            address02s.forEach(address -> System.out.println("Added Address : " + address.getAddress02Street()));

        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        MoraAccessProperties accessProperties = new MoraAccessProperties();
        UuidUtilities utilities = new UuidUtilities();

        address02s.forEach(address -> {
            accessProperties.setPropertyFromPath(
                    "D:\\SLMORAWorkSpace\\IntelliJProjects\\MoraHibernateLearn004\\src\\main\\resources\\hibernatetestsupport.properties",
                    "MORA.HIBERNATE.TEST.testCRUDCreateWithAddress02." + address.getAddress02Street(),
                    utilities.getUUIDFromOrderedUUIDByteArrayWithApacheCommons(address.getAddress02Id()).toString(),
                    "Test Comment");
        });

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * set hdm2ddl.auto to update
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test CRUD Retrieve with Address 02")
    public void testCRUDRetrieveWithAddress02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        UuidUtilities utilities = new UuidUtilities();
        SBAddress02 address = null;


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            address = session.get(
                    SBAddress02.class,
                    utilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString(
                            "d0fd6f3d-f870-414b-9f3e-5bb6a63071bf")));
            transaction.commit();

        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address : " + address.getAddress02Street());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * set hdm2ddl.auto to update
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test CRUD Delete with Address 02")
    public void testCRUDDeleteWithAddress02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        UuidUtilities utilities = new UuidUtilities();
        SBAddress02 address = null;


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            address = session.get(
                    SBAddress02.class,
                    utilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString(
                            "d0fd6f3d-f870-414b-9f3e-5bb6a63071bf")));

            System.out.println("Address : " + address.getAddress02Street());

            session.delete(address);

            transaction.commit();

        } catch (Throwable throwable) {
            if (transaction != null) {
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
     * <p>
     * set hdm2ddl.auto to update
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test CRUD Update with Address 02")
    public void testCRUDUpdateWithAddress02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        UuidUtilities utilities = new UuidUtilities();
        SBAddress02 address = null;


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            address = session.get(
                    SBAddress02.class,
                    utilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString(
                            "57487766-df14-4876-9edd-c261282c6661")));
            System.out.println("Address : " + address.getAddress02Street());
            address.setAddress02Street("KusumaramaStreet5");

            session.update(address);

            address = session.get(
                    SBAddress02.class,
                    utilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString(
                            "57487766-df14-4876-9edd-c261282c6661")));
            System.out.println("Address : " + address.getAddress02Street());

            transaction.commit();

        } catch (Throwable throwable) {
            if (transaction != null) {
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
     * <p>
     * set hdm2ddl.auto to update
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Persistent Object with Address 02")
    public void testPersistentObjectWithAddress02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        UuidUtilities utilities = new UuidUtilities();

        SBAddress02 address1 = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                address1 = session.get(
                        SBAddress02.class,
                        utilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString(
                                "57487766-df14-4876-9edd-c261282c6661")));
                System.out.println("Address t1-1: " + address1.getAddress02Street());
                address1.setAddress02Street("KusumaramaStreet1000");

                SBAddress02 address2 = session.get(
                        SBAddress02.class,
                        utilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString(
                                "57487766-df14-4876-9edd-c261282c6661")));
                System.out.println("Address t2-1: " + address1.getAddress02Street());
                System.out.println("Address t2-2: " + address2.getAddress02Street());

                address2.setAddress02Street("KusumaramaStreet3000");
                System.out.println("Address t3-1: " + address1.getAddress02Street());
                System.out.println("Address t3-2: " + address2.getAddress02Street());


                //            session.update(address);
                //
                //            address = session.get(
                //                    SBAddress02.class,
                //                    utilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString("57487766-df14-4876-9edd-c261282c6661")));
                //            System.out.println("Address : "+ address.getAddress02Street());

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        address1.setAddress02Street("KusumaramaStreet5000");
        System.out.println("Address t4-1: " + address1.getAddress02Street());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * set hdm2ddl.auto to update
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Persistent Object in Delete Operation with Address 02")
    public void testPersistentObjectInDeleteWithAddress02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        UuidUtilities utilities = new UuidUtilities();

        SBAddress02 address1 = null;


        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                address1 = session.get(
                        SBAddress02.class,
                        utilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString(
                                "be4d4cb2-4ca5-4c1a-97f9-cd87941a9e1f")));
                System.out.println("Address t1-1: " + address1.getAddress02Street());
                address1.setAddress02Street("KusumaramaStreet2000");

                session.delete(address1);

                address1.setAddress02Street("KusumaramaStreet3000");

                session.save(address1);

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        address1.setAddress02Street("KusumaramaStreet6000");
        System.out.println("Address t4-1: " + address1.getAddress02Street());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * set hdm2ddl.auto to update
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Detached Object to Persistent Operation with Address 02")
    public void testDetachedToPersistentWithAddress02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        UuidUtilities utilities = new UuidUtilities();

        SBAddress02 address1 = null;

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            try {
                transaction = session.beginTransaction();
                address1 = session.get(
                        SBAddress02.class,
                        utilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString(
                                "c7cda60a-670c-429f-b60d-7fc74c99cf42")));
                System.out.println("Address t1-1: " + address1.getAddress02Street());

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

//        address1.setAddress02Street("KusumaramaStreet6000");

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            try {
                transaction = session.beginTransaction();
                session.update(address1);
                //            address1.setAddress02Street("KusumaramaStreet8000");

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address t2-1: " + address1.getAddress02Street());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test CRUD Create with Address 03")
    public void testCRUDCreateWithAddress03()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        List<SBAddress03> address03s = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            SBAddress03 sbAddress03 = new SBAddress03();
            sbAddress03.setAddress03Street("KusumaramaStreet" + i);
            sbAddress03.setAddress03Village("Seenigama");
            sbAddress03.setAddress03City("Hikkaduwa");
            sbAddress03.setAddress03Country("Sri Lanka");
            sbAddress03.setAddress03Zip("29200" + i);
            sbAddress03.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
            sbAddress03.setRawLastUpdateLogId(1);
            sbAddress03.setUpdateUserAccountId(1);
            sbAddress03.setRawActiveStatus(1);
            sbAddress03.setRawDeleteStatus(1);
            sbAddress03.setRawShowStatus(1);
            sbAddress03.setRawUpdateStatus(1);

            address03s.add(sbAddress03);
        }


        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                address03s.forEach(address -> session.save(address));
                transaction.commit();

                address03s.forEach(address -> System.out.println("Added Address : " + address.getAddress03Street()));
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        MoraAccessProperties accessProperties = new MoraAccessProperties();
        UuidUtilities utilities = new UuidUtilities();

        address03s.forEach(address -> {
            accessProperties.setPropertyFromPath(
                    "D:\\SLMORAWorkSpace\\IntelliJProjects\\MoraHibernateLearn004\\src\\main\\resources\\hibernatetestsupport.properties",
                    "MORA.HIBERNATE.TEST.testCRUDCreateWithAddress03." + address.getAddress03Street(),
                    utilities.getUUIDFromOrderedUUIDByteArrayWithApacheCommons(address.getAddress03Id()).toString(),
                    "Test Comment");
        });

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * set hdm2ddl.auto to update
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Detached Object to Persistent Operation with Select Before Update with Address 03")
    public void testDetachedToPersistentWithSelectBeforeUpdateWithAddress03()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        UuidUtilities utilities = new UuidUtilities();

        SBAddress03 address1 = null;

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            try {
                transaction = session.beginTransaction();
                address1 = session.get(
                        SBAddress03.class,
                        utilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString(
                                "e9c79954-9a5e-4903-ac5f-8e3268b14544")));
                System.out.println("Address t1-1: " + address1.getAddress03Street());

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }
        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

//        address1.setAddress02Street("KusumaramaStreet6000");

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            try {
                transaction = session.beginTransaction();
                session.update(address1);

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }
        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address t2-1: " + address1.getAddress03Street());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * to add data to table get execute testCRUDCreateWithAddress02
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test HQL Query with Address 02")
    public void testHQLQueryWithAddress02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        List address = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                Query query = session.createQuery("from SBAddress02");
                address = query.list();

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }
        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address : " + address.size());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * to add data to table get execute testCRUDCreateWithAddress02
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test HQL Query for Where with Address 02")
    public void testHQLQueryForWhereWithAddress02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        List<SBAddress02> addresses = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                Query query = session.createQuery("from SBAddress02 where address02Zip like '%1%'");
                addresses = query.list();

                transaction.commit();

                addresses.forEach(address -> System.out.println("Added Address : " + address.getAddress02Street()));
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address : " + addresses.size());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * to add data to table get execute testCRUDCreateWithAddress02
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test HQL Query for Pagination with Address 02")
    public void testHQLQueryForPaginationWithAddress02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        List<SBAddress02> addresses = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                Query query = session.createQuery("from SBAddress02 order by address02Street asc");
                query.setFirstResult(5);
                query.setMaxResults(10);

                addresses = query.list();

                transaction.commit();

                addresses.forEach(address -> System.out.println("Added Address : " + address.getAddress02Street()));
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address : " + addresses.size());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * to add data to table get execute testCRUDCreateWithAddress02
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test HQL Query for Single Select and Pagination with Address 02")
    public void testHQLQueryForSingleSelectAndPaginationWithAddress02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                Query query = session.createQuery("select address02Street from SBAddress02 order by address02Street asc");
                query.setFirstResult(5);
                query.setMaxResults(10);

                List<String> addressStreets = query.list();

                transaction.commit();

                addressStreets.forEach(System.out::println);
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
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
     * <p>
     * to add data to table get execute testCRUDCreateWithAddress02
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test HQL Query for Multiple Select and Pagination with Address 02")
    public void testHQLQueryForMultipleSelectAndPaginationWithAddress02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                Query query = session.createQuery(
                        "select address02Street, address02Zip from SBAddress02 order by address02Street asc");
                query.setFirstResult(5);
                query.setMaxResults(10);

                List<Object[]> addressDetails = query.list();

                transaction.commit();

                addressDetails.forEach(address -> System.out.println("Added Address : " + address[0]));

                System.out.println(addressDetails.size());
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
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
     * <p>
     * to add data to table get execute testCRUDCreateWithAddress02
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test HQL Query for Multiple Select for Map and Pagination with Address 02")
    public void testHQLQueryForMultipleSelectForMapAndPaginationWithAddress02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                Query query = session.createQuery(
                        "select new Map(address02Zip, address02Street) from SBAddress02 order by address02Street asc");
                query.setFirstResult(5);
                query.setMaxResults(10);

                List<Map<String, String>> addressDetails = query.list();

                transaction.commit();

                System.out.println(addressDetails.size());

                String street = addressDetails
                        .stream()
                        .filter(address -> address.containsKey("1"))
                        .findFirst()
                        .get()
                        .get("1");

                System.out.println("First Street : " + street);

                List<String> streets = addressDetails
                        .stream()
                        .map(address -> address.get("1"))
                        .collect(Collectors.toList());

                streets.forEach(System.out::println);
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }
        } catch (Throwable throwable) {
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
     * <p>
     * to add data to table get execute testCRUDCreateWithAddress02
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test HQL Query with Parameter Binding with Address 02")
    public void testHQLQueryWithParameterBindingWithAddress02()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        UuidUtilities utilities = new UuidUtilities();
        List<SBAddress02> addresses = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

//            Query query = session.createQuery("from SBAddress02 where address02Zip = '292000' or address02Zip = '2920013'");
//                Query query = session.createQuery("from SBAddress02 where address02Zip = ? or address02Zip = ?"); // No longer support
                Query query = session.createQuery("from SBAddress02 where address02Zip = ?1 or address02Zip = :searchParam");
//                    .setParameter(1,"292000")
//                    .setParameter("searchParam","2920013");
                query.setParameter(1, "292000");
                query.setParameter("searchParam", "2920013");

                addresses = query.list();

                transaction.commit();

                addresses.forEach(address -> System.out.println("Added Address : " + address.getAddress02Street()));
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address : " + addresses.size());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test CRUD Create with Address 04")
    public void testCRUDCreateWithAddress04()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        List<SBAddress04> address04s = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            SBAddress04 sbAddress04 = new SBAddress04();
            sbAddress04.setAddress04Street("KusumaramaStreet" + i);
            sbAddress04.setAddress04Village("Seenigama");
            sbAddress04.setAddress04City("Hikkaduwa");
            sbAddress04.setAddress04Country("Sri Lanka");
            sbAddress04.setAddress04Zip("29200" + i);
            sbAddress04.setRawLastUpdateDateTime(new Timestamp(new java.util.Date().getTime()));
            sbAddress04.setRawLastUpdateLogId(1);
            sbAddress04.setUpdateUserAccountId(1);
            sbAddress04.setRawActiveStatus(1);
            sbAddress04.setRawDeleteStatus(1);
            sbAddress04.setRawShowStatus(1);
            sbAddress04.setRawUpdateStatus(1);

            address04s.add(sbAddress04);
        }

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            address04s.forEach(address -> session.save(address));
            transaction.commit();

            address04s.forEach(address -> System.out.println("Added Address : " + address.getAddress04Street()));

        } catch (Throwable throwable) {
            if (transaction != null) {
                transaction.rollback();
            }
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        MoraAccessProperties accessProperties = new MoraAccessProperties();
        UuidUtilities utilities = new UuidUtilities();

        address04s.forEach(address -> {
            accessProperties.setPropertyFromPath(
                    "D:\\SLMORAWorkSpace\\IntelliJProjects\\MoraHibernateLearn004\\src\\main\\resources\\hibernatetestsupport.properties",
                    "MORA.HIBERNATE.TEST.testCRUDCreateWithAddress04." + address.getAddress04Street(),
                    utilities.getUUIDFromOrderedUUIDByteArrayWithApacheCommons(address.getAddress04Id()).toString(),
                    "Test Comment");
        });

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * to add data to table get execute testCRUDCreateWithAddress02
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test HQL Query with Named Query with Address 04")
    public void testHQLQueryWithNamedQueryWithAddress04()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        List<SBAddress04> addresses = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                Query query = session.getNamedQuery("SBAddress04.getFromZip")
                    .setParameter(1,"292000");

                addresses = query.list();

                transaction.commit();

                addresses.forEach(address -> System.out.println("Added Address : " + address.getAddress04Street()));
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address : " + addresses.size());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * to add data to table get execute testCRUDCreateWithAddress02
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test HQL Query with Named Native Query with Address 04")
    public void testHQLQueryWithNamedNativeQueryWithAddress04()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        List<SBAddress04> addresses = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                Query query = session.getNamedNativeQuery("SBAddress04.getFromStreetNative")
                        .setParameter(1,"KusumaramaStreet10");

                addresses = query.list();

                transaction.commit();

                addresses.forEach(address -> System.out.println("Added Address : " + address.getAddress04Zip()));
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address : " + addresses.size());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * to add data to table get execute testCRUDCreateWithAddress02
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test HQL Query with Criteria Query with Address 04")
    public void testHQLQueryWithCriteriaQueryWithAddress04()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        List<SBAddress04> addresses = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
                CriteriaQuery<SBAddress04> criteriaQuery = criteriaBuilder.createQuery(SBAddress04.class);
                Root<SBAddress04> root = criteriaQuery.from(SBAddress04.class);
                criteriaQuery.select(root);

                Query query = session.createQuery(criteriaQuery);

                addresses = query.list();

                transaction.commit();

                addresses.forEach(address -> System.out.println("Added Address : " + address.getAddress04Zip()));
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address : " + addresses.size());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * to add data to table get execute testCRUDCreateWithAddress02
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test HQL Query with Criteria Query for where with Address 04")
    public void testHQLQueryWithCriteriaQueryForWhereWithAddress04()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        List<SBAddress04> addresses = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
                CriteriaQuery<SBAddress04> criteriaQuery = criteriaBuilder.createQuery(SBAddress04.class);
                Root<SBAddress04> root = criteriaQuery.from(SBAddress04.class);

                criteriaQuery.select(root)
                        .where(criteriaBuilder.equal(root.get("address04Zip"),"292000"))
                        .orderBy(criteriaBuilder.asc(root.get("address04Street")));

                Query query = session.createQuery(criteriaQuery);

                addresses = query.list();

                transaction.commit();

                addresses.forEach(address -> System.out.println("Added Address : " + address.getAddress04Street()));
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address : " + addresses.size());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * to add data to table get execute testCRUDCreateWithAddress02
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test HQL Query with Criteria Query for Multiple where with Address 04")
    public void testHQLQueryWithCriteriaQueryForMultipleWhereWithAddress04()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        List<SBAddress04> addresses = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
                CriteriaQuery<SBAddress04> criteriaQuery = criteriaBuilder.createQuery(SBAddress04.class);
                Root<SBAddress04> root = criteriaQuery.from(SBAddress04.class);

//                criteriaQuery.select(root)
//                        .where(criteriaBuilder.equal(root.get("address04Zip"),"292000"))
//                        .where(criteriaBuilder.like(root.get("address04City"),"Hikkaduwa"));

                Predicate[] predicates = new Predicate[2];
                predicates[0] = criteriaBuilder.equal(root.get("address04Zip"),"292000");
                predicates[1] = criteriaBuilder.like(root.get("address04City"),"Hikkaduwa");

                //AND
//                criteriaQuery.select(root)
//                        .where(predicates);

                //OR
//                criteriaQuery.select(root)
//                        .where(criteriaBuilder.or(predicates[0],predicates[1]));

                //AND
                criteriaQuery.select(root)
                        .where(criteriaBuilder.and(predicates[0],predicates[1]));

                Query query = session.createQuery(criteriaQuery);

                addresses = query.list();

                transaction.commit();

                addresses.forEach(address -> System.out.println("Added Address : " + address.getAddress04Street()));
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address : " + addresses.size());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * to add data to table get execute testCRUDCreateWithAddress02
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test Criteria Query with Projection with Address 04")
    public void testCriteriaQueryWithProjectionWithAddress04()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        List<Long> addresses = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();

                CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
                CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
                Root<SBAddress04> root = criteriaQuery.from(SBAddress04.class);

                criteriaQuery.select(criteriaBuilder.count(root));

                Query query = session.createQuery(criteriaQuery);

                addresses = query.list();

                transaction.commit();

                addresses.forEach(System.out::println);

            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address : " + addresses.size());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");

    }

    /**
     * This method runs getPropertyFromResource(String propertyFileName, String propertyRef) methods in MoraAccessProperties class
     * This compare for expected TEST_OUT_PUT_STRING
     * <p>
     * to add data to table get execute testCRUDCreateWithAddress02
     */
    @Test
    @Tag("CREATE")
    @Tag("RESOURCE")
    @DisplayName("Test First Level Cache Address 04")
    public void testFirstLevelCacheWithAddress04()
    {
        System.out.println("Programme Start");
        long startTime = System.nanoTime();

        UuidUtilities utilities = new UuidUtilities();
        SBAddress04 address1 = null;

        SBAddress04 address2 = null;


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            try{
                System.out.println("Session Start");
                transaction = session.beginTransaction();
                address1 = session.get(
                        SBAddress04.class,
                        utilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString(
                                "a5a4e8af-6564-4742-8efb-85e89e623bc4")));

                address2 = session.get(
                        SBAddress04.class,
                        utilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString(
                                "a5a4e8af-6564-4742-8efb-85e89e623bc4")));
                transaction.commit();
                System.out.println("Session Closed");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address 1 : " + address1.getAddress04Street());
        System.out.println("Address 2 : " + address2.getAddress04Street());

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            try{
                System.out.println("Session Start");
                transaction = session.beginTransaction();
                address1 = session.get(
                        SBAddress04.class,
                        utilities.getOrderedUUIDByteArrayFromUUIDWithApacheCommons(UUID.fromString(
                                "a5a4e8af-6564-4742-8efb-85e89e623bc4")));
                transaction.commit();
                System.out.println("Session Closed");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
            }

        } catch (Throwable throwable) {
            LOGGER.error(ExceptionUtils.getFullStackTrace(throwable));
            throwable.printStackTrace();
        }

        System.out.println("Address 1 : " + address1.getAddress04Street());

        long endTime = System.nanoTime();
        ELAPSED_TIME = endTime - startTime;
        System.out.println("Programme End");
    }
}
