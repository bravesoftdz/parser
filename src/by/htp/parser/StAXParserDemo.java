package by.htp.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXParserDemo {

	public static void main(String[] args) throws XMLStreamException, FileNotFoundException {

		List<Book> bookList = null;
		Book currBook = null;
		String tagContent = null;
		XMLInputFactory factory = XMLInputFactory.newInstance();
		FileInputStream fileXml = new FileInputStream(Constant.PATH_TO_XML);
		XMLStreamReader reader = factory.createXMLStreamReader(fileXml);

		while (reader.hasNext()) {
			int event = reader.next();

			switch (event) {
			case XMLStreamConstants.START_ELEMENT:
				if ("book".equals(reader.getLocalName())) {
					currBook = new Book();
					bookList = new ArrayList<>();
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				tagContent = reader.getText().trim();
				break;

			case XMLStreamConstants.END_ELEMENT:
				switch (reader.getLocalName()) {
				case "book":
					bookList.add(currBook);
					System.out.println(bookList);
					break;
				case Constant.TAG_ID:
					currBook.setId(Integer.valueOf(tagContent));
					break;
				case Constant.TAG_BRIEF:
					currBook.setBrief(tagContent);
					break;
				case Constant.TAG_PUBLISHER_YEAR:
					currBook.setPublishYear(Integer.valueOf(tagContent));
					break;
				case Constant.TAG_AUTHOR:
					currBook.setAuthor(tagContent);
					break;
				}

				break;

			case XMLStreamConstants.START_DOCUMENT:
				bookList = new ArrayList<>();
				break;
			}
		}
	}
}
