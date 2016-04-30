
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
 * Data access object to communicate with the local H2 database
 * @author peedeeboy
 */
public class LocalDbDAO {
    
    Connection conn;
    Settings settings = new Settings();
    
    /**
     * Create a new LocalDbDAO instance
     * @throws ClassNotFoundException Could not load H2 driver
     * @throws SQLException Error creating connection to database
     */
    public LocalDbDAO() throws ClassNotFoundException, SQLException {
        
        // Build connection string
        String connStr = "jdbc:h2:" + settings.getUhuruDir() + "/database";
        
        // Get H2 driver
        Class.forName("org.h2.Driver");
        
        // Create connection
        conn = DriverManager.getConnection(connStr, "sa", "");
    }
    
    /**
     * Add / Update metadata about a scheama
     * 
     * <p>Inserts/updates a row in the SCHEMA table
     * @param server Server name of the SQL Server
     * @param database Database name in the SQL Server
     * @param rootNode Rootnode of the main .xsd schema file
     * @param jarLocation Path to the generated .jar file
     * @throws SQLException Error updating local H2 database
     */
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
    
    /**
     * Get all elements from the SCHEMA table
     * 
     * @return List of Schema elements
     * @throws SQLException Error occurred querying database
     */
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
