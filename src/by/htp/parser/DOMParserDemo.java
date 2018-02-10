package by.htp.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParserDemo {

	public static void main(String[] args) {
		try {
			File xmlFile = new File(Constant.PATH_TO_XML);
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
			
			document.getDocumentElement().normalize();

			Book book = new Book();
			List<Book> bookList = new ArrayList<>();

			NodeList nodeList = document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(1).getNodeName());
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					String bId = element.getElementsByTagName("ID").item(0).getChildNodes().item(0).getNodeValue();
					String bBrief = element.getElementsByTagName("BRIEF").item(0).getChildNodes().item(0).getNodeValue();
					String bPublishYear = element.getElementsByTagName("PUBLISH_YEAR").item(0).getChildNodes().item(0).getNodeValue();
					String bAuthor = element.getElementsByTagName("AUTHOR").item(0).getChildNodes().item(0).getNodeValue();

					book.setId(Integer.valueOf(bId));
					book.setBrief(bBrief);
					book.setPublishYear(Integer.valueOf(bPublishYear));
					book.setAuthor(bAuthor);

					bookList.add(book);

					System.out.println(book);

				}

			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}
}