package by.htp.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserDemo {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = parserFactor.newSAXParser();
		SAXHandler handler = new SAXHandler();
		parser.parse(Constant.PATH_TO_XML, handler);

		for (Book value : handler.bookList) {
			System.out.println(value);
		}
	}
}

class SAXHandler extends DefaultHandler {

	List<Book> bookList = new ArrayList<>();
	Book book = null;
	String content = null;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		switch (qName) {
		case "book":
			book = new Book();
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "book":
			bookList.add(book);
			break;
		case Constant.TAG_ID:
			book.setId(Integer.valueOf(content));
			break;
		case Constant.TAG_BRIEF:
			book.setBrief(content);
			break;
		case Constant.TAG_PUBLISHER_YEAR:
			book.setPublishYear(Integer.valueOf(content));
			break;
		case Constant.TAG_AUTHOR:
			book.setAuthor(content);
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();
	}

}
