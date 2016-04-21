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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author peedeeboy
 */
public class InnerProject {
    
    ObjectProperty<File> schemaFile = new SimpleObjectProperty();
    ObjectProperty<File> dataFile = new SimpleObjectProperty();
    ObjectProperty<File> codeFile = new SimpleObjectProperty();
    ObjectProperty<File> bindingsFile = new SimpleObjectProperty();
    
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
    
    public File getBindingsFile() {
        return bindingsFile.get();
    }
    
    public void setBindingsFile(File bindingsFile) {
        this.bindingsFile.set(bindingsFile);
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
        
        
        // Get a list of all element names 
        XPathExpression nameExp = xpath.compile("/xs:element/@name");
        NodeList nameNodes = (NodeList) nameExp.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nameNodes.getLength(); i++) {
                names.add(nameNodes.item(i).getNodeValue());
            }
        
        // Get a list of all element refs 
        XPathExpression refsExp = xpath.compile("/xs:element/@ref");
        NodeList refNodes = (NodeList) nameExp.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < refNodes.getLength(); i++) {
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
    
}
