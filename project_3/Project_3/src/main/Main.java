/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gem.Gems;
import gem.Gems.Gem;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import parsers.DomParser;
import parsers.MySaxParser;
import parsers.StaxParser;

/**
 * class for main execute
 * @author Alex
 */
public class Main {

    /**
     * main
     * @param args no command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        String fileXMLName = "d:\\gem.xml";
        String fileXSDName = "d:\\gem2.xsd";

        //creating schema factory (XMLConstants.W3C_XML_SCHEMA_NS_URI - syntax rules for this schema)
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        //creating new schema (from file)
        Schema schema = schemaFactory.newSchema(new File(fileXSDName));
        //creating new validator from schema
        Validator validator = schema.newValidator();
        //validating file for schema compliance
        System.out.println("validating...");
        validator.validate(new StreamSource(new File(fileXMLName)));
        System.out.println("validating sucess...");

        System.out.println("start jaxb parse xml...");
        //creating new jaxb (java architecture for xml binding) from class "Gems"
        JAXBContext jaxb = JAXBContext.newInstance(Gems.class);
        //creating unmarshaller (deserialisation)
        Unmarshaller unm = jaxb.createUnmarshaller();
        //setting schema to unmarshaller
        unm.setSchema(schema);
        //creating new Gems object and filling it
        Gems gems = (Gems) unm.unmarshal(new FileInputStream(fileXMLName));
        System.out.println("stop jaxb parse xml...");

        for (Gem gem : gems.getGem()) {
            System.out.println(gem);
        }
        
        System.out.println("start dom parse xml...");
        
        //creating new dom parser
        DomParser domParser = new DomParser();
        //parse
        domParser.parse(fileXMLName);
        System.out.println("stop dom parse xml...");

        for (Gem gem : domParser.getList()) {
        System.out.println(gem);
        }
        
        MySaxParser saxParser = new MySaxParser();
        saxParser.parse(fileXMLName);
        
        StaxParser staxParser = new StaxParser();
        staxParser.parse(fileXMLName);
    }

}
