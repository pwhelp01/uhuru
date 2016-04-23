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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.namespace.NamespaceContext;
import org.apache.maven.cli.MavenCli;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JclObjectFactory;

/**
 *
 * @author peedeeboy
 */
public class InnerProject {
    
    ObjectProperty<File> schemaFile = new SimpleObjectProperty();
    ObjectProperty<File> dataFile = new SimpleObjectProperty();
    ObjectProperty<File> codeFile = new SimpleObjectProperty();
    ObjectProperty<File> bindingsFile = new SimpleObjectProperty();
    StringProperty server = new SimpleStringProperty("");
    StringProperty database = new SimpleStringProperty("");
    StringProperty username = new SimpleStringProperty("");
    StringProperty password = new SimpleStringProperty("");
    
    StringProperty buildMessage = new SimpleStringProperty();
    DoubleProperty buildStatus = new SimpleDoubleProperty();
    
    MavenCli cli = new MavenCli();
    String workingDirectory = System.getProperty("user.dir") + "/innerproject";
    String[] args = {"--version"}; //{"clean", "--errors", "-l test.log", "--debug"}; //{"clean", "compile", "dependency:copy-dependencies"};
    PrintStream stdout = System.out;
    PrintStream stderr = System.out;
    
    String resourcesDirectory = workingDirectory + "/src/main/resources/";
    String pomFile = (workingDirectory + "/pom.xml");
    
    
    // Constructors
    public void InnerProject() {}
    
    
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
    
    public void cleanProject() throws Exception {
        
        InvocationRequest request = new DefaultInvocationRequest();
        final List<String> MAVEN_GOALS = Collections.singletonList("clean");
        
        request.setPomFile(new File(pomFile));
        request.setGoals(MAVEN_GOALS);
        
        Invoker invoker = new DefaultInvoker();
        // Set maven location?
        
        InvocationResult result = invoker.execute(request);
        final int EXIT_CODE = result.getExitCode();
        
        System.out.println("Maven exited with code " + EXIT_CODE);
        
        if(EXIT_CODE != 0) {
            System.out.println("Hello");
            System.out.println(result.getExecutionException().getMessage());
            System.out.println("Goodbye");
            throw new IllegalStateException();
        }
    }
    
    public void invokeMaven() throws MavenInvocationException, IllegalStateException {
        
        InvocationRequest request = new DefaultInvocationRequest();
        final List<String> MAVEN_GOALS = Arrays.asList("clean", "install", "package");
        
        request.setPomFile(new File(pomFile));
        request.setGoals(MAVEN_GOALS);
        
        Invoker invoker = new DefaultInvoker();
        // invoker.setMavenHome(null)

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
    
    
    public String getSchemaRoot() throws Exception {
        
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
        
        System.out.println("Names");
        names.forEach(x -> System.out.println(x));
        System.out.println ("Refs");
        refs.forEach(x -> System.out.println(x));
        
            
        // Work out the root element by substracting refs from names
        names.removeAll(refs);
        
        System.out.println("Remaining names");
        names.forEach(x -> System.out.println(x));
        
        
        // If there is anything other than one element name left, something is wrong!
        if(names.size() != 1) {
            throw new IllegalStateException("Schema file should contain one root element");
        }
        
        return names.get(0);
            
    }
    
    public void createSchema() throws Exception {
        
        JarClassLoader jcl = new JarClassLoader();
        jcl.add("/home/peedeeboy/git/uhuru/innerproject/target/innerproject-1.jar");
        JclObjectFactory jclFactory = JclObjectFactory.getInstance();
        Object dbDaoImpl = jclFactory.create(jcl, "uk.ac.richmond.DatabaseDAO");
        
        Class<?> dbDAO = jcl.loadClass("uk.ac.richmond.DatabaseDAO");
        
        Method mths[] = dbDAO.getMethods();
        for(Method x : mths) {
            System.out.println(x.toGenericString());
        }
                
        Method m = dbDAO.getDeclaredMethod("createSchema", String.class, String.class, String.class, String.class);
        String args[] = new String[] {server.get(), database.get(), username.get(), password.get()};
        m.invoke(dbDaoImpl, server.get(), database.get(), username.get(), password.get());
        
    }
    
}
