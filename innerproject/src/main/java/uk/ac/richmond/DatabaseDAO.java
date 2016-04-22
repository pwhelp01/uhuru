/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.richmond;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author peedeeboy
 */
public class DatabaseDAO {
    
    
    public void createSchema(String username, String password, String server, String database) {
        
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
        
        
        persistenceProps.forEach((k, v) -> System.out.println(k + "=" + v));
        
    }
    
}
