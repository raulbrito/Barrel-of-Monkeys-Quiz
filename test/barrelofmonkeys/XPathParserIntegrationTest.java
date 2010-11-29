package barrelofmonkeys;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class XPathParserIntegrationTest {

	@Test
	public void testXpathTextValueResultFromFile() throws Exception {
		XPathFileParser xPathParser = new XPathFileParser("test/example.xml");
		
		List<String> result = xPathParser.xpathValue("//car/text()");
		assertEquals(Arrays.asList("Volvo", "Honda", "Renault", "Mercedes"), result);
	}
	
	@Test
	public void testXPathAttributeResultFromFile() throws Exception {
		XPathFileParser xPathParser = new XPathFileParser("test/example.xml");
		
		List<String> result = xPathParser.xpathAttribute("//car", "country");

		assertEquals(Arrays.asList("Sweden", "Japan", "France", "Germany"), result);
	}
	
	@Test
	public void testXPathAttributeOfNestedResulFromFile() throws Exception {
		XPathFileParser xPathParser = new XPathFileParser("test/example.xml");
		
		List<String> result = xPathParser.xpathAttribute("//cars[@type='Cheap']/car", "country");

		assertEquals(Arrays.asList("Sweden", "Japan", "France"), result);
		
	}

}
