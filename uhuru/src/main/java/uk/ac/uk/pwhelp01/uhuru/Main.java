/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import java.io.File;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.Map;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JclObjectFactory;

/**
 *
 * @author peedeeboy
 */
public class Main {

    public static void main(String[] args) {

        // Set properties
        String workingdirectory = System.getProperty("user.dir") + "/innerproject";
        String[] arguments = {"clean", "compile", "dependency:copy-dependencies"};

        // Create new instance of inner project
        InnerProject prj = new InnerProject(arguments, workingdirectory);

        // Build inner project
        try {
            prj.build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // Create new classloader
        try {
            // Create an array of URLs to add to the customclassloader class path
            URL[] urls = {new URL("file:///home/peedeeboy/git/uhuru/uhuru/innerproject/target/classes/"),
                new URL("file:///home/peedeeboy/git/uhuru/uhuru/target/lib/")};
            
            // Create classloader
            CustomClassLoader cl = new CustomClassLoader(urls);
            Class cls = cl.loadClass("generated.APStudentRecord");
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // Load a class!
    }

    private static void loadClasses() {

        JarClassLoader jcl = new JarClassLoader();
        jcl.add("/home/peedeeboy/git/hesa-utility/hyperjaxb3-ejb-template-basic-0.5.6/target/generated-sources/xjc/generated/"); //Load class folder   

        JclObjectFactory factory = JclObjectFactory.getInstance();

        Map<String, Class> loadedClasses = jcl.getLoadedClasses();

        for (Map.Entry<String, Class> entry : loadedClasses.entrySet()) {
            System.out.println(entry.getValue().getClass().getCanonicalName());
        }

        //Create object of loaded class  
        //Object obj = factory.create(jcl,"generated.APStudentRecord");
        //System.out.println(obj.getClass().getCanonicalName());
    }
}
