/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.richmond;

import generated.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author pete
 */
public class HESA {
    
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private JAXBContext context;
    private ObjectFactory objectFactory;
    private Unmarshaller unmarshaller;
    private Marshaller marshaller;
    
    public HESA() {
        try {
            context = JAXBContext.newInstance("generated");
            objectFactory = new ObjectFactory();
            unmarshaller = context.createUnmarshaller();
            marshaller = context.createMarshaller();
        }
        catch(Exception e) {}
    }
    
    public void createDatabase() {
        
        final Properties persistenceProperties = new Properties();
        InputStream is = null;

        try {
            is = getClass().getClassLoader().getResourceAsStream("persistence.properties");
            persistenceProperties.load(is);
        } 
        catch (IOException ignored) {};

                
        entityManagerFactory = Persistence.createEntityManagerFactory("generated", persistenceProperties);
        
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
    }
    
    public void createXML() {
        
        final Properties persistenceProperties = new Properties();
        InputStream is = null;
        
        try {
            is = getClass().getClassLoader().getResourceAsStream("persistence.properties");
            persistenceProperties.load(is);
        } 
        catch (IOException ignored) {
            ignored.printStackTrace();
        };
        
        entityManagerFactory = Persistence.createEntityManagerFactory("generated", persistenceProperties);
        entityManager = entityManagerFactory.createEntityManager();
        
        
        Integer id = 10005470;
        
        APStudentRecord root = new APStudentRecord();
        Provider provider = entityManager.find(Provider.class, id);
        
        root.setProvider(provider);
        
        DOMResult xml = new DOMResult();
        try {
            marshaller.marshal(root, xml);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        

        Source source = new DOMSource(xml.getNode());
        File file = new File("src/test/samples/hesa.xml");
        Result result = new StreamResult(file);
        
        try {
        Transformer transformer = TransformerFactory
                                    .newInstance()
                                    .newTransformer();
        
        
            transformer.transform(source, result);
            
        }
        catch (Exception ignored){
            ignored.printStackTrace();
        }
        
        entityManager.close();
        
    }
}
