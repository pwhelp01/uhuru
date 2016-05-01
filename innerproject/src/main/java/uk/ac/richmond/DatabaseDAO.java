/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.richmond;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import generated.*;

/**
 * Data Access Object for the SQL Server database
 * 
 * <p>Acts as a facade for the generated classes
 * @author peedeeboy
 */
public class DatabaseDAO {
        
    public DatabaseDAO() {
        
        
        
    }
    /**
     * Create a new relational schema in the SQL Server database
     * 
     * @param server SQL Server hostname
     * @param database Database name
     * @param username Username to connect to SQL Server
     * @param password PAssword to connect ot SQL Server
     */
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

        // Create new Entity Manager for "generated" persistence unit
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("generated", persistenceProps);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        // Open and close a transaction to force Hibernate to create the relational schema
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        
        // Close entity manager and factory
        entityManager.close();
        entityManagerFactory.close();
    }
    
    /**
     * Populate a lookup table in the SQL Server
     * @param server SQL Server Hostname
     * @param database Database name
     * @param username Username for SQL Server connection
     * @param password Password for SQL Server connection
     * @param name Name of the table to populate 
     * @param value Lookup value to populate into the table
     * @throws ClassNotFoundException Error loading SQL Server driver
     * @throws InstantiationException Error creating entity
     * @throws IllegalAccessException Error creating entity
     */
    public void populateLookup  (String server, String database, String username, String password, String name, 
            String value) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        
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
        
        // Create query
        String str = name.replace("Content", "");
        String tableName = str.toUpperCase();
        String queryStr = "IF EXISTS (SELECT 'True' FROM INFORMATION_SCHEMA.TABLES "
                + "WHERE TABLE_NAME = 'xxxxx') "
                + "INSERT INTO xxxxx (VALUE_) VALUES (?1);";
        String parsedQueryStr = queryStr.replaceAll("xxxxx", tableName);
        
        Query query = entityManager.createNativeQuery(parsedQueryStr);
        query.setParameter(1, value);
        
        System.out.println(parsedQueryStr);
        
        entityManager.getTransaction().begin();
        int i = query.executeUpdate();
        entityManager.getTransaction().commit();
        
        entityManager.close();
        entityManagerFactory.close();
        
    } 
    
    public void createXml(String server, String database, String username, 
            String password, String rootNode, File xmlFile) throws Exception {
        
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
        
        
        // Create JAXB Context and XML Marshaller
        JAXBContext context = JAXBContext.newInstance("generated");
        Marshaller marshaller = context.createMarshaller();
        
        
        // Create DOM result and get XML
        // There should only be one root element, so assume ID = 1
        DOMResult xml = new DOMResult();
        marshaller.marshal(entityManager.find(Class.forName("generated." + rootNode), 1L), xml);
        
        // Output to XML file
        Source source = new DOMSource(xml.getNode());
        Result result = new StreamResult(xmlFile);
        
        Transformer transformer = TransformerFactory.newInstance()
                                                    .newTransformer();
        
        transformer.transform(source, result);
        
        // Close entity manager connection
        entityManager.close();
        
    }
}
