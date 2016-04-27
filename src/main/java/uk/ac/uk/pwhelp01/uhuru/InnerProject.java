/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.uk.pwhelp01.uhuru;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.namespace.NamespaceContext;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author peedeeboy
 */
public class InnerProject {
    
    Settings settings = new Settings();
    
    ObjectProperty<File> schemaFile = new SimpleObjectProperty();
    ObjectProperty<File> dataFile = new SimpleObjectProperty();
    ObjectProperty<File> codeFile = new SimpleObjectProperty();
    ObjectProperty<File> bindingsFile = new SimpleObjectProperty();
    StringProperty server = new SimpleStringProperty("");
    StringProperty database = new SimpleStringProperty("");
    StringProperty username = new SimpleStringProperty("");
    StringProperty password = new SimpleStringProperty("");
    
    StringProperty status = new SimpleStringProperty();
    DoubleProperty progress = new SimpleDoubleProperty();
    
    String workingDirectory = settings.getInnerProjectDir();
    String resourcesDirectory = workingDirectory + "/src/main/resources/";
    String pomFile = workingDirectory + "/pom.xml";
    String jarLocation = workingDirectory + "/target/innerproject-1.jar";
    String jarTargetDirectory = settings.getUhuruDir() + "/jars/";
    String jarDest = "";
    String schemaRoot = "";
    
    File mavenHome = new File(settings.getMavenDir());
    Invoker invoker = new DefaultInvoker();
    
    Object dbDaoImpl;
    Class<?> dbDAO;
    LocalDbDAO localDb;

    // Constructors
    public InnerProject() {
        
        // Set the Maven home directory
        invoker.setMavenHome(mavenHome);
        
    }
    
    
    // Getters and setters
    public final File getSchemaFile() {
        return schemaFile.get();
    }
    public final void setSchemaFile(File schemaFile) {
        this.schemaFile.set(schemaFile);
    }
    public final ObjectProperty<File> schemaFileProperty() {
        return schemaFile;
    }
    
    public final File getDataFile() {
        return dataFile.get();
    }
    public final void setDataFile(File dataFile) {
        this.dataFile.set(dataFile);
    }
    public final ObjectProperty<File> dataFileProperty() {
        return dataFile;
    }
    
    public final File getCodeFile() {
        return codeFile.get();
    }
    public final void setCodeFile(File codeFile) {
        this.codeFile.set(codeFile);
    }
    public final ObjectProperty<File> codeFileProperty() {
        return codeFile;
    }
    
    public final File getBindingsFile() {
        return bindingsFile.get();
    }
    public final void setBindingsFile(File bindingsFile) {
        this.bindingsFile.set(bindingsFile);
    }
    public final ObjectProperty<File> bindingsFileProperty() {
        return bindingsFile;
    }
    
    public final String getServer() {
        return server.get();
    }
    public final void setServer(String server) {
        this.server.set(server);
    }
    public final StringProperty serverProperty() {
        return server;
    }
    
    public final String getDatabase() {
        return database.get();
    }
    public final void setDatabase(String database) {
        this.database.set(database);
    }
    public final StringProperty databaseProperty() {
        return database;
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
 
    public final String getStatus() {
        return status.get();
    }
    public final void setStatus(String status) {
        this.status.set(status);
    }
    public final StringProperty statusProperty() {
        return status;
    }
    
    public final double getProgress() {
        return progress.get();
    }
    public final void setProgress(double progress) {
        this.progress.set(progress);
    }
    public final DoubleProperty progressProperty() {
        return progress;
    }
    
    
    public void cleanProject() throws Exception {
        
        InvocationRequest request = new DefaultInvocationRequest();
        final List<String> MAVEN_GOALS = Collections.singletonList("clean");
        
        request.setPomFile(new File(pomFile));
        request.setGoals(MAVEN_GOALS);
        
        InvocationResult result = invoker.execute(request);
        final int EXIT_CODE = result.getExitCode();
        
        System.out.println("Maven exited with code " + EXIT_CODE);
        
        if(EXIT_CODE != 0) {
            System.out.println(result.getExecutionException().getMessage());
            throw new IllegalStateException();
        }
    }
    
    public void invokeMaven() throws MavenInvocationException, IllegalStateException {
        
        InvocationRequest request = new DefaultInvocationRequest();
        final List<String> MAVEN_GOALS = Arrays.asList("clean", "dependency:copy-dependencies", "install", "package");
        
        request.setPomFile(new File(pomFile));
        request.setGoals(MAVEN_GOALS);

        InvocationResult result = invoker.execute(request);
        System.out.println("Maven exited with code " + result.getExitCode());
        
        if(result.getExecutionException() != null) {
            throw new IllegalStateException();
        }
    }
        
    public void copyFiles() throws IOException {

        File schemaDest = new File(resourcesDirectory + schemaFile.get().getName());
        File dataDest = new File(resourcesDirectory + dataFile.get().getName());
        File codeDest = new File(resourcesDirectory + codeFile.get().getName());
        File bindingsDest = new File(resourcesDirectory + bindingsFile.get().getName());
        

        Files.copy(schemaFile.get(), schemaDest);
        Files.copy(dataFile.get(), dataDest);
        Files.copy(codeFile.get(), codeDest);
        Files.copy(bindingsFile.get(), bindingsDest);
    }
    
    
    public void deleteFiles() throws IOException {
        
        File directory = new File(resourcesDirectory);
        
        for(File file: directory.listFiles()) {
            // Don't delete persistance.properties!
            if(!file.getName().equals("persistence.properties")) {
                file.delete();
            }
        }
    }
    
    public void copyJar()throws IOException {
        
        jarDest = jarTargetDirectory + server.get()+ "-" + database.get() + ".jar";
        
        File jarSourceFile = new File(jarLocation);
        File jarDestFile = new File(jarDest);
        
        Files.copy(jarSourceFile, jarDestFile);
        
    }
    
    
    public void getSchemaRoot() throws Exception {
        
        // Create set to hold names and refs
        List<String> names = new ArrayList();
        List<String> refs = new ArrayList();
        
        // Create XML factory
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        docFactory.setNamespaceAware(true);
        DocumentBuilder docBuilder;
        Document doc = null;
        
        // Parse XSD
        docBuilder = docFactory.newDocumentBuilder();
        doc = docBuilder.parse(schemaFile.get());
        
        // Create XPathFactory
        XPathFactory xpathFactory = XPathFactory.newInstance();

        // Create XPath object
        XPath xpath = xpathFactory.newXPath();
        
        // Set namespace context for XML Schema
        NamespaceContext nsContext = new NamespaceContext() {

                @Override
                public String getNamespaceURI(String prefix) {
                    return "http://www.w3.org/2001/XMLSchema";
                }

                @Override
                public String getPrefix(String namespaceURI) {
                    return "xs";
                }

                @Override
                public Iterator getPrefixes(String namespaceURI) {
                    Set s = new HashSet();
                    s.add("xs");
                    return s.iterator();
                }

            };
        xpath.setNamespaceContext(nsContext);

        // Get a list of all element names 
        XPathExpression nameExp = xpath.compile("//xs:element/@name");
        NodeList nameNodes = (NodeList) nameExp.evaluate(doc, XPathConstants.NODESET);
        for(int i = 0; i < nameNodes.getLength(); i++) {
            names.add(nameNodes.item(i).getNodeValue());
        }

        // Get a list of all element refs 
        XPathExpression refsExp = xpath.compile("//xs:element/@ref");
        NodeList refNodes = (NodeList) refsExp.evaluate(doc, XPathConstants.NODESET);
        for(int i = 0; i < refNodes.getLength(); i++) {
            refs.add(refNodes.item(i).getNodeValue());
        }    
       
        // Work out the root element by substracting refs from names
        names.removeAll(refs);     
        
        // If there is anything other than one element name left, something is wrong!
        if(names.size() != 1) {
            throw new IllegalStateException("Schema file should contain one root element");
        }
        
        schemaRoot =  names.get(0);
            
    }
    
    
    public void loadJar() throws Exception {
        /*
        // Create new Jar ClassLoader
        JarClassLoader jcl = new JarClassLoader();
        
        // Add generated Jar, and load a DatabaseDAO class and object
        jcl.add(jarLocation);
        // jcl.add(workingDirectory + "/target/lib/");
        JclObjectFactory jclFactory = JclObjectFactory.getInstance();
        dbDaoImpl = jclFactory.create(jcl, "uk.ac.richmond.DatabaseDAO");
        dbDAO = jcl.loadClass("uk.ac.richmond.DatabaseDAO");
        */
        
        File jarFile = new File(jarLocation);
        
        URL fileURL = jarFile.toURI().toURL();
        String jarURL = "jar:" + fileURL + "!/";
        
        URL urls [] = { new URL(jarURL) };
        URLClassLoader ucl = new URLClassLoader(urls);
        
        // this is required to load file (such as spring/context.xml) into the jar
        Thread.currentThread().setContextClassLoader(ucl);
        
        dbDAO = ucl.loadClass("uk.ac.richmond.DatabaseDAO");
        dbDaoImpl = dbDAO.newInstance();
        
    }
    
    
    public void createSchema() throws Exception {
        
        // Use reflection to get the createSchema method from the class and add it to the object.  Then invoke it.        
        Method m = dbDAO.getDeclaredMethod("createSchema", String.class, String.class, String.class, String.class);
        m.invoke(dbDaoImpl, server.get(), database.get(), username.get(), password.get());
        
    }
    
    
    public void process() throws Exception, IOException, MavenInvocationException {
        
        String schemaRoot = "";
        updateStatus("Statring", 0);     
        
        // Set status
        updateStatus("Processing", 0.1);
        
        // Clean out the innerproject resources folder
        updateStatus("Deleting old files", 0.2);
        deleteFiles();
        
        // Clean inner project
        updateStatus("Cleaning inner project", 0.3);
        cleanProject();
        
        // Copy files needed to build project
        updateStatus("Copying .XSD and .XJB files", 0.4);
        copyFiles();
            
        // Build inner project
        updateStatus("Building inner project", 0.5);
        invokeMaven();
        
        // Loading JAR file
        updateStatus("Loading generated .jar file", 0.55);
        loadJar();
        
        // Get root element of Schema file
        updateStatus("Calculating root element of schema", 0.6);
        getSchemaRoot();
        
        // Create schema
        updateStatus("Creating database schema", 0.7);
        createSchema();
        /*
        // Populate lookups
        updateStatus("Populating lookup tables", 0.8);
        populateLookups();
        */
        
        // Copy .jar file
        updateStatus("Copying .jar file", 0.9);
        copyJar();
        
        // Update metadata in local DB
        updateStatus("Writing metadata to local database", 0.95);
        updateLocalDb();
        
        // All done!
        updateStatus("Success!", 1.0);

    }
    
    
    private void populateLookups() throws XPathExpressionException, SAXException, 
            IOException, ParserConfigurationException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException {
        
        // Create set to hold names and refs
        List<String> names = new ArrayList();
        Method m = dbDAO.getDeclaredMethod("populateLookup", String.class, String.class, String.class, String.class, String.class, String.class);
        
        // Create XML factory
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        docFactory.setNamespaceAware(true);
        DocumentBuilder docBuilder;
        Document doc = null;
        
        // Parse XSD
        docBuilder = docFactory.newDocumentBuilder();
        doc = docBuilder.parse(codeFile.get());
        
        // Create XPathFactory
        XPathFactory xpathFactory = XPathFactory.newInstance();

        // Create XPath object
        XPath xpath = xpathFactory.newXPath();
        
        // Set namespace context for XML Schema
        NamespaceContext nsContext = new NamespaceContext() {

                @Override
                public String getNamespaceURI(String prefix) {
                    return "http://www.w3.org/2001/XMLSchema";
                }

                @Override
                public String getPrefix(String namespaceURI) {
                    return "xs";
                }

                @Override
                public Iterator getPrefixes(String namespaceURI) {
                    Set s = new HashSet();
                    s.add("xs");
                    return s.iterator();
                }

            };
        xpath.setNamespaceContext(nsContext);
        
        
        // Get a list of all simpletype names 
        XPathExpression nameExp = xpath.compile("//xs:simpleType/@name");
        NodeList nameNodes = (NodeList) nameExp.evaluate(doc, XPathConstants.NODESET);
        for(int i = 0; i < nameNodes.getLength(); i++) {
            names.add(nameNodes.item(i).getNodeValue());
        }
        
        // Cycle through each simple type and process
        for(String name : names) {
            
            updateStatus("Populating lookup: " + name, 0.8);
            // Create a list to hold the simpleType values
            List<String> values = new ArrayList();
            
            // Create XPath expression
            String exp = "//xs:simpleType[@name='" + name + "']/xs:restriction/xs:enumeration/@value";
            
            // Get simpleType values
            XPathExpression valueExp = xpath.compile(exp);
            NodeList valueNodes = (NodeList) valueExp.evaluate(doc, XPathConstants.NODESET);
            for(int i = 0; i < valueNodes.getLength(); i++) {
                values.add(valueNodes.item(i).getNodeValue());
            }
            
            // Process individual values
            for(String value : values) {
                // Use reflection to get the populateLookup method from the class and add it to the object.  Then invoke it.        
                m.invoke(dbDaoImpl, server.get(), database.get(), username.get(), password.get(), name, value);
            }  
        }     
    }
    
    public void updateLocalDb() throws ClassNotFoundException, SQLException {
        
        // Create new localDB instance
        localDb = new LocalDbDAO();
        
        // Save metadata about generated .jar file to the local DB
        localDb.updateSchema(server.get(), database.get(), schemaRoot, jarLocation);
    }
    
    // Helper methods
    private void updateStatus(String message, double prog) {
        
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                status.set(message);
                progress.set(prog);
            }
        });
        
    }
    
}
