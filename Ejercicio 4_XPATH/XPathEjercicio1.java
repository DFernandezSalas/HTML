import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XPathEjercicio1 {

	public static void main(String[] args) throws Exception {
		// Tu documento XML como una cadena
		String xmlString = "<library>\r\n"
				+ "  <book id=\"1\">\r\n"
				+ "    <title lang=\"en\">The Great Gatsby</title>\r\n"
				+ "    <author>F. Scott Fitzgerald</author>\r\n"
				+ "    <genre>drama</genre>\r\n"
				+ "    <price>19.99</price>\r\n"
				+ "    <publication_date>1925-04-10</publication_date>\r\n"
				+ "  </book>\r\n"
				+ "  <book id=\"2\">\r\n"
				+ "    <title lang=\"en\">To Kill a Mockingbird</title>\r\n"
				+ "    <author>Harper Lee</author>\r\n"
				+ "    <genre>fiction</genre>\r\n"
				+ "    <price>24.99</price>\r\n"
				+ "    <publication_date>1960-07-11</publication_date>\r\n"
				+ "  </book>\r\n"
				+ "  <!-- More book entries go here -->\r\n"
				+ "  \r\n"
				+ "  <author id=\"101\">\r\n"
				+ "    <name>F. Scott Fitzgerald</name>\r\n"
				+ "    <birth_date>1896-09-24</birth_date>\r\n"
				+ "    <nationality>American</nationality>\r\n"
				+ "  </author>\r\n"
				+ "  <author id=\"102\">\r\n"
				+ "    <name>Harper Lee</name>\r\n"
				+ "    <birth_date>1926-04-28</birth_date>\r\n"
				+ "    <nationality>American</nationality>\r\n"
				+ "  </author>\r\n"
				+ "  <!-- More author entries go here -->\r\n"
				+ "\r\n"
				+ "  <!-- Additional elements like genres, readers, etc. -->\r\n"
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

		System.out.println("\nEjemplo de consulta XPath para obtener el segundo libro:");
		String xpathExpression2 = "/library/book[2]";
		NodeList nodeList2 = (NodeList) xpath.compile(xpathExpression2).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList2.getLength(); i++) {
			System.out.println("Libro: " + nodeList2.item(i).getTextContent());
		}
		
		System.out.println("\nEjemplo de consulta XPath para obtener los autores");
		String xpathExpression3 = "/library/book/author";
		NodeList nodeList3 = (NodeList) xpath.compile(xpathExpression3).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList3.getLength(); i++) {
			System.out.println("Autor: " + nodeList3.item(i).getTextContent());
		}
		
		System.out.println("\nEjemplo de consulta XPath para obtener libros escritos por F. Scott Fitzgerald:");
		String xpathExpression4 = "/library/book[author='F. Scott Fitzgerald']/title";
		NodeList nodeList4 = (NodeList) xpath.compile(xpathExpression4).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList4.getLength(); i++) {
			System.out.println("Titulo: " + nodeList4.item(i).getTextContent());
		}

		
		System.out.println("\nEjemplo de consulta XPath para obtener libros de drama:");
		String xpathExpression5 = "/library/book[genre='drama']/title";
		NodeList nodeList5 = (NodeList) xpath.compile(xpathExpression5).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList5.getLength(); i++) {
			System.out.println("Titulo: " + nodeList5.item(i).getTextContent());
		}
		
		System.out.println("\nEjemplo de consulta XPath para obtener libros publicados despues de 1950:");
		String xpathExpression6 = "/library/book[publication_date > '1950-01-01']";
		NodeList nodeList6 = (NodeList) xpath.compile(xpathExpression6).evaluate(document, XPathConstants.NODESET);

		// Imprimir resultados
		for (int i = 0; i < nodeList6.getLength(); i++) {
			System.out.println("Titulo: " + nodeList6.item(i).getTextContent());
		}
		

		
	}

	private static Document parseXML(String xmlString) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		return factory.newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));
	}
}
