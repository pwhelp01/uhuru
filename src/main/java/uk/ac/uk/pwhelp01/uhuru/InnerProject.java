/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import java.io.File;
import java.io.PrintStream;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.apache.maven.cli.MavenCli;

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
    String[] args = {"clean", "--errors", "-l test.log", "--debug"}; //{"clean", "compile", "dependency:copy-dependencies"};
    String workingDirectory = System.getProperty("user.dir") + "/innerproject";
    PrintStream stdout = System.out;
    PrintStream stderr = System.out;
    
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
        System.out.println(this.args);
        
        
        // Build inner project
        int result = cli.doMain(this.args, this.workingDirectory, this.stdout, this.stderr);
        
        // Check if build failed (return value other than 0) and raise error if it did
        if(result != 0) {
            throw new Exception("Maven build failed with error code: " + result);
        }

    }
}
