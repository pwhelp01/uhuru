/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author peedeeboy
 */
public class LocalDbDAO {
    
    Connection conn;
    Settings settings = new Settings();
    
    public LocalDbDAO() throws ClassNotFoundException, SQLException {
        
        // Build connection string
        String connStr = "jdbc:h2:" + settings.getUhuruDir() + "/database";
        
        // Get H2 drive
        Class.forName("org.h2.Driver");
        
        // Create connection
        conn = DriverManager.getConnection(connStr, "sa", "");
    }
    
    public void updateSchema(String server, String database, String rootNode, String jarLocation) 
        throws SQLException {
        
        // Create prepared statement
        String stmt = "MERGE INTO SCHEMA (SERVER, DATABASE, ROOTNODE, JARFILE, TIMESTAMP) " 
                + "VALUES(?, ?, ?, ?, CURRENT_TIMESTAMP);";
        
        PreparedStatement ps = conn.prepareStatement(stmt);
        
        // Populate parameters
        ps.setString(1, server);
        ps.setString(2, database);
        ps.setString(3, rootNode);
        ps.setString(4, jarLocation);
        
        // Excute query and close connection
        int i = ps.executeUpdate();  

        conn.close();
    }
}
