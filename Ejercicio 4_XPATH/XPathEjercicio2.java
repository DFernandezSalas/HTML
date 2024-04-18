import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XPathEjercicio2 {

	public static void main(String[] args) throws Exception {
		// Tu documento XML como una cadena
		String xmlString = "<library>\r\n"
				+ "  <book id=\"1\">\r\n"
				+ "    <title lang=\"en\">The Great Gatsby</title>\r\n"
				+ "    <author>F. Scott Fitzgerald</author>\r\n"
				+ "    <genre>drama</genre>\r\n"
				+ "    <price>19.99</price>\r\n"
				+ "    <publication_date>1925-04-10</publication_date>\r\n"
				+ "    <description>\r\n"
				+ "      The Great Gatsby is a novel written by F. Scott Fitzgerald, set in the summer of 1922.\r\n"
				+ "      It explores themes of decadence, idealism, and the American Dream.\r\n"
				+ "    </description>\r\n"
				+ "    <availability>\r\n"
				+ "      <status>in_stock</status>\r\n"
				+ "      <quantity>50</quantity>\r\n"
				+ "    </availability>\r\n"
				+ "  </book>\r\n"
				+ "\r\n"
				+ "  <book id=\"2\">\r\n"
				+ "    <title lang=\"en\">To Kill a Mockingbird</title>\r\n"
				+ "    <author>Harper Lee</author>\r\n"
				+ "    <genre>fiction</genre>\r\n"
				+ "    <price>24.99</price>\r\n"
				+ "    <publication_date>1960-07-11</publication_date>\r\n"
				+ "    <description>\r\n"
				+ "      To Kill a Mockingbird is a novel by Harper Lee, set in the American South during the 1930s.\r\n"
				+ "      It addresses issues of racism and injustice.\r\n"
				+ "    </description>\r\n"
				+ "    <availability>\r\n"
				+ "      <status>in_stock</status>\r\n"
				+ "      <quantity>30</quantity>\r\n"
				+ "    </availability>\r\n"
				+ "  </book>\r\n"
				+ "\r\n"
				+ "  <!-- Agregar más libros con información detallada -->\r\n"
				+ "\r\n"
				+ "  <author id=\"101\">\r\n"
				+ "    <name>F. Scott Fitzgerald</name>\r\n"
				+ "    <birth_date>1896-09-24</birth_date>\r\n"
				+ "    <nationality>American</nationality>\r\n"
				+ "    <biography>\r\n"
				+ "      F. Scott Fitzgerald was an American novelist, widely regarded as one of the greatest\r\n"
				+ "      American writers of the 20th century.\r\n"
				+ "    </biography>\r\n"
				+ "  </author>\r\n"
				+ "\r\n"
				+ "  <author id=\"102\">\r\n"
				+ "    <name>Harper Lee</name>\r\n"
				+ "    <birth_date>1926-04-28</birth_date>\r\n"
				+ "    <nationality>American</nationality>\r\n"
				+ "    <biography>\r\n"
				+ "      Harper Lee was an American novelist famous for her influential work, To Kill a Mockingbird.\r\n"
				+ "    </biography>\r\n"
				+ "  </author>\r\n"
				+ "\r\n"
				+ "  <!-- Agregar más autores con información detallada -->\r\n"
				+ "\r\n"
				+ "</library>";

		// Crear un objeto Document a partir de la cadena XML
		Document document = parseXML(xmlString);

		// Crear un objeto XPath
		XPath xpath = XPathFactory.newInstance().newXPath();

		System.out.println("Ejemplo de consulta XPath para obtener los titulos de los libros:");
		String xpathExpression = "/library/book/title";
		NodeList nodeList = (NodeList) xpath.compile(xpathExpression).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.println("Titulo: " + nodeList.item(i).getTextContent());
		}

		System.out.println("\nEjemplo de consulta XPath para obtener los autores de todos los libros:");
		String xpathExpression2 = "/library/book/author";
		NodeList nodeList2 = (NodeList) xpath.compile(xpathExpression2).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList2.getLength(); i++) {
			System.out.println("Autor: " + nodeList2.item(i).getTextContent());
		}
		
		System.out.println("\nEjemplo de consulta XPath para obtener la descripcion de todos los libros:");
		String xpathExpression3 = "/library/book/description";
		NodeList nodeList3 = (NodeList) xpath.compile(xpathExpression3).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList3.getLength(); i++) {
			System.out.println("Descripcion: " + nodeList3.item(i).getTextContent());
		}
		
		System.out.println("\nEjemplo de consulta XPath para obtener autores nacidos antes de 1900:");
		String xpathExpression4 = "/library/author[number(substring(birth_date, 1, 4)) < 1900]/name";
		NodeList nodeList4 = (NodeList) xpath.compile(xpathExpression4).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList4.getLength(); i++) {
			System.out.println("Nombre: " + nodeList4.item(i).getTextContent());
		}

		
		System.out.println("\nEjemplo de consulta XPath para obtener libros con precio mayor a 20:");
		String xpathExpression5 = "/library/book[price > 20]/title";
		NodeList nodeList5 = (NodeList) xpath.compile(xpathExpression5).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList5.getLength(); i++) {
			System.out.println("Titulo: " + nodeList5.item(i).getTextContent());
		}
		
		System.out.println("\nEjemplo de consulta XPath para obtener libros disponibles en stock:");
		String xpathExpression6 = "/library/book[availability/status='in_stock']/title";
		NodeList nodeList6 = (NodeList) xpath.compile(xpathExpression6).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList6.getLength(); i++) {
			System.out.println("Titulo: " + nodeList6.item(i).getTextContent());
		}
		
		System.out.println("\nEjemplo de consulta XPath para obtener la biografia de los autores:");
		String xpathExpression7 = "/library/author/biography";
		NodeList nodeList7 = (NodeList) xpath.compile(xpathExpression7).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList7.getLength(); i++) {
			System.out.println("Biografia: " + nodeList7.item(i).getTextContent());
		}
		
		System.out.println("\nEjemplo de consulta XPath para obtener libros publicados despues de 1950:");
		String xpathExpression8 = "/library/book[number(substring(publication_date, 1, 4)) > 1950]/title";
		NodeList nodeList8 = (NodeList) xpath.compile(xpathExpression8).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList8.getLength(); i++) {
			System.out.println("Titulo: " + nodeList8.item(i).getTextContent());
		}
		
		System.out.println("\nEjemplo de consulta XPath para obtener los autores Americanos:");
		String xpathExpression9 = "/library/author[nationality='American']/name";
		NodeList nodeList9 = (NodeList) xpath.compile(xpathExpression9).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList9.getLength(); i++) {
			System.out.println("Nombre: " + nodeList9.item(i).getTextContent());
		}
		
		System.out.println("\nEjemplo de consulta XPath para obtener la cantidad disponible de cada libro en stock:");
		String xpathExpression10 = "/library/book/availability/quantity";
		NodeList nodeList10 = (NodeList) xpath.compile(xpathExpression10).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList10.getLength(); i++) {
			System.out.println("Cantidad: " + nodeList10.item(i).getTextContent());
		}
		
		
		
		

		
	}

	private static Document parseXML(String xmlString) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		return factory.newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));
	}
}
