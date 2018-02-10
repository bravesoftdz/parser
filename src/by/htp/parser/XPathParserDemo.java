package by.htp.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathParserDemo {

	public static void main(String[] args) {
		try {
			File inputFile = new File(Constant.PATH_TO_XML);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "/dataroot/book";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

			Book book = new Book();
			List<Book> bookList = new ArrayList<>();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String bId = eElement.getElementsByTagName("ID").item(0).getTextContent();
					String bBrief = eElement.getElementsByTagName("BRIEF").item(0).getTextContent();
					String bPublichYear = eElement.getElementsByTagName("PUBLISH_YEAR").item(0).getTextContent();
					String bAuthor = eElement.getElementsByTagName("AUTHOR").item(0).getTextContent();

					book.setId(Integer.valueOf(bId));
					book.setBrief(bBrief);
					book.setPublishYear(Integer.valueOf(bPublichYear));
					book.setAuthor(bAuthor);
					bookList.add(book);

					System.out.println(book);

				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}
}
