package barrelofmonkeys;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


/**
 * uses XPath to retrieve information from an XML file
 * ATTENTION: use only for simple values and attributes
 * @author raul
 *
 */
public class XPathFileParser implements XPathParser {
	
	Document doc;

	public XPathFileParser(String string) throws Exception {
	   DocumentBuilderFactory domFactory = 
		    DocumentBuilderFactory.newInstance();
		          domFactory.setNamespaceAware(true); 
		    DocumentBuilder builder = domFactory.newDocumentBuilder();
		    doc = builder.parse(string);
	}

	public List<String> xpathValue(String xpathString) throws Exception {
		
		List<String> resultList = new ArrayList<String>();
	    NodeList nodes = retrieveNodeList(xpathString);
	    for (int i = 0; i < nodes.getLength(); i++) {
	     resultList.add((nodes.item(i).getNodeValue())); 
	    }
	    
	    return resultList;
	}
	
	public List<String> xpathAttribute(String xpathString, String attribute) throws Exception {
		
		List<String> resultList = new ArrayList<String>();
		
	    NodeList nodes = retrieveNodeList(xpathString);
	    for (int i = 0; i < nodes.getLength(); i++) {
	     resultList.add((nodes.item(i).getAttributes().getNamedItem(attribute).getNodeValue())); 
	    }
	    
	    return resultList;
	}

	private NodeList retrieveNodeList(String xpathString)
			throws XPathExpressionException {
		XPath xpath = XPathFactory.newInstance().newXPath();
	    XPathExpression expr = xpath.compile(xpathString);

	    Object result = expr.evaluate(doc, XPathConstants.NODESET);
	    NodeList nodes = (NodeList) result;
		return nodes;
	}

}
