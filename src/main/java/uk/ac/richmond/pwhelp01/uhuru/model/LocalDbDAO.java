/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.richmond.pwhelp01.uhuru.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        ps.close();
        conn.close();
    }
    
    
    public List<Schema> getSchemaList() throws SQLException {
        
        // Create list to hold results
        List<Schema> results = new ArrayList<Schema>();
        
        // Create prepared statement
        String stmt = "SELECT SERVER, DATABASE, ROOTNODE, JARFILE, TIMESTAMP "
                + "FROM SCHEMA "
                + "ORDER BY TIMESTAMP DESC;";
        PreparedStatement ps = conn.prepareStatement(stmt);
        
        // Get result set and cycle through adding each entry to the list
        ResultSet rs = ps.executeQuery();
        
        // Fetch each row from the result set
        while(rs.next()) {
            
            // Variables to hold results
            String server = rs.getString("SERVER");
            String database = rs.getString("DATABASE");
            String rootNode = rs.getString("ROOTNODE");
            String jarFile = rs.getString("JARFILE");
            Schema schema = new Schema(server, database, rootNode, jarFile);

            // Add new schema object to list
            results.add(schema);
        
        }
        
        return results;
    }
}
