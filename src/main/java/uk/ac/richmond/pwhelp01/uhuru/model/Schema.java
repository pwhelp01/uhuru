/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.richmond.pwhelp01.uhuru.model;

import java.time.LocalDateTime;

/**
 * Class representing metadata about a generated schema
 * @author peedeeboy
 */
public class Schema {
    
    private String server;
    private String database;
    private String rootNode;
    private String jarLocation;
    
    /**
     * Constructs a new instance of Schema
     * 
     * @param server Server name of the SQL Server
     * @param database Database name in the SQL Server
     * @param rootNode Root node of the .xsd file
     * @param jarLocation File path of the generated .jar file
     */
    public Schema(String server, String database, String rootNode, String jarLocation) {
        this.server = server;
        this.database = database;
        this.rootNode = rootNode;
        this.jarLocation = jarLocation;
    }
    
    /**
     * Overides the toString() method to be used in combobox in the views
     * @return String representation of metadata
     */
    @Override
    public String toString() {
        return("Database=" + server + "." + database + " Root= " + rootNode);
    }    
}
