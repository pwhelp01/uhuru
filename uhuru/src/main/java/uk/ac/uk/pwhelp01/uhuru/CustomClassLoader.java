/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
/**
 *
 * @author peedeeboy
 */
public class CustomClassLoader {
    
    URLClassLoader cl;
    
    public CustomClassLoader(URL[] urlsIn) throws Exception {

            // Create classloader
            this.cl = new URLClassLoader(urlsIn); 
        
    }
    
    public Class loadClass(String classnameIn) throws ClassNotFoundException {
        
        try {
            return this.cl.loadClass(classnameIn);
        }
        catch(ClassNotFoundException e) {
            throw e;
        }
        
    }
}
