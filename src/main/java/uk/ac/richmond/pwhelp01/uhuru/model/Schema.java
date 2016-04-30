/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.richmond.pwhelp01.uhuru.model;

import java.time.LocalDateTime;

/**
 *
 * @author peedeeboy
 */
public class Schema {
    
    private String server;
    private String database;
    private String rootNode;
    private String jarLocation;
    
    
    public Schema(String server, String database, String rootNode, String jarLocation) {
        this.server = server;
        this.database = database;
        this.rootNode = rootNode;
        this.jarLocation = jarLocation;
    }
    
    @Override
    public String toString() {
        return("Database=" + server + "." + database + " Root= " + rootNode);
    }    
}
