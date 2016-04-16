/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.apache.maven.cli.MavenCli;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;

/**
 *
 * @author peedeeboy
 */
public class InnerProject {
    
    ObjectProperty<File> schemaFile = new SimpleObjectProperty();
    ObjectProperty<File> dataFile = new SimpleObjectProperty();
    ObjectProperty<File> codeFile = new SimpleObjectProperty();
    
    StringProperty buildMessage = new SimpleStringProperty();
    DoubleProperty buildStatus = new SimpleDoubleProperty();
    
    MavenCli cli = new MavenCli();
    String workingDirectory = System.getProperty("user.dir") + "/innerproject";
    String[] args = {"--version"}; //{"clean", "--errors", "-l test.log", "--debug"}; //{"clean", "compile", "dependency:copy-dependencies"};
    PrintStream stdout = System.out;
    PrintStream stderr = System.out;
    
    String resourcesDirectory = workingDirectory + "/src/main/resources/";
    
    
    // Constructors
    public void InnerProject() {
        
    }
    // Getters and setters
    public File getSchemaFile() {
        return schemaFile.get();
    }
    
    public void setSchemaFile(File schemaFile) {
        this.schemaFile.set(schemaFile);
    }
    
    public File getDataFile() {
        return dataFile.get();
    }
    
    public void setDataFile(File dataFile) {
        this.dataFile.set(dataFile);
    }
    
    public File getCodeFile() {
        return codeFile.get();
    }
    
    public void setCodeFile(File codeFile) {
        this.codeFile.set(codeFile);
    }
    
    // Methods
    public void build() throws Exception {
        
        System.out.println(this.workingDirectory);
        for(String s : args) {
            System.out.println(s);
        }
        
        // System.setProperty("maven.multiModuleProjectDirectory", this.workingDirectory);
        
        // Build inner project
        int result = cli.doMain(this.args, this.workingDirectory, this.stdout, this.stderr);
        
        // Check if build failed (return value other than 0) and raise error if it did
        if(result != 0) {
            throw new Exception("Maven build failed with error code: " + result);
        }

    }
    
    public void invokeMaven() {
        
        InvocationRequest request = new DefaultInvocationRequest();
        final List<String> MAVEN_GOALS = Arrays.asList("clean", "install", "package");
        
        request.setPomFile( new File( "/home/peedeeboy/git/uhuru/innerproject/pom.xml" ) );
        request.setGoals(MAVEN_GOALS);

        
        Invoker invoker = new DefaultInvoker();
        // invoker.setMavenHome(null)
        
        try {
            InvocationResult result = invoker.execute(request);
            System.out.println("Maven exited with code " + result.getExitCode());
        }
        catch(MavenInvocationException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
        
    public void copyFiles() {

        File schemaDest = new File(resourcesDirectory + schemaFile.get().getName());
        File dataDest = new File(resourcesDirectory + dataFile.get().getName());
        File codeDest = new File(resourcesDirectory + codeFile.get().getName());
        
        try {
            Files.copy(schemaFile.get(), schemaDest);
            Files.copy(dataFile.get(), dataDest);
            Files.copy(codeFile.get(), codeDest);
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
}
