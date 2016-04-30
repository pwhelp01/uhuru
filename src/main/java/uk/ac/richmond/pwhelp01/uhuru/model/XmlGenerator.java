/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.richmond.pwhelp01.uhuru.model;

import java.io.File;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author peedeeboy
 */
public class XmlGenerator {
    
    private ObservableList<Schema> schemas;
    private LocalDbDAO localDb;    
    
    private Schema workingSchema;
    private ObjectProperty<File> xmlFile = new SimpleObjectProperty();
    
    private StringProperty status = new SimpleStringProperty("");
    private DoubleProperty progress = new SimpleDoubleProperty(0.0);
    
    
    // Constructors
    public XmlGenerator() throws Exception {
        
        // Get schemas from the local database
        localDb = new LocalDbDAO();
        List<Schema> rowdata = localDb.getSchemaList();
        schemas = FXCollections.observableArrayList(rowdata);
        
    }

    // Getters and setters
    public List<Schema> getSchemas() {
        return schemas;
    }
    
    public String getStatus() {
        return status.get();
    }
    public void setStatus(String status) {
        this.status.set(status);
    }
    public StringProperty statusProperty() {
        return status;
    }
    
    public Double getProgress() {
        return progress.get();
    }
    public void setProgress(Double progress) {
        this.progress.set(progress);
    }
    public DoubleProperty progressProperty() {
        return progress;
    }
    
    public final File getXmlFile() {
        return xmlFile.get();
    }
    public final void setXmlFile(File xmlFile) {
        this.xmlFile.set(xmlFile);
    }
    public final ObjectProperty<File> xmlFileProperty() {
        return xmlFile;
    }
    
    
    // Business Logic
    
}
