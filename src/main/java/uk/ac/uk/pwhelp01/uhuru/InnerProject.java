/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import java.io.File;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author peedeeboy
 */
public class InnerProject {
    
    ObjectProperty<File> schemaFile = new SimpleObjectProperty(new File(""));
    ObjectProperty<File> dataFile = new SimpleObjectProperty();
    ObjectProperty<File> codeFile = new SimpleObjectProperty();
    
    StringProperty buildMessage = new SimpleStringProperty();
    DoubleProperty buildStatus = new SimpleDoubleProperty();
    
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
    
    
}
