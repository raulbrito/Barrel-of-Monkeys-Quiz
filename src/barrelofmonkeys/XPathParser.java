package barrelofmonkeys;

import java.util.List;

public interface XPathParser {
	
	List<String> xpathValue(String xpathString) throws Exception;
	
	List<String> xpathAttribute(String xpathString, String attribute) throws Exception;

}
