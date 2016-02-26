/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import java.util.Map;
import org.apache.maven.cli.MavenCli;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JclObjectFactory;

/**
 *
 * @author peedeeboy
 */
public class Main {
    
    public static void main(String[] args) {
        
        String workingdirectory = System.getProperty("user.dir") + "\\innerproject";
        String[] arguments = {"clean", "compile"};
        
        
        InnerProject prj = new InnerProject(arguments, workingdirectory);
        
        try {
            prj.build();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        
        /* 
        buildInnerProject();
        loadClasses();
        System.out.println("Got here");
       */
    }
    
    
    private static void buildInnerProject() {
        
         // Create new instance of MavenCLI
        MavenCli cli = new MavenCli();
        
        // Build inner project
        int result = cli.doMain(new String[]{"clean", "compile"}, 
                "/home/peedeeboy/git/hesa-utility/hyperjaxb3-ejb-template-basic-0.5.6", 
                System.out, System.out);
           
        // Print result
        System.out.println("result: " + result);
    }
    
    
    private static void loadClasses() {
        
        JarClassLoader jcl = new JarClassLoader();   
        jcl.add("/home/peedeeboy/git/hesa-utility/hyperjaxb3-ejb-template-basic-0.5.6/target/generated-sources/xjc/generated/"); //Load class folder   
        
        
        JclObjectFactory factory = JclObjectFactory.getInstance();  
        
        Map<String,Class> loadedClasses = jcl.getLoadedClasses();
        
        for (Map.Entry<String,Class> entry : loadedClasses.entrySet()) {
            System.out.println(entry.getValue().getClass().getCanonicalName());
        }
        
        //Create object of loaded class  
        //Object obj = factory.create(jcl,"generated.APStudentRecord");
        //System.out.println(obj.getClass().getCanonicalName());
        
    }
}
