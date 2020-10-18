/*
 * Created by IntelliJ IDEA.
 * @Author: SLMORA
 * @DateTime: 10/18/2020 1:29 PM
 */
package com.slmora.learn.common.hibernate;

import com.slmora.learn.common.db.connection.type2.DBConnection2;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * This Class created for
 *
 * @Author: SLMORA
 * @DateTime: 10/18/2020 1:29 PM
 * <p>
 * Version      Date            Editor              Note
 * ----------------------------------------------------------------------------------------------------------------
 * 1.0          10/18/2020      SLMORA                Initial Code
 */
public class HibernateUtil
{
    final static Logger LOGGER = LogManager.getLogger(HibernateUtil.class);

    private static StandardServiceRegistry REGISTRY;
    private static SessionFactory SESSION_FACTORY;

    private HibernateUtil(){
    }

    public static SessionFactory getSessionFactory() throws Throwable{
        if(SESSION_FACTORY == null){
            try {
                REGISTRY =new StandardServiceRegistryBuilder().configure().build();
                MetadataSources sources=new MetadataSources(REGISTRY);
                Metadata metadata=sources.getMetadataBuilder().build();
                SESSION_FACTORY =metadata.getSessionFactoryBuilder().build();
            }catch (Exception e){
                LOGGER.error(ExceptionUtils.getFullStackTrace(e));
                e.printStackTrace();
                if(REGISTRY != null){
                    StandardServiceRegistryBuilder.destroy(REGISTRY);
                }
            }
        }
        return SESSION_FACTORY;
    }

    public static void shutdown(){
        if(REGISTRY != null){
            StandardServiceRegistryBuilder.destroy(REGISTRY);
        }
    }
}
