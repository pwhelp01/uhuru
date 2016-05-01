
package uk.ac.richmond.pwhelp01.uhuru.model;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Model class that generates the XML from data in the relational schema
 * @author peedeeboy
 */
public class XmlGenerator {
    
    private ObservableList<Schema> schemas;
    private StringProperty username = new SimpleStringProperty("");
    private StringProperty password = new SimpleStringProperty("");
    private LocalDbDAO localDb;   
    
    private Schema workingSchema;
    private ObjectProperty<File> xmlFile = new SimpleObjectProperty();
    
    Object dbDaoImpl;
    Class<?> dbDAO;
    
    private StringProperty status = new SimpleStringProperty("");
    private DoubleProperty progress = new SimpleDoubleProperty(0.0);
    
    
    // Constructors
    /**
     * Creates a new XmlGenerator instance
     * @throws Exception Error occurred during XML generation
     */
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
    
    public final Schema getWorkingSchema() {
        return workingSchema;
    }
    public final void setWorkingSchema(Schema workingSchema) {
        this.workingSchema = workingSchema;
    }

    public final String getUsername() {
        return username.get();
    }
    public final void setUsername(String username) {
        this.username.set(username);
    }
    public final StringProperty usernameProperty() {
        return username;
    }
    
    public final String getPassword() {
        return password.get();
    }
    public final void setPassword(String password) {
        this.password.set(password);
    }
    public final StringProperty passwordProperty() {
        return password;
    }
    
    
    // Business Logic
    public void process() throws Exception {
        
        updateStatus("Statring", 0);     
        
        // Set status
        updateStatus("Processing", 0.1);
        
        // Load .jar file
        updateStatus("Loading .jar file", 0.3);
        loadJar();
        
        // Clean generate XML
        updateStatus("Generate XML", 0.5);
        generateXml();
    }
    
        /**
     * Load an instance of the DatabaseDAO class from the generated .jar
     * @throws Exception Error occurred loading DatabaseDAO class
     */
    private void loadJar() throws Exception {
        
        // Get generated .jar location
        File jarFile = new File(workingSchema.getJarLocation());
        
        // Create a new URLClassLoader and pass the jar
        URL fileURL = jarFile.toURI().toURL();
        String jarURL = "jar:" + fileURL + "!/";
        
        URL urls [] = { new URL(jarURL) };
        URLClassLoader ucl = new URLClassLoader(urls);
        
        // this is required to load non class files into the jar
        Thread.currentThread().setContextClassLoader(ucl);
        
        // Load instance of DatabaseDAO class
        dbDAO = ucl.loadClass("uk.ac.richmond.DatabaseDAO");
        dbDaoImpl = dbDAO.newInstance();
        
    }

    private void generateXml() throws Exception {
        
        // Use reflection to get the createXml method from the class and add it to the object.  Then invoke it.        
        Method m = dbDAO.getDeclaredMethod("createXml", String.class, String.class, 
                String.class, String.class, String.class, File.class);
        m.invoke(dbDaoImpl, workingSchema.getServer(), workingSchema.getDatabase(), 
                username.get(), password.get(), workingSchema.getRootNode(), xmlFile.get());
    }
    
    /**
     * Update the status message the progress percentage
     * 
     * @param message Status message
     * @param prog Progress percentage
     */
    private void updateStatus(String message, double prog) {
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                status.set(message);
                progress.set(prog);
            }
        });
        
    }
    
    /**
     * Set just the status message
     * 
     * @param message Status message
     */
    public void errorStatus(String message) {
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                status.set(message);
            }
        });
        
    }
}
