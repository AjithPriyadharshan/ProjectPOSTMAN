package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParserClass {
	
	private ArrayList<File> fileObjects = new ArrayList<>();
	private String urlPath = ""; 
	private boolean paramElementPresent = false;
	
	public ArrayList<File> parserMethod() {
		
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        try {
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse("C:\\Program Files\\Apache Software Foundation\\Tomcat 10.0\\webapps\\jaasrealm\\security.xml");
				NodeList urls = doc.getElementsByTagName("urls");
				
				for (int i = 0; i < urls.getLength(); i++) {
					
					Node urlsNode = urls.item(i);
					
					if (urlsNode.getNodeType() == Node.ELEMENT_NODE) {
						Element urlsElement = (Element) urlsNode;
						NodeList urlsChildElements = urlsElement.getChildNodes(); // URLS childelements
						
						for(int j = 0; j < urlsChildElements.getLength(); j++) {
							
							Node urlsChildElementNode = urlsChildElements.item(j);
							
							if(urlsChildElementNode.getNodeType() == Node.ELEMENT_NODE && urlsChildElementNode.getNodeName().equals("url") && urlsChildElementNode.hasChildNodes()) {
								Element url = (Element) urlsChildElementNode;
								NodeList urlChildElements = url.getChildNodes(); //URL childelements
								
								urlPath = url.getAttribute("path"); // URL path attribute
								ArrayList<String> param = new ArrayList<>(); // Param names list for the particular URL
								
								for(int k = 0; k < urlChildElements.getLength(); k++) {
									Node urlChildElementNode = urlChildElements.item(k);
									
									if (urlChildElementNode.getNodeType() == Node.ELEMENT_NODE && urlChildElementNode.getNodeName().equals("param")) {
										Element paramName = (Element) urlChildElementNode;
										param.add(paramName.getAttribute("name"));
										paramElementPresent = true; // checking if the param element is present or not
									}
									
									if (paramElementPresent && k == urlChildElements.getLength() -1) {
										
										File fileObj = new File(urlPath,param); 
										fileObjects.add(fileObj); // object containg url and its respective param names is added in a list which is returned by the method call
										paramElementPresent = false;
									}
								}
							}
						}
					}
				}
			} catch (ParserConfigurationException | SAXException | IOException e) {
				e.printStackTrace();
			}
	        return fileObjects;
	}
}
