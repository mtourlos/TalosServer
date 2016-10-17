package org.talos.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Utility class for hibernate
 */
public class HibernateUtil {

    /**
     * {@link SessionFactory}
     */
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Builds the {@link SessionFactory}
     * @return {@link SessionFactory}
     */
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration().configure("org/talos/hibernate/hibernate.cfg.xml");
            return configuration.buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Gets the {@link SessionFactory}
     * @return the {@link SessionFactory}
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    /**
     * Closes the {@link SessionFactory}
     */
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }

}
