/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.richmond;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.net.URL;
import java.security.ProtectionDomain;
import javax.persistence.spi.PersistenceProvider;
import org.hibernate.ejb.HibernatePersistence;
import generated.*;

/**
 *
 * @author peedeeboy
 */
public class DatabaseDAO {
    
    
    public void createSchema(String server, String database, String username, String password) {
        
        // Create Hibernate connection string
        String connectionString = "jdbc:jtds:sqlserver://" + server + "/" + database;
        
        Map<String, String> persistenceProps =  new HashMap<String, String>();
        persistenceProps.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        persistenceProps.put("hibernate.connection.driver_class", "net.sourceforge.jtds.jdbc.Driver");
        persistenceProps.put("hibernate.connection.username", username);
        persistenceProps.put("hibernate.connection.password", password);
        persistenceProps.put("hibernate.connection.url", connectionString);
        persistenceProps.put("hibernate.hbm2ddl.auto", "create");
        persistenceProps.put("hibernate.cache.provider_class", "org.hibernate.cache.HashtableCacheProvider");
        persistenceProps.put("hibernate.jdbc.batch_size", "0");

    }
    
    
    public void populateLookup  (String server, String database, String username, String password, String name, 
            String value) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        //showLoc(DatabaseDAO.class);
        //showLoc(HibernatePersistence.class);
        //showLoc(PersistenceProvider.class);
        
        // Create Hibernate connection string
        String connectionString = "jdbc:jtds:sqlserver://" + server + "/" + database;
        
        Map<String, String> persistenceProps =  new HashMap<String, String>();
        persistenceProps.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        persistenceProps.put("hibernate.connection.driver_class", "net.sourceforge.jtds.jdbc.Driver");
        persistenceProps.put("hibernate.connection.username", username);
        persistenceProps.put("hibernate.connection.password", password);
        persistenceProps.put("hibernate.connection.url", connectionString);
        persistenceProps.put("hibernate.hbm2ddl.auto", "none");
        persistenceProps.put("hibernate.cache.provider_class", "org.hibernate.cache.HashtableCacheProvider");
        persistenceProps.put("hibernate.jdbc.batch_size", "0");
        
        // Create entitymanager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("generated", persistenceProps);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        String queryStr = "INSERT INTO $table (value) VALUES (:value);";
        String parsedQueryStr = queryStr.replace("$table", name);
        
        Query query = entityManager.createNativeQuery(parsedQueryStr);
        query.setParameter("value", value);
        
        System.out.println(name + " : " + value);
        entityManager.close();
        entityManagerFactory.close();
        
    }
    
    
    public static void showLoc(Class cls)
    {
        System.out.println("CLASS = " + cls.getName());
        ProtectionDomain domain = cls.getProtectionDomain();
        ClassLoader loader=domain.getClassLoader();
        URL source = domain.getCodeSource().getLocation();
        System.out.println("\tloader = " + loader);
        System.out.println("\tsource = " + source);
    }
    
    
    
}
