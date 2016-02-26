/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.richmond;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.persistence.Persistence;

/**
 *
 * @author pete
 */
public class Program {
    
    public static void main(String[] args) {
     
        HESA h = new HESA();
        
        /* Uncomment the appropriate line below */
        //h.createDatabase();
        h.createXML();
    }
}
